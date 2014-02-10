import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class CentaurCompanyDiv2
{
	int n;
	boolean[][] G;
	long dp[][];
	void root(int[] a, int[] b, int s, int par)
	{
		for (int i =0 ;i < a.length; i++) {
			if (a[i] == s+1 || b[i] == s+1) {
				
				int y = (a[i] == s+1) ? (b[i]-1) :(a[i]-1) ;
				if (y != par) {
					G[s][y] = true;
					root(a,b, y, s);
				}
					
			}
		}
	}
	long func(int id, int s)
	{
		if (dp[id][s] > 0)
			return dp[id][s];
		
		long ans = 0;		
		if (id == 0) {
			ans = func(1, s);
			for (int i = 0; i < n; i++) {
				if (G[s][i])
					ans += func(0,i);
			}
		}else {
			ans = 1;
			for (int  i = 0; i < n; i++) {
				if (G[s][i])
					ans *= (1 + func(1,i));
			}
		}
		
		return dp[id][s] = ans;
	}
	public long count(int[] a, int[] b)
	{
		n = a.length+1;
		
		G = new boolean[n][n];
		root(a, b, 0, -1);
		
		dp = new long[2][n];
		return func(0,0) + 1;
	}
	public static void main(String[] args)
	{
		long time;
		long answer;
		boolean errors = false;
		long desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new CentaurCompanyDiv2().count(new int[]{1}, new int[]{2});
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
		answer = new CentaurCompanyDiv2().count(new int[]{2,2}, new int[]{1,3});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 7L;
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
		answer = new CentaurCompanyDiv2().count(new int[]{1,2,3,4,5,6,7,8,9}, new int[]{2,3,4,5,6,7,8,9,10});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 56L;
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
		answer = new CentaurCompanyDiv2().count(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, new int[]{2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 1125899906842675L;
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
		answer = new CentaurCompanyDiv2().count(new int[]{10, 7, 2, 5, 6, 2, 4, 9, 7}, new int[]{8, 10, 10, 4, 1, 6, 2, 2, 3});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 144L;
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
