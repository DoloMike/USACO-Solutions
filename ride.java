//USACO Section 1.1 - ride

/*
ID: michael205
LANG: JAVA
PROG: ride
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ride {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new FileReader("ride.in"));
		PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));			
		if(hash(input.readLine()) == hash(input.readLine())) {
			output.println("GO");
		} else {
			output.println("STAY");
		}
		
		input.close(); output.close();
	}
	
	private static int hash(String s) {
		int h=1;
		for(int i=0; i<s.length(); i++)
			h *= (s.charAt(i)-'A'+1);
		return h%47;
	}
}
