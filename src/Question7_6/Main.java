package Question7_6;

import java.io.IOException;

public class Main {
	public static void main(String[] args){
		try{
			new MiniServer(8888).executor();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
