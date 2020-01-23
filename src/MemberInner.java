//Nested class - Member Inner class - Class declared inside a class but outside of method
public class MemberInner {
	
	private int data = 10;
	static String str = "Hello World";
	
	class InnerData{
		void displayData(){
			System.out.println(data);//Member inner class can access all members of outer class including private because it has outer class ref this.
			System.out.println(str);
		}
	}

	public static void main(String[] args) {
		// Have to create outer class object before creating inner class object
		MemberInner outer = new MemberInner();
		MemberInner.InnerData inner = outer.new InnerData();
		inner.displayData();
	}

}
