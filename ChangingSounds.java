import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class ChangingSounds
{
	public int maxFinal(int[] cI, int bL, int mL)
	{
		int n = cI.length;
		boolean dp[][] = new boolean[n+1][mL+1];
		
		dp[0][bL] = true;
		
		for (int i = 1; i <= n; i++) {
			
			for (int level = 0; level <= mL; level++) {
				if (level - cI[i-1] >= 0)
					dp[i][level] = dp[i][level] || dp[i-1][level-cI[i-1]];
				if (level + cI[i-1] <= mL)
					dp[i][level] = dp[i][level] || dp[i-1][level+cI[i-1]];	
			}
		}
		
		for (int i = mL; i > -1; i--)
			if (dp[n][i])
				return i;
		return -1;		
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new ChangingSounds().maxFinal(new int[]{5, 3, 7}, 5, 10);
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
		answer = new ChangingSounds().maxFinal(new int[]{15, 2, 9, 10}, 8, 20);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = -1;
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
		answer = new ChangingSounds().maxFinal(new int[]{74,39,127,95,63,140,99,96,154,18,137,162,14,88}, 40, 243);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 238;
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
