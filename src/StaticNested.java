
public class StaticNested {
	
	int data = 10;
	private static int num = 30;
	
	static class SNTest{
		void display(){
			//System.out.println(data); static nested class cannot access non-static data members and methods outer class
			System.out.println(num);//static nested class can access static data members and methods outer class including private.
		}
		static void message(){
			System.out.println(num);
		}
	}

	public static void main(String[] args) {
		// Static Nested Class can be accessed by outer class name. No need to create Outer class object to created static nested class object.
		StaticNested.SNTest inner = new StaticNested.SNTest();
		inner.display();//Since display is instance method need to call it by inner object.
		StaticNested.SNTest.message();//Since message is static method no need to create static nested object
	}

}
