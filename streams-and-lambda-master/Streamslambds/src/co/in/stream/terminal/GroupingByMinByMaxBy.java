package co.in.stream.terminal;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import co.in.support.Student;
import co.in.support.StudentDataBase;

/*
 * this class illustrates the example of minBy and MaxBy by using the grouping by 
 */
public class GroupingByMinByMaxBy {
	
	public static List<Student> students = StudentDataBase.getAllStudents() ;
	
	public static void main(String[] args) {
		System.out.println("***** Min By example ******");
		minByExample();
		
		System.out.println("\n***** Min By example using collectingandthen ******");
		minByExampleByCollectingAndThen();
		
		System.out.println("\n\n\n***** Max By example ******");
		maxByExample();
		
		System.out.println("\n***** Max By example using collectingandthen ******");
		maxByExampleByCollectingAndThen();
	}

	
	private static void minByExample() {
		
		Map<Integer, Optional<Student>> map =  students.stream()
			.collect(Collectors.groupingBy(
						Student::getGradeLevel,
						Collectors.minBy(Comparator.comparing(Student::getGpa))
					));
		
		System.out.println(map);
	}
	

	private static void minByExampleByCollectingAndThen() {
	
		Map<Integer, Student> map = students.stream()
			.collect(Collectors.groupingBy(
					Student::getGradeLevel,
					Collectors.collectingAndThen( Collectors.minBy(Comparator.comparing(Student::getGpa))
					, Optional::get)));
		
		System.out.println(map);
	}

	private static void maxByExampleByCollectingAndThen() {

		Map<Integer, Student> map = students.stream()
			.collect(Collectors.groupingBy(
					Student::getGradeLevel,
					Collectors.collectingAndThen( Collectors.maxBy(Comparator.comparing(Student::getGpa))
					, Optional::get)));
		
		System.out.println(map);
	}

	private static void maxByExample() {
		Map<Integer, Optional<Student>> map =  students.stream()
				.collect(Collectors.groupingBy(
							Student::getGradeLevel,
							Collectors.maxBy(Comparator.comparing(Student::getGpa))
						));
			
			System.out.println(map);
		
	}

}
