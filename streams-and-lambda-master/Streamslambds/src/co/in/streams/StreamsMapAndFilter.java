package co.in.streams;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import co.in.support.Student;
import co.in.support.StudentDataBase;

public class StreamsMapAndFilter {
	/*
	 * map is used to convert(transform) a type of stream to another stream.
	 */
	public static void main(String[] args) {
		
		System.out.println("\n***** using map to List *****");
		System.out.println(maptoList() +"\n");
		
		System.out.println("\n***** using map to Set *****");
		System.out.println(maptoSet());
		
		System.out.println("\n\n****** Using Filter ***********");
		filterStudentDatabase().forEach(System.out::println);
	}
	

	public static List<String> maptoList(){
		
		List<Student> list = StudentDataBase.getAllStudents();
		
		return list.stream() //stream<Student>
			//Student as input -> Student name as output
			.map(student -> student.getName()) //Stream<String>
			.map(String::toUpperCase) //Stream<String>  Uppercase operation on each input
			.collect(Collectors.toList());  // List<String>
	}
	
	private static Set<String> maptoSet() {
		
		List<Student> list = StudentDataBase.getAllStudents();
		
		return list.stream() //stream<Student>
			//Student as input -> Student name as output
			.map(student -> student.getName()) //Stream<String>
			.map(String::toUpperCase) //Stream<String>  Uppercase operation on each input
			.collect(Collectors.toSet());  // Set<String>
	}
	


	private static List<Student> filterStudentDatabase() {
		List<Student> list = StudentDataBase.getAllStudents();
		
		return list.stream()
				//Filtering using the gender
			.filter(stud -> stud.getGender().equals("female"))
			// we can add n number of filters as we want
			.filter(stud-> stud.getGpa() >=3)
			.collect(Collectors.toList());
	}

}
