package com.divijish.network.server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoServer {

	public static void main(String[] args) throws Exception{
		UDPReceiver receiver = new UDPReceiver(PortsUsed.SERVERPORT);
		
		String sentence = receiver.receive();
		DatagramPacket packet = new DatagramPacket(sentence.getBytes(), sentence.length(),
				InetAddress.getLocalHost(), PortsUsed.CLIENTPORT);
		System.out.println("Returning: " + sentence);
		DatagramSocket datagramSocket = new DatagramSocket();
		datagramSocket.send(packet);
		System.out.println("UDP server");
	}

}
