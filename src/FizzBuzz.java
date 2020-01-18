import java.util.Arrays;
import java.util.Scanner;

public class FizzBuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Scanner
        Scanner s = new Scanner(System.in);
        String t = s.nextLine();                 // Reading input from STDIN
        int nt = Integer.parseInt(t);
        s.skip("(\r\n|[\r\n\u0085\u2028\u2029])?");
        String[] arr = s.nextLine().split(" ");
        long[] numbers = Arrays.stream(arr).mapToLong(str -> Long.parseLong(str)).toArray();
        for(int j=0;j<arr.length;j++) {
        	for(long i=1;i<=numbers[j];i++) {
            	if(i%3==0 && i%5==0) {
            		System.out.println("FizzBuzz");
            	}else if(i%3==0) {
            		System.out.println("Fizz");
            	}else if(i%5==0) {
            		System.out.println("Buzz");
            	}else {
            		System.out.println(i);
            	}
            }
        }
        
        //System.out.println("Hi, " + t + "."+ number);    // Writing output to STDOUT

	}

}
