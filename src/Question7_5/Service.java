package Question7_5;

public class Service {
	public static void service(){
		System.out.println("service");
		for(int i = 0; i < 50; i++){
			System.out.println(".");
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
			}
		}
		System.out.println("done.");
	}
}
