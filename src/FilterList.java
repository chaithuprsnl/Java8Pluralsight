import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilterList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list = Arrays.asList("Hello","A","1","23","M","56");
		
		//To find digits in list
		Pattern pat = Pattern.compile("\\d+");
		
		Iterator<String> it = list.iterator();
		
		while(it.hasNext()) {
			Matcher mat = pat.matcher(it.next());
			if(mat.matches())
				it.remove();
		}
		
		System.out.println(list);

	}

}
