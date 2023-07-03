package day24.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx2 {

	public static void main(String[] args) {
		int port = 5001;//1. 포트번호 지정
		
		//2. ServerSocket 생성
		try(ServerSocket serverSocket = new ServerSocket(port);){
			while(true) {
				//3. 연결 대기 후 요청이 오면 수락
				Socket socket = serverSocket.accept();
				//4. 작업
				//4-1. 서버에서 클라이언트로 전송하는 쓰레드 생성 및 실행
				Thread sendThread = new Thread(()->{
					Scanner sc = new Scanner(System.in);
					try {
						while(true) {
							String str = sc.nextLine();
							byte [] bytes = str.getBytes();
							OutputStream os = socket.getOutputStream();
							os.write(bytes);
							os.flush();							
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				sendThread.start();
				//4-2. 클라이언트에서 보낸 데이터를 읽어오는 쓰레드 생성 및 실행
				Thread readThread = new Thread(()->{
					try{
						while(true) {
							InputStream is = socket.getInputStream();
							byte [] bytes = new byte[1024];
							is.read(bytes);
							String str = new String(bytes);
							System.out.println("Client : " + str);							
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				readThread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
