package co.in.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
 * All-match : it returns true if all the inputs matches the given condition
 * 
 * any-match : It returns true if any one of input matches the condition
 * 
 * none-match : It returns true if none of the input mattches the condition 
 * 
 * find-any : It returns optional as returns the any input or nothing as optional
 * 
 * find-first : It returns optional as returns the first input or nothing as optional
 */
public class AllAnyNoneMatchFindAnyFirstAny {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(4, 5, 6, 7, 8, 9);

		System.out.println("*** All Match Example ****");
		allMatch(list);

		System.out.println("\n***** Any Match *****");
		anyMatch(list);

		System.out.println("\n***** None Match *****");
		noneMatch(list);

		System.out.println("\n**** Find Any *****");
		findAny(list);
		
		System.out.println("\n**** Find First *****");
		findFirst(list);
	}

	private static void allMatch(List<Integer> list) {

		System.out.println(list.stream().allMatch(e -> e > 3));

		System.out.println(list.stream().allMatch(e -> e > 6));
	}

	private static void anyMatch(List<Integer> list) {
		System.out.println(list.stream().anyMatch(e -> e == 6));

		System.out.println(list.stream().anyMatch(e -> e < 3));

	}

	private static void noneMatch(List<Integer> list) {
		System.out.println(list.stream().noneMatch(e -> e == 6));

		System.out.println(list.stream().noneMatch(e -> e < 3));

	}

	private static void findAny(List<Integer> list) {

		Optional<Integer> i = list.stream()
								.filter(e -> e > 6)
								.findAny();
		if (i.isPresent())
			System.out.println(i.get());
		else
			System.out.println("Not any present");

		Optional<Integer> i1 = list.stream()
									.filter(e -> e > 10)
									.findAny();
		if (i1.isPresent())
			System.out.println(i1.get());
		else
			System.out.println("Not any present");

	}
	
	private static void findFirst(List<Integer> list) {

		Optional<Integer> i = list.stream()
								.filter(e -> e > 6)
								.findFirst();
		if (i.isPresent())
			System.out.println(i.get());
		else
			System.out.println("Not any present");

		Optional<Integer> i1 = list.stream()
									.filter(e -> e > 10)
									.findFirst();
		if (i1.isPresent())
			System.out.println(i1.get());
		else
			System.out.println("Not any present");

	}
}
