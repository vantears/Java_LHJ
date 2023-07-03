package day24.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx1 {

	public static void main(String[] args) {
		int port = 5001; //1. 포트번호 설정
		
		ServerSocket serverSocket = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			//2. 서버소켓 생성
			serverSocket = new ServerSocket(port);
			//3. 대기
			while(true) {
				System.out.println("[Waiting...]");
				//4. 연결요청이 오면 수락
				Socket socket = serverSocket.accept();
				System.out.println("[Connected!]");
				//5. 작업
				InputStream is = socket.getInputStream();
				byte [] bytes = new byte[1024];
				int readCount = is.read(bytes);
				String str = new String(bytes);
				System.out.println("[Client : " + str + " ]");
				//클라이언트로 데이터 보내기 위해 OutputStream 생성
				OutputStream os = socket.getOutputStream();
				System.out.print("Enter data : ");
				str = sc.nextLine();
				bytes = new byte[1024];
				bytes = str.getBytes();
				os.write(bytes);
				os.flush();
				os.close();
				is.close();
				sc.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
