package co.in.intstream;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class MinMaxSumAverage {
	public static void main(String[] args) {
		
		System.out.println("**** Max Exapmple *****");
		OptionalInt int1 = IntStream.range(1, 49)
				.max();
		if(int1.isPresent())
			System.out.println(int1.getAsInt());
		
		System.out.println("\n**** Min Exapmple *****");
		OptionalInt int2 = IntStream.range(1, 49)
				.min();
		if(int2.isPresent())
			System.out.println(int2.getAsInt());
		
		System.out.println("\n**** sum Exapmple *****");
		System.out.println(IntStream.range(1, 49)
								.sum());
		
		System.out.println("\n**** average Exapmple *****");
		System.out.println(IntStream.range(1, 49)
								.average());  //  this returns a optionaldouble
		
		
		
	}
}
