package co.in.functional;

import java.util.Comparator;

public class Lamda {
	public static void main(String[] args) {
		Runnable();
		Comparator();
	}

	//lambda expression Example with Comparator interface
	private static void Comparator() {
		// prior java 8 
		Comparator<Integer> comparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2); // 0 -> o1==o2
										 // 1 -> o1>o2
										 // -1 -> o1<o2
			}
		};
		
		System.out.println("Comparator before java 8 " + comparator.compare(132, 21));
		
		// using java8
		Comparator<Integer> comparatorlambda = (Integer o1, Integer o2)-> o1.compareTo(o2);
		// argument type is optional in case of functional interface implementation.
		Comparator<Integer> comparatorlambda1 = ( o1 , o2 )-> o1.compareTo(o2);
		/*
		 * We can have multiple lines using curly braces 
		 * but for that we need to write the return statement also
		 * as without return keyword only works with single line. 
		 */
		Comparator<Integer> comparatorlambda2 = ( o1 , o2 )-> {return o1.compareTo(o2);};
		
		System.out.println("Comparator lambda " + comparatorlambda.compare(12, 21));
		System.out.println("Comparator lambda " + comparatorlambda1.compare(12, 21));
	}

	//Lambda expression Example with runnable interface
	private static void Runnable() {
//		prior java 8:
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("Inside runnable");
			}
		};
		
//		java 8 
		Runnable runnable2 = () -> System.out.println("Runnable using java8");
		new Thread(runnable).start();
		new Thread(runnable2).start();
		
		new Thread(()->System.out.println("Direct inside method")).start();
	}
	
}
