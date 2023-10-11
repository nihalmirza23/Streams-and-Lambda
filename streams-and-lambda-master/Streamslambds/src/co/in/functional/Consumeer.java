package co.in.functional;

import java.util.List;
import java.util.function.Consumer;

import co.in.support.Student;
import co.in.support.StudentDataBase;

/*
 * Consumer interface
 */
public class Consumeer {
	static Consumer<Student> c2 = (student) -> System.out.print(student.getName()+"  ");
	static Consumer<Student> c3 = (student) -> System.out.println(student.getActivities());

	public static void main(String[] args) {
		
		Consumer<String> con = (s) -> {
			System.out.println(s);
		};
		
		con.accept("String value passed");
		
		printname();
		printNameandActivities();
		printNameandActivitiesUsingCondition();
	}
	
	/*
	 * writing method for consumer interface for printing all the values present in the list
	 */
	public static void printname() {
		System.out.println("\n*********PrintNames**********");
		List<Student> studentList = StudentDataBase.getAllStudents();
		
		Consumer<Student> c1 = student -> System.out.println(student);
		//foreach loop need a consumer as an argument 
		studentList.forEach(c1);
	}
	
	/*
	 * Writing method for only priniting names and activities 
	 */
	public static void printNameandActivities() {
		System.out.println("\n*********printNameandActivities**********");
		List<Student> studentList = StudentDataBase.getAllStudents();
		
//		Consumer<Student> c2 = (student) -> System.out.print(student.getName()+"  ");
//		Consumer<Student> c3 = (student) -> System.out.println(student.getActivities());
		
		//andthen method is used to call the next consumer instance.
		studentList.forEach(c2.andThen(c3)); //consumer chaining
	}
	
	/*
	 * Writing method for only priniting names and activities based on grades of the student
	 */
		public static void printNameandActivitiesUsingCondition() {
			System.out.println("\n*********printNameandActivitiesUsingCondition**********");
			List<Student> studentList = StudentDataBase.getAllStudents();
			
			//Using inline functional interface in for loop
			studentList.forEach((student)->{
				if(student.getGradeLevel()>=3) {
					//accept is the consumer interface method.
					c2.andThen(c3).accept(student);
				}
			});
		}
		
	
	
	
}
