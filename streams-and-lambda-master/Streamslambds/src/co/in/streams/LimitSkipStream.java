package co.in.streams;

import java.util.Arrays;
import java.util.List;

/*
 * Limit and skip are two functions helps to create the substream.
 * 
 * Limit(n) limits the first n number of elements to be processed in the stream.
 * 
 * skip(n) Skips the first n number of elements from the stream.
 */
public class LimitSkipStream {
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(6,7,8,9,10,11,12);
		
		System.out.println("**** Limit Example *****");
		limitExample(list);
		
		System.out.println("\n**** Skip Example *****");
		skipExample(list);
	}

	private static void limitExample(List<Integer> list) {
		/*
		 * limiting first 4 elements
		 */
		list.stream().limit(4)
			.forEach(System.out::println);
		
	}
	
	
	private static void skipExample(List<Integer> list) {
		/*
		 * skipping 
		 */
		list.stream().skip(4)
			.forEach(System.out::println);
		
	}

}
