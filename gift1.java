import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
ID: michael205
LANG: JAVA
PROG: gift1
*/

public class gift1 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader("gift1.in"));
		final int NP = Integer.parseInt(in.readLine());
		String[] arrayOfNames = new String[NP];
		HashMap<String, Integer> names = new HashMap<String, Integer>(10);
		for(int i=0; i<NP; i++) {
			arrayOfNames[i] = in.readLine();
			names.put(arrayOfNames[i], 0);
		}
		
		for(int i=0; i<NP; i++) {
			String giver = in.readLine();
			StringTokenizer st = new StringTokenizer(in.readLine());
			int initial = Integer.parseInt(st.nextToken());
			int recipients = Integer.parseInt(st.nextToken());
			int eachAmt;
			
			if(recipients != 0)
				eachAmt = initial / recipients;
			else
				eachAmt = 0;
			
			int moneyGiven = eachAmt * recipients;
			int giverCurrentAmt = names.get(giver);
			names.remove(giver);
			names.put(giver, giverCurrentAmt-moneyGiven);
			
			for(int j=0; j<recipients; j++) {
				String currentRecipient = in.readLine();
				int currentRecipAmt = names.get(currentRecipient);
				names.remove(currentRecipient);
				names.put(currentRecipient, currentRecipAmt + eachAmt);
			}
		}

		PrintWriter out = new PrintWriter(new File("gift1.out"));
		for(int i=0; i<NP; i++) {
			out.println(arrayOfNames[i] + " " + names.get(arrayOfNames[i]));
		}
		
		in.close();
		out.close();
		System.exit(0);
	}
}

