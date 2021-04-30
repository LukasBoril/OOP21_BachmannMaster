package ch.zhaw.exercise.le07b.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TippDesTagesClient {

	public void los() {
		try (Socket s = new Socket("united-portal.com", 9998)) {

			InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
			BufferedReader reader = new BufferedReader(streamReader);

			String advice = reader.readLine();
			System.out.println("Message: " + advice);

			reader.close();

		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TippDesTagesClient client = new TippDesTagesClient();
		client.los();
	}
}

