/*
	This class will be used to communicate with the tracker.

	TODO: Make this class a thread so that we can query 
		  the tracker at regular intervals.

*/

import java.net.URL;
import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Tracker {
	private String request;
	private URL u;
	private BufferedReader in;

	public Tracker(String tracker, String hash, String peerID, String port,
					String downloaded, String uploaded, String left) {
		/*
			Format our announce String which will be used to contact
			this tracker.
		*/
		String queries = "?info_hash=" + hash + "&peer_id=" + peerID + 
						"&port=" + port + "&downloaded=" + downloaded 
						+ "&uploaded=" + uploaded + "&left=" + left;
		request = tracker + queries;
	}

	public Map contact() {
		/*
			Send our request to the tracker and return the bdecoded
			response.
		*/
		StringBuffer response = new StringBuffer();
		String read = "";
		try {
			u = new URL(request);
			in = new BufferedReader(new InputStreamReader(u.openStream(), "ISO-8859-1"));

			while((read = in.readLine()) != null) {
				response.append(read);
			}

			in.close();
		}
		catch(IOException e) {
			System.out.println("Error contacting tracker.");
			e.printStackTrace();
		}
		return (Map) BDecoder.decode(response.toString());
	}
}