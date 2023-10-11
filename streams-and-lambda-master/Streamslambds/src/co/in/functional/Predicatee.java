package co.in.functional;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import co.in.support.Student;
import co.in.support.StudentDataBase;

/*
 * Predicate interface implementations
 * prediate basically returns the true or false values as per given condition
 * There are basically three defalut methods OR, NEGATE & AND
 */

/*
 * Here last we have the example of bipredicate also
 */
public class Predicatee {
	
	public static void main(String[] args) {
		
		/*
		 * this is simple predicate example to check number is even or odd
		 */
		Predicate<Integer> p = (i)-> i%2==0;
		System.out.println(p.test(20));
		
		System.out.println("\n********Predicate AND *********");
		predicateAnd();
		
		System.out.println("\n********Predicate OR *********");
		predicateOR();
		
		System.out.println("\n********Predicate NEGATE *********");
		predicateNEGATE();
		
		System.out.println("\n********Predicate filterStudentByGradeLevel *********");
		filterStudentByGradeLevel();
		
		System.out.println("\n********Predicate filter Student By Gpa *********");
		filterStudentByGpa();
		
		System.out.println("\n********Predicate filter Student By Gpa and grade *********");
		filterStudentByGpaandgrade();
		
		System.out.println("\n********BiPredicate filter Student By Gpa and grade - Bipredicate *********");
		filterStudentByGpaandgradeUsingBipredicate();

	}

	
	/*
	 * Created predicates 
	 * First check that number is divisible by 3 or not
	 * and second check that number is divisible by 5 or not
	 */
	static Predicate<Integer> p1 = (i) -> i%3==0;
	

	
//	Predicate<Integer> i = new Predicate<Integer>() {
//		@Override
//		public boolean test(Integer t) {
//			// TODO Auto-generated method stub
//			return false;
//		}
//	} ;
	static Predicate<Integer> p2 = (i) -> i%5==0;
	
	public static void  predicateAnd() {
		
		/*
		 * In AND if both the results are true then only output is true or else its false
		 */
		System.out.println("Using value 12 "+p1.and(p2).test(12)); // predicate chaining
		System.out.println("Using value 15 "+p1.and(p2).test(15));
		
	}
	
	
	
	private static void predicateOR() {
		
		/*
		 * In OR if any one of the  results is true then output is true or else its false
		 */
		System.out.println("Using value 12 "+p1.or(p2).test(12)); // predicate chaining
		System.out.println("Using value 15 "+p1.or(p2).test(15));
	}

	
	private static void predicateNEGATE() {
		
		/*
		 * In negate output is reversed
		 */
		System.out.println("Using value 12 "+p1.and(p2).negate().test(12)); // predicate chaining
		System.out.println("Using value 15 "+p1.and(p2).negate().test(15));		
	}
	/*
	 * This method is used to filter student by grade level using predicate
	 */
	public static void filterStudentByGradeLevel() {
		List<Student> lst = StudentDataBase.getAllStudents();
		/*
		 * This predicate will return true if the student grade level is greater than or equal to 3
		 */
		Predicate<Student> p1 = (s) -> s.getGradeLevel() >=3;
		
		lst.forEach(student->{
			if(p1.test(student)) {
				System.out.println(student);
			}
		});
	}
	
	/*
	 * This method is used to filter student by gpa using predicate
	 */
	private static void filterStudentByGpa() {
		List<Student> lst = StudentDataBase.getAllStudents();
		/*
		 * This predicate will return true if the student gpa is greater than or equal to 3.9
		 */
		Predicate<Student> p1 = (s) -> s.getGpa() >=3.9;
		
		lst.forEach(student->{
			if(p1.test(student)) {
				System.out.println(student);
			}
		});
	}
	
	/*
	 * This method is used to filter student by gpa and grade level both using predicate
	 */
	private static void filterStudentByGpaandgrade() {
		List<Student> lst = StudentDataBase.getAllStudents();
		/*
		 * This predicate will return true if the student gpa is greater than or equal to 3.9
		 */
		Predicate<Student> p1 = (s) -> s.getGpa() >=3.9;
		
		/*
		 * This predicate will return true if the student grade level is greater than or equal to 3
		 */
		Predicate<Student> p2 = (s) -> s.getGradeLevel() >=3;
		
		/*
		 * using AND --both conditions should be met 
		 */
		System.out.println("\n****Using AND******");
		lst.forEach(student->{
			if(p1.and(p2).test(student)) {
				System.out.println(student);
			}
		});
		
		System.out.println("\n****Using OR******");
		/*
		 * using OR --Any one condition be true 
		 */
		lst.forEach(student->{
			if(p1.or(p2).test(student)) {
				System.out.println(student);
			}
		});
		
		
	}
	/*
	 * This method is used to filter student by gpa and grade level both using Bipredicate
	 */
	private static void filterStudentByGpaandgradeUsingBipredicate() {
		List<Student> lst = StudentDataBase.getAllStudents();
		/*
		 * This Bipredicate will return true or false as per condition
		 */
		BiPredicate<Integer,Double> p1 = (grade,gpa) -> {
			if(grade>=3 && gpa >=3.9)
				return true;
			return false;
		};
		
		lst.forEach(student->{
			if(p1.test(student.getGradeLevel(), student.getGpa())) {
				System.out.println(student);
			}
		});
		
	}

}
