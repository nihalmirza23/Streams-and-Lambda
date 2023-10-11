package co.in.stream.terminal;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import co.in.support.Student;
import co.in.support.StudentDataBase;

public class MinByMaxByUsingCollect {
	
	static	List<Student> list = StudentDataBase.getAllStudents();
	
	/*
	 * Min by is used to get the min value by given predicate or the method refrence we are providibg
	 * This basically returns the optional value
	 */
	public static Optional<Student> minByExample(){
		return list.stream()
				// here we can use the comparingInt , compairingLong as for the primitive types.
			.collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));
		
//		return list.stream()
//			.collect(Collectors.minBy(Comparator.comparingInt(Student::getGpa)));
	}
	
	public static Optional<Student> maxByExample(){
//		return list.stream()
//			.collect(Collectors.maxBy(Comparator.comparingInt(Student::getGradeLevel)));
		//or
		return list.stream()
				.collect(Collectors.maxBy((a,b)-> a.getGradeLevel()-b.getGradeLevel()));
	}
	
	public static void main(String[] args) {
		
		System.out.println("*** Min By example ****");
		if(minByExample().isPresent())
			System.out.println(minByExample().get());
		else
			System.out.println("No student found");
		
		System.out.println("\n*** Max By example ****");
		if(maxByExample().isPresent())
			System.out.println(maxByExample().get());
		else
			System.out.println("No student found");
	}
	
}
