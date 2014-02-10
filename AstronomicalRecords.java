import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class AstronomicalRecords
{
	
	int n,m;
	int dp[][];
	int func(long[] A, long[] B, int a, int b)
	{
		long[] P = A.clone();
		long[] Q = B.clone();
		
		for (int i = 0; i < n; i++)
		 P[i] *=  b;
		for (int j = 0; j < m; j++)
			Q[j] *= a;
		
		for (int[] tmp : dp)
			Arrays.fill(tmp, 0);
			
		for  (int i = 1; i <= n; i++) {
			
			for (int j = 1; j <= m; j++) {
				if (P[i-1] == Q[j-1])
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);	
			}
		}
		return n + m - dp[n][m];	 	 
	}
	public int minimalPlanets(int[] A, int[] B)
	{
		n = A.length;
		m = B.length;
		dp = new int[n+1][m+1];
		long[] P = new long[n];
		long[] Q = new long[m];
		
		for (int  i = 0; i < n; i++)
			P[i] = A[i];
		for (int i = 0; i < m; i++)
			Q[i] = B[i];	
		int ret = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				ret = Math.min(ret, func(P, Q, A[i],B[j]));
			}
		}
		return ret;
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new AstronomicalRecords().minimalPlanets(new int[]{1,2,1,2,1}, new int[]{2,1,2,1,2});
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
		answer = new AstronomicalRecords().minimalPlanets(new int[]{1,2,3,4}, new int[]{2,4,6,8});
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
		answer = new AstronomicalRecords().minimalPlanets(new int[]{2,3,2,3,2,3,2}, new int[]{600,700,600,700,600,700,600});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 10;
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
		answer = new AstronomicalRecords().minimalPlanets(new int[]{1,2,3,4,5,6,7,8,9}, new int[]{6,7,8,9,10,11,12});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 12;
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
		answer = new AstronomicalRecords().minimalPlanets(new int[]{100000000,200000000}, new int[]{200000000,100000000});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 3;
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
