package co.in.functional;

import java.util.List;
import java.util.function.Supplier;

import co.in.support.Student;
import co.in.support.StudentDataBase;

/*
 * Suppiler interface dosent take any input but it gives the output of the type
 * It dosent have the input feild  
 * It has only one method get
 */
public class Supllierr {
	
	public static void main(String[] args) {
		
		/*
		 * get student using supplier
		 * 
		 */
		System.out.println("***********getting student by supplier**************");
		Supplier<Student> studentSupllier = ()->{
				return StudentDataBase.getAllStudents().get(0);
			};
		
		System.out.println(studentSupllier.get());
		System.out.println("\n\n***********getting list of student**************");
		
		/*
		 * get list of students using the supplier
		 */
		Supplier<List<Student>> studentListSupplier = (()->{
			return StudentDataBase.getAllStudents();
		});
		
		System.out.println(studentListSupplier.get().toString());
	
	}
}
