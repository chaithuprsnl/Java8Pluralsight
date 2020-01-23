
public class RunnableLambda {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/**Second way of Implementing and using an interface*/
		/*Runnable runnable = new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0; i<3; i++){
					System.out.println(Thread.currentThread().getName());
				}
			}
			
		};*/
		
		/**Third way of Implementing and using an interface - Lambda expression*/
		Runnable runnable = ()->{
			for(int i=0; i<3; i++){
				System.out.println(Thread.currentThread().getName());
			}
		};
		
		Thread t = new Thread(runnable);
		t.start();
		t.join();
		
	}

}
