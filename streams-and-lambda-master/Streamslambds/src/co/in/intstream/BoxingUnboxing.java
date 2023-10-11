package co.in.intstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoxingUnboxing {
	
	
	public static void main(String[] args) {
		
		System.out.println("**** Boxing example *****");
		List<Integer> list =  IntStream.range(1, 20)
				// int intstream
				.boxed()
				// stream<Integer>
				.collect(Collectors.toList());
		
		System.out.println(list);
		
		System.out.println("\n**** UnBoxing example *****");
		int sum = list.stream()
				// This is stream of Integer
			.mapToInt(Integer::intValue)
				//converted to intstream
				// there are method for long also
			.sum();
		System.out.println(sum);
	}
	
	
}
