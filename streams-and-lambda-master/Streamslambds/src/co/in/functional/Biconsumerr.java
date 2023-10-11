package co.in.functional;

import java.util.List;
import java.util.function.BiConsumer;

import co.in.support.Student;
import co.in.support.StudentDataBase;

/*
 *	This interface is similar to the consumer interface but it accept 2 inputs
 * 	as consumer only accepts only one
 */
public class Biconsumerr {
	public static void main(String[] args) {
		/*
		 * this is basic implementation of the biconsumer interface
		 */
		BiConsumer<String, String> bic = (a,b) -> System.out.println(a+" "+b); 
		
		bic.accept("Gaurav", "Lavand");
		
		printNamesAndActivities();
		
	}

	
	
	/*
	 * printing the names and list of activities using the biconsumer 
	 * We can give the conditions if we have any
	 */
	public static void printNamesAndActivities() {
		System.out.println("\n\n*********print names and activities************");
		List<Student> list = StudentDataBase.getAllStudents();
		
		// Biconsumer accpets the name and list and prinitng it.
		BiConsumer<String, List<String>> cons = (name, act) ->System.out.println(name+" "+act);
		
		// Note: foreach only accepts the consumer 
		list.forEach(student -> cons.accept(student.getName(), student.getActivities()));
		
	}
	
	
	
}
