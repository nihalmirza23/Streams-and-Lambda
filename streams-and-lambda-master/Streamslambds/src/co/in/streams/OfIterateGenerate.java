package co.in.streams;

import java.util.Random;
import java.util.stream.Stream;

/*
 * All of these are used to generate streams
 * 
 * Of generates the stream by using the given input values
 * 
 * Iterate creates a infinite stream as per given condition
 * 
 * generate takes supplier as argument and returns the infine stream of that supplier
 */
public class OfIterateGenerate {
	public static void main(String[] args) {
		System.out.println("****** OF example ********");
		Stream<String> stringStream = Stream.of("abc","xyz");
		stringStream.forEach(System.out::println);
		
		System.out.println("\n****** iterate example ********");
		Stream.iterate(5, (i) -> i*2)
				.limit(10)
				.forEach(System.out::println);
		
		System.out.println("\n****** generate example ********");
		Stream.generate(new Random()::nextInt)
				.limit(10)
				.forEach(System.out::println);
	}
}
