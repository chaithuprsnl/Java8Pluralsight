import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class ComparatorLambda {
	
	public static void main(String... args){
		
		/**Second way of Implementing and using an interface*/
		Comparator<String> comp = new Comparator<String>(){

			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.length(), o2.length());
			}
			
		};
		
		/**Third way of Implementing and using an interface - Lambda expression*/
		Comparator<String> compLambda = (s1,s2)-> Integer.compare(s1.length(), s2.length());
		
		//or
		
		Comparator<Integer> compMethodRefLambda = Integer::compare;
		
		List<String> list = Arrays.asList("***","**","******","*");
		Collections.sort(list, compLambda);
		
		for(String s:list){
			System.out.println(s);
		}
		
		List<String> list1 = Arrays.asList("hello","world","java8");
		List<String> list2 = new ArrayList<String>();
		
		Consumer<String> c1 = System.out::println;//:: is method references
		Consumer<String> c2 = list2::add; //s -> list2.add(s);
		
		//list1.forEach(c1.andThen(c2));
		list1.forEach(c2);
		
		System.out.println(list2.size());
		
	}

}
