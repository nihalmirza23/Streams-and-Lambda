package co.in.stream.terminal;

import java.util.stream.Collectors;

import co.in.support.Student;
import co.in.support.StudentDataBase;

public class SumAvgByCollect {
	public static void main(String[] args) {
		/*
		 * summingInt by collectors
		 */
		System.out.println("*** Summing Int by collect ****");
		System.out.println(summingInt());
		
		/*
		 * AverageInt by collectors
		 */
		System.out.println("\n*** Average Int by collect ****");
		System.out.println(averagingInt());
		
	}
	
	public static long summingInt() {
		return StudentDataBase.getAllStudents()
			.stream()
			.collect(Collectors.summingInt(Student::getNoteBooks));
	}
	
	public static double averagingInt() {
		return StudentDataBase.getAllStudents()
			.stream()
//			.filter(s->s.getGpa()>3.9)
			.collect(Collectors.averagingInt(Student::getNoteBooks));
	}
}
