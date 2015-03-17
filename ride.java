/*
ID: michael205
LANG: JAVA
PROG: ride

PROBLEM STATEMENT: 
It is a well-known fact that behind every good comet is a UFO. These UFOs often come to collect loyal supporters
from here on Earth. Unfortunately, they only have room to pick up one group of followers on each trip. They do, however, 
let the groups know ahead of time which will be picked up for each comet by a clever scheme: they pick a name for the 
comet which, along with the name of the group, can be used to determine if it is a particular group's turn to go 
(who do you think names the comets?). The details of the matching scheme are given below; your job is to write a program
which takes the names of a group and a comet and then determines whether the group should go with the UFO behind that comet.  

Both the name of the group and the name of the comet are converted into a number in the following manner: 
the final number is just the product of all the letters in the name, where "A" is 1 and "Z" is 26. 
For instance, the group "USACO" would be 21 * 19 * 1 * 3 * 15 = 17955. 
If the group's number mod 47 is the same as the comet's number mod 47, then you need to tell the group to get ready! 
(Remember that "a mod b" is the remainder left over after dividing a by b; 34 mod 10 is 4.)  

 Write a program which reads in the name of the comet and the name of the group and figures out whether, according
 to the above scheme, the names are a match, printing "GO" if they match and "STAY" if not. 
 The names of the groups and the comets will be a string of capital letters with no spaces or punctuation, up to 6 characters long.
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
