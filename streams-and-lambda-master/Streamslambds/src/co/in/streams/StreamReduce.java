package co.in.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import co.in.support.Student;
import co.in.support.StudentDataBase;

/*
 * reduce is a terminal operation,
 * Used to reduce the contents of a stream to a single value.
 * 
 * It takes two parameters as Input
 * 		1. First parameter - Default value or Initial value
 * 		2. Second parameter - BinaryOperator<T> 
 */
public class StreamReduce {

	public static void main(String[] args) {
		
		List<Integer> integers = Arrays.asList(1,3,5,7,8);
		System.out.println("**** Multiplication using reduce ******");
		System.out.println( performMultipliaction(integers));
		
		/*
		 * ispresent and get methods are used here
		 * ispresent- true if value present or false
		 * get - get values form that optional
		 */
		System.out.println("\n**** Multiplication using reduce without initial value******");
		if(performMultipliactionWithoutFirstParameter(integers).isPresent())
		System.out.println( performMultipliactionWithoutFirstParameter(integers).get());
		
		
		/*
		 * Student with higher GPA
		 */
		System.out.println("\n**** Highest GPA student by reduces******");
		getHighestGpaStudent();
		
	}

	
	public static int performMultipliaction(List<Integer> integers) {
		
		return integers.stream()
			// 1 a=1 (default value) b=1 (first value by stream) result =1
			// 3 a= 1 ( result ) b= 3 result =3
			// 5 a= 3 ( result ) b= 5 result =15
			// 7 a= 15 ( result ) b= 7 result =105
			// 8 a= 105 ( result ) b= 8 result = 840
			.reduce(1 , (a,b) -> a*b);  // 840 will be returned as a output
		
	}
	
	
	private static Optional<Integer> performMultipliactionWithoutFirstParameter(List<Integer> integers) {
		
		/*
		 * If we didnt give the initial value then it will returns a Optional value
		 * This will helps when there is a Empty List 
		 * If we do operations on empty array then it should not return anything 
		 * but it returns a initial value
		 * for that we use this  
		 */
		return integers.stream()
				.reduce((a,b) -> a*b);  // 840 will be returned as a output
	}

	private static void getHighestGpaStudent() {
		
		Optional<Student> studentWithHighGPA = StudentDataBase.getAllStudents()
			.stream()
			.reduce( (s1,s2) -> s1.getGpa()>s2.getGpa() ? s1:s2);
		
		if(studentWithHighGPA.isPresent()) {
			System.out.println(studentWithHighGPA.get());
		}else {
			System.out.println("Student not available");
		}
		
	}

}
