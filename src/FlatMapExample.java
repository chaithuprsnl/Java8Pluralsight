import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * Syntax
		 * 
		 * <R> Stream<R> map(Function<T,R>)
		 * 
		 * <R> Stream<R> flatMap(Function<T, Stream<R>)
		 * 
		 */
		
		List<Integer> list1 = Arrays.asList(32, 45, 23, 55, 67, 89);
		List<Integer> list2 = Arrays.asList(12, 23, 34);
		List<Integer> list3 = Arrays.asList(22, 33, 44, 55, 66, 77, 88);
		
		List<List<Integer>> list = Arrays.asList(list1, list2, list3);
		
		//Stream<List<Integer>> stream = list.stream();
		
		Function<List<?>, Integer> mapper = l -> l.size();//or List::size
		
		Function<List<Integer>, Stream<Integer>> flatMapper = l -> l.stream();
		
		/*stream.map(mapper).forEach(System.out::println);
		
		stream.map(flatMapper).forEach(System.out::println); //IllegalStateException stream has already been operated upon or closed */
		
		list.stream().map(mapper).forEach(System.out::println);
		list.stream().map(flatMapper).forEach(System.out::println);
		list.stream().flatMap(flatMapper).forEach(System.out::print);//or
		//list.stream().flatMap(l -> l.stream()).forEach(System.out::print); or
		//list.stream().flatMap(List::stream).forEach(System.out::print); all are same

	}

}
