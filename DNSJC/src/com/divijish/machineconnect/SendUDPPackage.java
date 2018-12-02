package com.divijish.machineconnect;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SendUDPPackage {
	private static final String MESSAGE = "Divij is the best.";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		byte[] buffer = MESSAGE.getBytes();
		InetAddress address = InetAddress.getLocalHost();
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 2048);
		DatagramSocket socket = new DatagramSocket();
		socket.send(packet);
		System.out.println("SENT: '"+ MESSAGE+ "'");
		
	}

}
