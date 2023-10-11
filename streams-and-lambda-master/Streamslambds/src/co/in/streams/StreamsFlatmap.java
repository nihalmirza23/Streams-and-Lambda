package co.in.streams;

import java.util.List;
import java.util.stream.Collectors;

import co.in.support.Student;
import co.in.support.StudentDataBase;

public class StreamsFlatmap {
	
	/*
	 * It converts one type to another as like map() method
	 * 
	 * It will be used in the context of stream where each element in the stream
	 * represents multiple elements
	 * Ex. Stream<List>  or Stream<Arrays>
	 */
	public static void main(String[] args) {
		System.out.println(printAllStudentActivities());
	}
	
	public static List<String> printAllStudentActivities(){
		
		List<Student> list = StudentDataBase.getAllStudents();
		List<String> activities =  list.stream() //Stream<Student>
			.map(student->student.getActivities()) // Stream<List<String>>
			// we need to use flatmap here if we need to take all the inputs form the stream.
			.flatMap( lst -> lst.stream())  // Stream<String> 
			.collect(Collectors.toList());
		
//		.map(Student:getActivities) // Stream<List<String>>
//		.flatMap(List::stream)  // Stream<String> 
//		.collect(Collectors.toList());
			
		
		return activities;
				
	}
}
