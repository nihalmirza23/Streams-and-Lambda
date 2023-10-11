package co.in.lambdas;

import java.util.function.Consumer;

public class LocalVariableLambda {
	
	static int check = 9;
	
	public static void main(String[] args) {
		int i=0;
		// we are not allowed to use same variable name as we have defined in method body
		
		// Consumer<Integer> con = (i) -> System.out.println(i);
		Consumer<Integer> con = (i1) -> System.out.println(i);
		
		
		int value=4;
		
		Consumer<Integer> con1 = (inp) ->{
			// we cannot modify the values of the local varibale
			// value++;
			
			//we can change the values of the instance variables.
			check++;
			
			System.out.println(value+4 +" Check:-"+check);
		};
		
		// we are also not  to change the value in method body also
		// value++;
		
		con1.accept(5);
	}
	
}
