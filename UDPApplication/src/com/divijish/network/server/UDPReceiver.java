package com.divijish.network.server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiver {

	private static final int BUFLEN = 2000;
	final private int port;
	DatagramPacket receivePacket;
	private DatagramSocket serverSocket = null;

	UDPReceiver(int port){
		this.port = port;

	}

	boolean isBound() {
		return serverSocket != null && serverSocket.isBound();
	}

	String receive() throws Exception{
		try {
		Thread.sleep(1000);
			serverSocket = new DatagramSocket(port);

			byte[] receiveData= new byte[BUFLEN];
			receivePacket = new DatagramPacket(receiveData,receiveData.length);
			serverSocket.receive(receivePacket);
			return new String(receivePacket.getData());
		}catch(Exception e){
			return e.toString();
		}

	}

}
