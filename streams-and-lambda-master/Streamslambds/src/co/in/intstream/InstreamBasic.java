package co.in.intstream;

import java.util.stream.IntStream;

public class InstreamBasic {
	
	public static void main(String[] args) {
		/*
		 * returns a stream of integer from  1 to 49
		 */
		IntStream intStream = IntStream.range(1, 50);
		
		System.out.println(intStream.count());
		System.out.println();
		IntStream.range(1, 50).forEach(i-> System.out.print(i+" "));
		System.out.println();
		
		/*
		 * returns the stream of integer from 1 to 50
		 */
		System.out.println();
		System.out.println( IntStream.rangeClosed(1, 50).count() );
		System.out.println();
		IntStream.rangeClosed(1, 50).forEach(i-> System.out.print(i+" "));
		
	}
	
}
