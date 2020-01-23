import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class IntermediaryAndFinal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stream<String> strm = Stream.of("one","two","three","four","five");
		List<String> list = new ArrayList<>();
		
		Predicate<String> p1 = Predicate.isEqual("two");
		Predicate<String> p2 = Predicate.isEqual("five");
		
		//strm.peek(System.out::println).filter(p1.or(p2)).peek(list::add);//peek is intermediary operation. because peek returns a stream. All intermediary operations are lazy.
		
		strm.peek(System.out::println).filter(p1.or(p2)).forEach(list::add);//forEach is final operation. because forEach returns void. All final operations are not lazy.
		
		System.out.println("size of list: "+list.size());
		
		//Flatmap and map
		
		List<Integer> list1 = Arrays.asList(1,2,3,4,5);
		List<Integer> list2 = Arrays.asList(1,2,3,4,5,6,7);
		List<Integer> list3 = Arrays.asList(2,5,6);
		
		List<List<Integer>> list4 = Arrays.asList(list1, list2, list3);
		
		Function<List<?>, Integer> func = List::size;
		Function<List<Integer>, Stream<Integer>> flatMapFunc = l -> l.stream();
		
		//list4.stream().map(flatMapFunc).forEach(System.out::println);
		
		list4.stream().flatMap(flatMapFunc).forEach(System.out::println); //flatMap will flatten streams into elements
	}

}
