package co.in.functional;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import co.in.support.Student;
import co.in.support.StudentDataBase;

/*
 * Function interface has to arguments
 * first one is input type
 * second one is return type
 */

/*
 * last there is also implementaion of bifunctionl interface
 */
public class Functionn {
	
	static Function<String, String > f1 = (string) -> string.toUpperCase();
	
	static Function<String, String > f2 = (string) -> string.concat("defalut");
	
	
	public static void main(String[] args) {
		/*
		 * Using function interface
		 */
		System.out.println("Normally  "+f1.apply("java8"));
		
		/*
		 * using andthen method in function
		 * it first executes the first to last function interface
		 */
		
		System.out.println("using andthen  "+f1.andThen(f2).apply("java8"));
		
		/*
		 * using compose method in function
		 * it executes last to first function interface
		 */
		
		System.out.println("using compose  "+f1.compose(f2).apply("java8"));
		
		/*
		 * Use case by student database
		 * get the students name and their grades
		 */
		System.out.println("\n************ Student names and grades **********");
		getStudentNameAndGrades();
		
		System.out.println("\n\n*********Using Bifunctional*************");
		bifunctionalExample();
		
	}
	
	public static void getStudentNameAndGrades() {
		Function<List<Student>, Map<String,Integer>> f = (student)->{
			Map<String,Integer> map = new HashMap<>();
			student.forEach(s ->{
				map.put(s.getName(), s.getGradeLevel());
			});
			return map;
		};
		/*
		 * using predicate
		 */
		Function<List<Student>, Map<String,Integer>> f2 = (student)->{
			Map<String,Integer> map = new HashMap<>();
			student.forEach(s ->{
				if(Predicatee.p1.test(s.getGradeLevel()))
					map.put(s.getName(), s.getGradeLevel());
			});
			return map;
		};
		
		System.out.println(f.apply(StudentDataBase.getAllStudents()));
		System.out.println("\n****using predicate*****");
		System.out.println(f2.apply(StudentDataBase.getAllStudents()));
	}
	
/*
 * this method is for bifunctional example
 * Bifunctional functional interface usally takes two inputs and gives a output.
 * first two are input parameters and last one is output
 */
	private static void bifunctionalExample() {
		BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> bf = (listStudent,predicate) ->{
			Map<String, Double> map = new HashMap<>();
			listStudent.forEach(student->{
				if(predicate.test(student))
					map.put(student.getName(), student.getGpa());
			});
			return map;
		};
		
		Predicate<Student> p1 = (student) -> student.getGpa()>=3.9;
		System.out.println(bf.apply(StudentDataBase.getAllStudents(), p1));
		
	}


}
