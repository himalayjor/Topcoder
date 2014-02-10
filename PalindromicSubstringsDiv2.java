import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class PalindromicSubstringsDiv2
{
	String S;
	boolean dp[][];
	boolean vis[][];
	
	boolean func(int i, int j)
	{
		if (i > j)
			return true;

		if (vis[i][j] )
			return dp[i][j];
			
		vis[i][j] = true;
		int ans = 0;
		if (S.charAt(i-1) == S.charAt(j-1))
			dp[i][j] = func(i+1, j-1);
		return dp[i][j];		
	}
	public int count(String[] S1, String[] S2)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < S1.length; i++) {
			sb.append(S1[i]);
		}
		for (int i = 0; i < S2.length; i++) {
			sb.append(S2[i]);
		}
		
		 S = sb.toString();
		int n = S.length();
		
		dp = new boolean[n+1][n+1];
	
		vis = new boolean[n+1][n+1];
			
		for (int i = 1; i <= n; i++) {
			dp[i][i] = true;
			vis[i][i] = true;
		}
		
	 	
	 	int ans = 0;
	 	for (int i = 1; i <= n; i++) {
	 		for (int j = i; j <= n; j++) {
	 			func(i,j);
	 			if (dp[i][j]) {
	 				ans++;
	 				
	 			}
	 		}
	 	}
	 	return ans;		
	}
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new PalindromicSubstringsDiv2().count(new String[]{"a","a",""}, new String[]{"a"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 6;
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
		answer = new PalindromicSubstringsDiv2().count(new String[]{"zaz"}, new String[]{});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 4;
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
		answer = new PalindromicSubstringsDiv2().count(new String[]{"top"}, new String[]{"coder"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 8;
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
		answer = new PalindromicSubstringsDiv2().count(new String[]{}, new String[]{"daata"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 7;
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
