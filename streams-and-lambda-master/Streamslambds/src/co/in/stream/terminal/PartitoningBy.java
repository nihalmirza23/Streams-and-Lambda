package co.in.stream.terminal;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import co.in.support.Student;
import co.in.support.StudentDataBase;

/*
 * partitioning by actually takes predicate as an input
 * it returns the map as true and false as keys
 * as per the predicate condition
 */
public class PartitoningBy {
	public static void main(String[] args) {
//		System.out.println(Runtime.getRuntime().availableProcessors());
		List<Student> students = StudentDataBase.getAllStudents();
		
		System.out.println("*** Collecting to list(default) ******\n");
		Predicate<Student> p1 = (s) -> s.getGpa()>=3.8;
		Map<Boolean, List<Student>> map =  students.stream()
			.collect(Collectors.partitioningBy(p1));
		
		map.entrySet().forEach(e-> System.out.println(e.getKey()+" : "+e.getValue()));
		
		
		//collecting to the set
		System.out.println("\n\n\n*** Collecting to set ******\n");
		Map<Boolean, Set<Student>> map2 =  students.stream()
				.collect(Collectors.partitioningBy(p1, Collectors.toSet()));
			
			map2.entrySet().forEach(e-> System.out.println(e.getKey()+" : "+e.getValue()));
	}
}
