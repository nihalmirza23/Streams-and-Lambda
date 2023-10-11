package co.in.methodrefrence;

import java.util.function.Function;
import java.util.function.Supplier;

import co.in.support.Student;

/*
 * syntax:   className :: new
 * here new keyword id used to create a constructor refrence
 */
public class ConstructorRefrence {
	
	/*
	 * Expample:
	 * 		valid:		Supplier<Student> studentSupplier = Student::new;
	 * 		Invalid: 	Student student = Student::new;
	 * 
	 * 
	 */
	public static void main(String[] args) {
		/*
		 * This will create a new object of the student class by  an empty constructor
		 */
		Supplier<Student> studentSupplier = Student::new;
		
		System.out.println("\n"+studentSupplier.get());
		
		System.out.println("\n");
		
		/*
		 * for this we need a construtor with the one argument as name
		 */
		Function<String, Student> functionStudent= Student::new;
		System.out.println(functionStudent.apply("namee"));
		
	}
}
