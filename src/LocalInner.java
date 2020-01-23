
public class LocalInner {
	private int data = 10;
	static String str = "Hello World!";
	void display(){
		int num = 20;//it should be final till jdk 1.7
		class LIC{
			void msg(){
				System.out.println(num);
				System.out.println(data);
				System.out.println(str);
			}
		}
		LIC inner = new LIC();//Local inner class must be instantiated within the same method
		inner.msg();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalInner outer = new LocalInner();
		outer.display();
	}

}
