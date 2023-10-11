package co.in.stream.terminal;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import co.in.support.Student;
import co.in.support.StudentDataBase;

/*
 * mapping is used to get the collection out of the stream.
 * we can use that as good version of first use map function and then collect
 * we can do the same thing by using mapping
 */
public class Mapping {
	
	public static void main(String[] args) {
		System.out.println("*** To list ****");
		List<String> studentNames =  StudentDataBase.getAllStudents().stream()
				.collect(Collectors.mapping(Student::getName, Collectors.toList()));
		
		System.out.println(studentNames);
		
		System.out.println("\n*** To Set ****");
		Set<String> studentNamesAsSet =  StudentDataBase.getAllStudents().stream()
				.collect(Collectors.mapping(Student::getName, Collectors.toSet()));
		
		System.out.println(studentNamesAsSet);
		
		System.out.println("\n*** Normal method ****");
		Set<String> studentNamesByNormal =  StudentDataBase.getAllStudents()
							.stream()
							.map(s->s.getName())
							.collect(Collectors.toSet());
		
		System.out.println(studentNamesByNormal);
		
		
	}
}
