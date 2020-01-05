import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DateTime {

	public static void main(String[] args) throws IOException{
		
		List<Person> persons = new ArrayList<>();
		
		// TODO Auto-generated method stub
		try(BufferedReader br = new BufferedReader(new InputStreamReader(DateTime.class.getResourceAsStream("persons.txt")));
			Stream<String> stream = br.lines();
				){
			stream.map(str -> {
				String[] s = str.split(" ");
				String name = s[0].trim();
				int year = Integer.parseInt(s[1]);
				Month m = Month.of(Integer.parseInt(s[2]));
				int day = Integer.parseInt(s[3]);
				LocalDate ld = LocalDate.of(year, m, day);
				Person p = new Person(name, ld);	
				persons.add(p);
				return p;
			}).forEach(System.out::println);;
		}
		
		LocalDate now = LocalDate.now();
		
		persons.stream().forEach(p -> {
			Period period = Period.between(p.getDob(), now);
			System.out.println("Person: "+p.getName()+" Age: "+period.getYears()+" years "+period.getMonths()+" months"
					+"["+p.getDob().until(now, ChronoUnit.MONTHS)+" months ]");
			
		});
	}

}

class Person{
	String name;
	LocalDate dob;
	
	Person(String name, LocalDate dob){
		this.name = name;
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	
}
