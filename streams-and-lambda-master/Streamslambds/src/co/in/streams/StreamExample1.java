package co.in.streams;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import co.in.support.Student;
import co.in.support.StudentDataBase;

public class StreamExample1 {
	
	public static void main(String[] args) {
		
		Predicate<Student> p = (s)->s.getGpa() >=3.9;
		
		//student name and their activities in a map
		
		Map<String, List<String>> map = StudentDataBase.getAllStudents()
			.stream()
			/*
			 * peek is used to debug the streams 
			 * It uses consumer so we can check the values by sysout
			 */
			.peek(s->System.out.println(s))
			/*
			 * Filter is a Intermediate operations which returns the stream itself
			 * we can do the next opertions on that stream
			 */
			.filter(s->s.getGradeLevel()>=3)  // filter using gradelevel
			
			.peek(s->System.out.println("After 1st filter"+s))
			
			.filter(p) 						  // filter using gpa
			
			.peek(s->System.out.println("After 2nd filter"+s))
			/*
			 * Collect is a terminal operator to the stream.
			 * It stops the stream operations there
			 */
			.collect(Collectors.toMap((s) -> s.getName(), Student::getActivities));
		
		System.out.println(map);
	}
}
