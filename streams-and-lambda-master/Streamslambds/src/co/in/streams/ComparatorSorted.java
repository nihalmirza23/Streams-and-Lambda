package co.in.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import co.in.support.Student;
import co.in.support.StudentDataBase;

public class ComparatorSorted {
	/*
	 * We can use comparator interface in sorted to sort the stream as per our requirement
	 */
	public static void main(String[] args) {
		System.out.println("**** Students sorted by name ******");
		SortStudentsByName().forEach(System.out::println);
		
		System.out.println("\n**** Students sorted by gpa ******");
		SortStudentsByGpa().forEach(System.out::println);
		
		System.out.println("\n**** Students sorted by gpa ******");
		SortStudentsByGpaDescendiing().forEach(System.out::println);
	}

	
	private static List<Student> SortStudentsByName() {
		
		List<Student> list = StudentDataBase.getAllStudents();
		
		return list.stream()
			// Sorting students by their names
			.sorted(Comparator.comparing(Student::getName))
			.collect(Collectors.toList());
		
	}
	
	private static List<Student> SortStudentsByGpa() {
		List<Student> list = StudentDataBase.getAllStudents();
		
		return list.stream()
			// Sorting students by their gpa
			.sorted(Comparator.comparing(Student::getGpa))
			.collect(Collectors.toList());
	}
	
	private static List<Student> SortStudentsByGpaDescendiing() {
		List<Student> list = StudentDataBase.getAllStudents();
		
		return list.stream()
			// Sorting students by their gpa Descendiing
			// using reversed method of collectors.
			.sorted(Comparator.comparing(Student::getGpa).reversed())
			.collect(Collectors.toList());
	}

}
