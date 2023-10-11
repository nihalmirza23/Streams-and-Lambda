package co.in.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MinMaxUsingReduce {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(6,7,8,9,12,1);
//		List<Integer> list = Arrays.asList();
		
		System.out.println("***Max value by reduce****");
		System.out.println( findMaxValue(list) );
		
		System.out.println("\n***Max value by reduce by optional****");
		if(findMaxValueOptional(list).isPresent())
			System.out.println( findMaxValueOptional(list).get() );
		else
			System.out.println("List is empty...");
		
		System.out.println("\n***Min value by reduce****");
		System.out.println( findMinValue(list) );
		
		System.out.println("\n***Min value by reduce by optional****");
		if(findMaxValueOptional(list).isPresent())
			System.out.println( findMinValueOptional(list).get() );
		else
			System.out.println("List is empty...");
	}

	private static int findMaxValue(List<Integer> list) {
		return list.stream()
			.reduce(0,(a,b)->a>b ?a:b);
		
	}
	
	private static Optional<Integer> findMaxValueOptional(List<Integer> list) {
		
		return list.stream()
					.reduce( (a,b)-> a>b ? a:b);
	}
	

	private static int findMinValue(List<Integer> list) {
		return list.stream()
				.reduce(Integer.MAX_VALUE, (a,b) -> a<b ?a:b);
	}

	
	private static Optional<Integer> findMinValueOptional(List<Integer> list) {
		
		return list.stream()
			.reduce((a,b)->a<b ? a:b );
		
	}

}

