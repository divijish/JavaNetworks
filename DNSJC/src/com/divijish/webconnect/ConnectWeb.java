package com.divijish.webconnect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ConnectWeb {
	
	public static void main(String args[]) {
		try {
			Socket socket = new Socket("www.bbc.com", 80);
			OutputStream os = socket.getOutputStream();
			os.write(("GET / HTTP/1.1 \r\n"
					+"Host: www.bbc.com\r\n\r\n").getBytes());
			os.flush();
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			
		}catch(IOException io) {
			io.printStackTrace();
		}
	}

}
