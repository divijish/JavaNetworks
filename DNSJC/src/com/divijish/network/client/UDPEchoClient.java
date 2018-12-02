package com.divijish.network.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class UDPEchoClient {
	private static final String MESSAGE = "Divij Shrivastava";
	public static void main(String[] args) throws InterruptedException, IOException, ExecutionException {
		byte[] buffer = MESSAGE.getBytes();
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost()
				, PortsUsed.CLIENTPORT);
		DatagramSocket socket = new DatagramSocket();
		final UDPReceiver receiver = 	new UDPReceiver(PortsUsed.CLIENTPORT);
		CompletableFuture<String> response = CompletableFuture.supplyAsync(()-> {
			try {
				return receiver.receive();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		});
		
		int i = 1;
		while(!receiver.isBound()) {
			System.out.println(""+i+". not bound yet.");
			i++;
			Thread.sleep(100);
		}
		
		System.out.println("SENDING: '"+ MESSAGE);
		socket.send(packet);
		String received = response.get();
		System.out.println("SENT: '" + MESSAGE+ "' RECEIVED:" + received +"'");
		
		
	}

}
