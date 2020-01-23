import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class HelloWorld8 {

	public static void main(String[] arg){
		
		File dir = new File("D:\\Krishna");
		
		/**One way of Implementing and using an interface*/
		//JavaFileFilter filter = new JavaFileFilter();
		
		/**Second way of Implementing and using an interface*/
		/*FileFilter filter = new FileFilter(){

			@Override
			public boolean accept(File pathname) {
				// TODO Auto-generated method stub
				return pathname.getName().endsWith(".txt");
			}
			
		};*/
		
		/**Third way of Implementing and using an interface - Lambda expression*/
		
		//FileFilter filter = (File file)->file.getName().endsWith(".txt");
		
		FileFilter filter =  file->file.getName().endsWith(".txt");
		
		File[] filteredFiles = dir.listFiles(filter);
		
		for(File file:filteredFiles){
			System.out.println(file.getName());
		}
		
		//Streams
		
		Stream<String> strm = Stream.of("one","two","three","four","five");
		
		//strm.forEach(s -> System.out.println(s));
		
		Predicate<String> p1 = Predicate.isEqual("two");
		Predicate<String> p2 = Predicate.isEqual("five");
		
		Predicate<String> p3 = s -> s.length() > 3;
		
		strm.filter(p3).forEach(System.out::println);
		
	}
	

}
