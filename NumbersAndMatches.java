import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class NumbersAndMatches
{
	String s;
	
	int st[];
	long dp[][];
	long func(int id, int k, int n)
	{
		if (dp[id][k] > 0)
			return dp[id][k];
			
		if (id == n-1) {
			
			long ans = 0;
			int num = s.charAt(id) - '0'; 
			for (int i = 0; i < 10; i++) {
				if  ( (st[i] - st[num]) == k ) 
					ans++;
			}
			System.out.println(ans);
			return ans;
		}
		
		long ret = 0;
		
		
		int num = s.charAt(id) - '0';
		for (int i = 0; i < 10; i++) {
			if (st[i] - st[num] <= k)
				ret += func(id+1, k- (st[i] - st[num]), n);
		}
		dp[id][k] = ret;
			return ret;
	}			
		
	public long differentNumbers(long N, int K)
	{
		
		
		st = new int[10];
		st[1] = st[7] = 3;
		st[0] = st[6] = st[9] = 6;
		st[4] = 4;
		st[8] = 7;
		st[2] = st[5] = st[3] = 5;
		
		
				
		s = "" + N;
		int n = s.length();
		
		dp = new long[n+1][250];
		
		return func(0, 0, n);				
	}
	
	public static void main(String[] args)
	{
		long time;
		long answer;
		boolean errors = false;
		long desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new NumbersAndMatches().differentNumbers(10L, 1);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 4L;
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
		answer = new NumbersAndMatches().differentNumbers(23L, 1);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 4L;
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
		answer = new NumbersAndMatches().differentNumbers(66L, 2);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 15L;
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
		answer = new NumbersAndMatches().differentNumbers(888888888L, 100);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 1L;
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
		answer = new NumbersAndMatches().differentNumbers(444444444444444444L, 2);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 1L;
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
