package com.heilos.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			client();
		}
	}

	private static void client() {
		try {
			String msg = "Client Data";
			Socket socket = new Socket("127.0.0.1", 8080);

			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			pw.println(msg);

			pw.flush();
			String line = is.readLine();

			System.out.println("received from Server " + line);
			pw.close();
			is.close();
			socket.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
