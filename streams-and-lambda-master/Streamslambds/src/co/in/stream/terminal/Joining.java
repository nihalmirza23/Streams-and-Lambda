package co.in.stream.terminal;

import java.util.stream.Collectors;

import co.in.support.Student;
import co.in.support.StudentDataBase;

public class Joining {
	
	public static void main(String[] args) {
		/*
		 * joining is bascially concates all the values 
		 * and give a string as output
		 * here in this example from studentdatabse I mapped the names of the students
		 * and conctes them by joining them 
		 */
		String names = StudentDataBase.getAllStudents()
			.stream()
			.map(Student::getName)
			.collect(Collectors.joining());
		
		System.out.println(names);
		
		
		System.out.println();
		/*
		 * We can add the deliminator that can be added in between the  strings
		 */
		String namesDeliminator = StudentDataBase.getAllStudents()
				.stream()
				.map(Student::getName)
				// given -- as deliminator
				.collect(Collectors.joining("--"));
			
			System.out.println(namesDeliminator);
	}
}	
