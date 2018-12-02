package com.divijish.machineconnect;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiveUDPPackage {
	
	private static final int BUFLEN = 2000;
	
	public static void main(String[] args) throws IOException {
		System.out.println("Starting to received packtes.");
		DatagramSocket serverSocket = new DatagramSocket(2048);
		byte[] receiveData = new byte[BUFLEN]; 
		
		DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
		serverSocket.receive(receivePacket);
		System.out.println("Attached packet to socket");
		String sentence = new String (receivePacket.getData());
		System.out.println(" RECEIVED: '"+ sentence + "'");
		
	}

}
