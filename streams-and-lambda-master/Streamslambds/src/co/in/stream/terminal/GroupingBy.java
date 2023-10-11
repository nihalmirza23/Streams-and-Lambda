package co.in.stream.terminal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import co.in.support.Student;
import co.in.support.StudentDataBase;

/*
 * grouping by is used to a map of the key-value pair
 * the map is like map<string,List<String>>
 * the value of the map is basically a collection referring to the the key
 * as like the list of students by the grade level
 * 
 * this grouping level is same as like the grouping by in the sql
 * 
 * there are basically three types of the grouping by (based on input types given):
 * 
 * Type 1: grouping by(classifier)
 * Type 2: grouping by(classifier,downstream)
 * Type 3: grouping by(classifier,supplier,downstream)
 * 		
 */
public class GroupingBy {
	
	static List<Student> list = StudentDataBase.getAllStudents();
	public static void main(String[] args) {
		System.out.println("*** Type 1 Examples *****");
		System.out.println("**** Group students by gender ****");
		groupStudentsByGender_1();
		
		
		System.out.println("\n**** Group students by Customized ****");
		groupStudentsCustomized_1();
		
		
		System.out.println("\n\n\n\n****** Type 2 Examples ********");
		System.out.println("**** Two level grouping *****");
		twolevelgrouping_2();
		
		System.out.println("\n**** Using another collector *****");
		twolevelgroupingusinganothercollector_2();
		
		
		System.out.println("\n\n\n\n****** Type 3 Examples ********");
		threelevelgrouping();
	}


	public static void groupStudentsByGender_1() {
		
		Map<String, List<Student>> studentByGender = list.stream()
			.collect(Collectors.groupingBy(Student::getGender));
		
		for( Entry<String,List<Student>>  entry: studentByGender.entrySet()) {
			System.out.println(entry.getKey() + " : "+ entry.getValue());
		}
	}
	
	
	private static void groupStudentsCustomized_1() {
		Map<String, List<Student>> studentByGpa = list.stream()
				// here we are passing the customized values for the key and
				// values are mapped by the condition given.
			.collect(Collectors.groupingBy(s-> s.getGpa() >= 3.8 ? "OUTSTANDING" :"AVERAGE"));
		 
		for( Entry<String,List<Student>>  entry: studentByGpa.entrySet()) {
			System.out.println(entry.getKey() + " : "+ entry.getValue());
		}
	}
	
	private static void twolevelgrouping_2() {
		
		Map<Integer, Map<String, List<Student>>> map = list.stream()						
			.collect(Collectors.groupingBy(Student::getGradeLevel ,//first level mapping 
						// second level mapping
						Collectors.groupingBy(s-> s.getGpa() >= 3.8 ? "OUTSTANDING" :"AVERAGE")));
		
		for( Entry<Integer, Map<String, List<Student>>>  entry: map.entrySet()) {
			System.out.println(entry.getKey() + " : "+ entry.getValue());
		}
		
	}
	
	private static void twolevelgroupingusinganothercollector_2() {
		
		Map<Integer, Integer> map =  list.stream()
				
			.collect(Collectors.groupingBy(Student::getGradeLevel, // first level by grade level
								// second level returning a integer value using collectors method 
								Collectors.summingInt(Student::getNoteBooks)));
		
		Map<String, Integer> map1 =  list.stream()
				
				.collect(Collectors.groupingBy(Student::getName, // first level by grade level
									// second level returning a integer value using collectors method 
									Collectors.summingInt(Student::getNoteBooks)));	
		for( Entry<Integer, Integer>  entry: map.entrySet()) {
			System.out.println(entry.getKey() + " : "+ entry.getValue());
		}
		
		System.out.println(map1);
	}

	private static void threelevelgrouping() {
		LinkedHashMap<String, Set<Student>> student =  list.stream()
			.collect(Collectors.groupingBy(
						Student::getName, //1st parameter : what type of key it needed
						LinkedHashMap::new, // 2nd parameter : what type of map should we need
						Collectors.toSet() // 3rd is what kind of value we want
					));
		
		for( Entry<String, Set<Student>>  entry: student.entrySet()) {
			System.out.println(entry.getKey() + " : "+ entry.getValue());
		}
		System.out.println("");
		LinkedHashMap<Integer, Set<Student>> student1 =  list.stream()
				.collect(Collectors.groupingBy(
							Student::getGradeLevel, //1st parameter : what type of key it needed
							LinkedHashMap::new, // 2nd parameter : what type of map should we need
							Collectors.toSet() // 3rd is what kind of value we want
						));
			
			for( Entry<Integer, Set<Student>>  entry: student1.entrySet()) {
				System.out.println(entry.getKey() + " : "+ entry.getValue());
			}
		
	}


}
