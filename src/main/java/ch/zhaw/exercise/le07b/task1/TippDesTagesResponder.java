package ch.zhaw.exercise.le07b.task1;

import java.io.*;
import java.net.Socket;

public class TippDesTagesResponder {

	public void los() {
		try (Socket s = new Socket("united-portal.com", 9999)) {

			OutputStreamWriter streamWriter = new OutputStreamWriter(s.getOutputStream());
			PrintWriter printWriter = new PrintWriter(streamWriter);
			String answer="Nummer 5 lebt, brauche input!";
			printWriter.print(answer);
			printWriter.close();


		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TippDesTagesResponder client = new TippDesTagesResponder();
		client.los();
	}
}

