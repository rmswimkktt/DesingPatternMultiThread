package Question7_6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class MiniServer {
	private final int portnumber;

	public MiniServer(int portnumber) {
		this.portnumber = portnumber;
	}

	public void executor() throws IOException{
		ServerSocket serverSocket = new ServerSocket(portnumber);
		System.out.println("Listening on" + serverSocket);
		try{
			while(true){
				System.out.println("Accepting");
				Socket clientSocket = serverSocket.accept();
				System.out.println("Connecting to " + clientSocket);
				try{
					Service.service(clientSocket);
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			serverSocket.close();
		}
	}
}
