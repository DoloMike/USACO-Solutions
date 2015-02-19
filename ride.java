/*
ID: michael205
LANG: JAVA
PROG: ride
*/

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ride {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("ride.in"));
		PrintWriter out = new PrintWriter(new File("ride.out"));
		
		if(hash(in.nextLine()) == hash(in.nextLine())) {
			out.println("GO");
		} else {
			out.println("STAY");
		}
		
		in.close(); out.close();
		System.exit(0);
	}
	
	private static int hash(String name) {
		int result = 1;
		for(int i = 0; i<name.length(); i++) {
			result *= name.charAt(i)-'A'+1;
		}
		result %= 47;
		return result;
	}
}
