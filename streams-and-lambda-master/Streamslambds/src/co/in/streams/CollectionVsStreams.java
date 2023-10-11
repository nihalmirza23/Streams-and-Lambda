package co.in.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CollectionVsStreams {
	public static void main(String[] args) {
		
		List<String> lst = new ArrayList<>();
		lst.add("casd");
		lst.add("cdtr");
		lst.add("rtyui");
		
		// we can iterate through collections n times
		for(String s: lst) {
			System.out.println(s);
		}
		
		for(String s: lst) {
			System.out.println(s);
		}
		 
		Stream<String> strem = lst.stream();
		
		//We can go through the streams only onces 
		strem.forEach(s->System.out.println(s));
		
		// Second time it gives the Exception as stream already operated.
		strem.forEach(s->System.out.println(s));
	}
}
