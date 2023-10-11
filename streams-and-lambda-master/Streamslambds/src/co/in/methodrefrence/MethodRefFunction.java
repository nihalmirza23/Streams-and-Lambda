package co.in.methodrefrence;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import co.in.support.Student;
import co.in.support.StudentDataBase;

/*
 * This class has method refrence implemetations.
 */
public class MethodRefFunction {
	public static void main(String[] args) {
		
		/*
		 * Function Interface Implementation Using Method Reference
		 */
		System.out.println("\n*****Function Interface Implementation Using Method Reference******");
		FuncImp();
		
		System.out.println("\n*****************************************************************\n");
		
		/*
		 * Consumer Interface Implementation Using Method Reference
		 */
		System.out.println("\n*****Consumer Interface Implementation Using Method Reference******");
		ConsumerImp();
		
		/*
		 * refactor the lambda expression using the method refrence
		 */
		System.out.println("\n\n****refactor the lambda expression using the method refrence****\n");
		refactorlambda();
	}

	public static void FuncImp() {
		/*
		 * How to use the method refrence for the Function functionl interface.
		 */
		// Using lambda expression
		Function<String, String > f1 = (string) -> string.toUpperCase();
		
		//using method refrence
		Function<String, String > f2 = String::toUpperCase; 
		
		System.out.println("using lambda            " + f1.apply("java8"));
		System.out.println("using method refrence   " + f2.apply("java8"));
		
	}
	
	
	private static void ConsumerImp() {
		
		// Using lambda expression
		System.out.println("\n*****Using lambda*********");
		
		Consumer<Student> c1 = (student) -> System.out.println(student);
		StudentDataBase.getAllStudents().forEach(c1);
		
//		//using method refrence
		System.out.println("\n*****Using Method refrence*********");
		
		/*
		 * here prinltln method should have the method argumnet to take the student.
		 */
		Consumer<Student> c2 =System.out::println;
		StudentDataBase.getAllStudents().forEach(c2);
		
		/*
		 * using student class method get all activities by method refrence
		 * This is a method refrence by instance method.
		 * Here as prinListOfActivities has no input feild but for calling the method 
		 * we need to create a object of the same class and then only we can call the method
		 * as here the student from the list passed was be taken and the method for the 
		 * same object will be called
		 */
		System.out.println("\n*******Get all Activities using method refrence*********");
		Consumer<Student> c3 = Student::printListOfActivities;
		
		StudentDataBase.getAllStudents().forEach(c3);
	}
	

	private static void refactorlambda() {
		/*
		 * We cannot use method refrence here directly as we are doing this logic 
		 * so we need to create a method to do so 
		 */
		Predicate<Student> p1 = (stud)-> stud.getGradeLevel() >=3;
		
		//using method refrence
		Predicate<Student> p2 = MethodRefFunction::greateThan;
		
		//using method refrence from Student class itself
		Predicate<Student> p3 = Student::gradeCheck;
		
		System.out.println("lambda "+p1.test(StudentDataBase.getAllStudents().get(2)));
		
		System.out.println("Method Ref "+p2.test(StudentDataBase.getAllStudents().get(2)));
		
		System.out.println("Method ref by itself  "+p3.test(StudentDataBase.getAllStudents().get(2)));
		
		
	}

	public static boolean greateThan(Student s) {
		if(s.getGradeLevel()>=3) return true;
		return false;
	}	

}
