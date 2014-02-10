import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class EqualTowers
{
	int n;
	int[] bricks;
	int inf = 5000000;
	boolean func(int sum)
	{
		int dp[] = new int[sum+1];
		Arrays.fill(dp, inf);
		
		dp[0] = 0;
		
		for (int i = 1; i <= sum; i++) {
			for (int j =0; j < n; j++) {
				if (i-bricks[j]>=0) 
					dp[i] = Math.min(dp[i], dp[i-bricks[j]]);
			}
			
		}
				
		return (dp[sum] != inf);
	}
	
	public int height(int[] bricks)
	{
		this.bricks = bricks;
		n = bricks.length;
		int sum = 0;
		Arrays.sort(bricks);
		
		for (int i = 0; i < n; i++)
			sum += bricks[i];
		
		sum /= 2;
			
		while (sum > 0) {
			if (func(sum) && func( 2*sum))
					return sum;
			sum--;
		}
		
		return -1;	 	 	 	 
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new EqualTowers().height(new int[]{ 2, 3, 5 });
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
		answer = new EqualTowers().height(new int[]{ 10, 9, 2 });
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
		answer = new EqualTowers().height(new int[]{ 11, 11 });
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 11;
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
		answer = new EqualTowers().height(new int[]{ 14, 3, 20, 15, 15, 14, 24, 23, 15 });
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 64;
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
