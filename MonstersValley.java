import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class MonstersValley
{
	long[] dread;
	int[] price;
	int n;
	long[][] dp;
	
	boolean func(int id, int P)
	{
		if (id == 0)
			return true;
		
		long tot = 0;
		boolean ans = false;
		
		if (dp[id][P] > 0)
			return true;
			
		if (func(id-1, P))		
			tot = dp[id-1][P];	
		
		if (tot < dread[id-1]) {
			tot = 0;
		}
		
		if (P-price[id-1] >= 0 && func(id-1, P-price[id-1])) {
			tot = Math.max(tot, dp[id-1][P-price[id-1]] + dread[id-1]);
		}		
		
		dp[id][P] = tot;
		return (tot > 0);	
	}
	
	public int minimumPrice(long[] dread, int[] price)
	{
		n = dread.length;
		this.dread = dread;
		this.price = price;
		int ma = 2*n + 1;
		
		dp = new long[n+1][ma];
		
		for (int p = 1;p < ma; p++) {
			if (func(n,p)) 
				return p;
		}
				
		return ma-1;
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new MonstersValley().minimumPrice(new long[]{8L, 5L, 10L}, new int[]{1, 1, 2});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 2;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new MonstersValley().minimumPrice(new long[]{1L, 2L, 4L, 1000000000L}, new int[]{1, 1, 1, 2});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 5;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new MonstersValley().minimumPrice(new long[]{200L, 107L, 105L, 206L, 307L, 400L}, new int[]{1, 2, 1, 1, 1, 2});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 2;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new MonstersValley().minimumPrice(new long[]{5216L, 12512L, 613L, 1256L, 66L, 17202L, 30000L, 23512L, 2125L, 33333L}, new int[]{2, 2, 1, 1, 1, 1, 2, 1, 2, 1});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 5;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}

}
//Powered by [KawigiEdit] 2.0!
