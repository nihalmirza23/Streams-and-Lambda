package co.in.functional;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/*
 * UnaryOperator and BinaryOperator interfaces
 * This interfaces implements the Function and bifunction interfaces respectively.
 * This can be used when there is input and output type is same.
 * 
 */
public class UnaryBinaryOperatorr {
	public static void main(String[] args) {
		/*
		 * Here in unary the input is String and output is same string
		 */
		System.out.println("**********Using UnaryOperator interface");
		UnaryOperator<String> unary = (str)-> str.concat("concatedstring");
		
		System.out.println(unary.apply("origin"));
		
		/*
		 * Here in binary both the inputs are integer and output is also integer
		 */
		System.out.println("\n**********Using BinaryOperator interface");
		
		BinaryOperator<Integer> binary = (a,b) -> a+b;
		System.out.println(binary.apply(12, 34));
	}
}	
