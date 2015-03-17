/*
ID: michael205
LANG: JAVA
PROG: gift1

PROBLEM STATEMENT:
A group of NP (2 ≤ NP ≤ 10) uniquely named friends has decided to exchange gifts of money. 
Each of these friends might or might not give some money to any or all of the other friends. 
Likewise, each friend might or might not receive money from any or all of the other friends. 
Your goal in this problem is to deduce how much more money each person gives than they receive.
The rules for gift-giving are potentially different than you might expect. Each person sets
aside a certain amount of money to give and divides this money evenly among all those to whom
he or she is giving a gift. 

No fractional money is available, so dividing 3 among 2 friends would be 1 each for the friends
with 1 left over -- that 1 left over stays in the giver's "account".

In any group of friends, some people are more giving than others (or at least may have more acquaintances)
and some people have more money than others. Given a group of friends, no one of whom has a name longer
than 14 characters, the money each person in the group spends on gifts, and a (sub)list of friends to whom 
each person gives gifts, determine how much more (or less) each person in the group gives than they receive.
*/

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class gift1 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("gift1.in"));
		final int NP = Integer.valueOf(in.nextLine());
		
		String[] names = new String[NP];
		HashMap<String, Integer> givers = new HashMap<String, Integer>();
		
		for(int i=0; i<NP; i++) {
			names[i] = in.nextLine();
			givers.put(names[i], 0);
		}
		
		for(int i=0; i<NP; i++) {
			String giver = in.nextLine();
			StringTokenizer st = new StringTokenizer(in.nextLine());
			int giftTotal = Integer.valueOf(st.nextToken());
			int giftCount = Integer.valueOf(st.nextToken());
			
			int giftAmt = (giftCount > 0) ? giftTotal / giftCount : 0;
			int netLoss = giftCount * giftAmt;
			int currentCash = givers.get(giver);
			givers.put(giver, currentCash-netLoss);
			
			for(int j=0; j<giftCount; j++) {
				String giftee = in.nextLine();
				currentCash = givers.get(giftee);
				givers.put(giftee, currentCash+giftAmt);
			}
		}
		in.close();
		
		PrintWriter out = new PrintWriter(new File("gift1.out"));
		for(int i=0; i<NP; i++) {
			out.println(names[i] + ' ' + givers.get(names[i]));
		}
		out.close(); System.exit(0);
	}
}
