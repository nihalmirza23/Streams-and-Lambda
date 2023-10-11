package co.in.streams;

import java.util.List;
import java.util.stream.Collectors;

import co.in.support.Student;
import co.in.support.StudentDataBase;

public class CountDistinctSorted {
	
	/*
	 * @distinct returns a stream with unique values.
	 * 
	 * @count returns a long with total no of values
	 * 
	 * @sorted Sort the elements in the stream.
	 *  
	 */
	
	public static void main(String[] args) {
		System.out.println("**** Distinct Example*****\n"+distinctExapmple());
		
		System.out.println("\n**** Count Example*****\n"+CountExapmple());
		
		System.out.println("\n**** Sorted Example*****\n"+SortedExample());
		
		
	}

	
	private static List<String> SortedExample() {
		List<Student> list = StudentDataBase.getAllStudents();
		return list.stream() 
			.map(student->student.getActivities()) 
			.flatMap( lst -> lst.stream())
			.distinct()
			/*
			 * If we doesn't give any input in sorted is sorted by natural way.
			 */
			.sorted()
			.collect(Collectors.toList());
	}

	private static long CountExapmple() {
		List<Student> list = StudentDataBase.getAllStudents();
		return list.stream() 
			.map(student->student.getActivities()) 
			.flatMap( lst -> lst.stream())
			// distinct values.
			.distinct() 
			/*
			 * returns the count of the stream.
			 */
			.count();
	}

	private static List<String> distinctExapmple() {
		List<Student> list = StudentDataBase.getAllStudents();
		return list.stream() 
			.map(student->student.getActivities()) 
			.flatMap( lst -> lst.stream())
			/*
			 * this distinct will return the distinct values in the stream.
			 * this is same as distinct in sql
			 */
			.distinct() 
			.collect(Collectors.toList());
		
	}
	
	
}
