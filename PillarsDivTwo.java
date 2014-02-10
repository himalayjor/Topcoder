import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class PillarsDivTwo
{
	double dist(int x, int y)
	{
		return (double)Math.sqrt(x*x + y*y);
	}	
	public double maximalLength(int[] height, int w)
	{
		int n = height.length;
		double dp[][] = new double[n+1][2];
		
		for (int i = 2; i < n+1; i++) {
			
			// min
			dp[i][0] = dp[i-1][1] + dist(Math.abs( 1- height[i-2]), w);
			dp[i][0] = Math.max(dp[i][0], dp[i-1][0] + dist(0, w));
			dp[i][1] = dp[i-1][0] + dist(Math.abs(height[i-1]- 1), w);
			dp[i][1] = Math.max(dp[i][1], dp[i-1][1] + dist(Math.abs(height[i-1] - height[i-2]), w));
			
		}
		return Math.max(dp[n][0], dp[n][1]);
	}
	
	public static void main(String[] args)
	{
		long time;
		double answer;
		boolean errors = false;
		double desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new PillarsDivTwo().maximalLength(new int[]{3,3,3}, 2);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 5.656854249492381D;
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
		answer = new PillarsDivTwo().maximalLength(new int[]{1,1,1,1}, 100);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 300.0D;
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
		answer = new PillarsDivTwo().maximalLength(new int[]{100,2,100,2,100}, 4);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 396.32310051270036D;
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
		answer = new PillarsDivTwo().maximalLength(new int[]{2,1,1,2}, 1);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 3.82842712474619D;
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
