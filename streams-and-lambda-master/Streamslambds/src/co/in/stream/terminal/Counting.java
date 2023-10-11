package co.in.stream.terminal;

import java.util.stream.Collectors;

import co.in.support.StudentDataBase;

/*
 * counting returns the size of the stream
 * @return is long
 */
public class Counting {
	public static void main(String[] args) {
		
		long size = StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.counting());
		System.out.println(size);
		
		// use case: filter the students by gpa get the count
		System.out.println();
		long sizeByGpa = StudentDataBase.getAllStudents().stream()
							.filter(s->s.getGpa() > 3.8)
							.collect(Collectors.counting());
		System.out.println(sizeByGpa);
		
	}
}
