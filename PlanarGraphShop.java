import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class PlanarGraphShop
{
	int inf = 50001;
	int cost(int n, int e)
	{
			return n*n*n + e*e;
	}	
	public int bestCount(int N)
	{
		int dp[] = new int[N+1];
		Arrays.fill(dp, inf);
		
		dp[0] = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
	    for (int n = 1; n < 37; n++) {
	    	int ma = 3*(n-2);
	    	if (ma <= 0)
	    		ma = (n * (n-1))/2;
	    	for (int e = 0; e <= ma; e++) {
	    		int c = cost(n, e);
	    		if (c <= N) 
	    			arr.add(c);
	    	}
	    }
	    
	    Integer item[] = arr.toArray(new Integer[arr.size()]);
	    Arrays.sort(item);
	    
	    for (int i = 1; i <= N; i++) {
	    	
	    	for (int j = 0; j < item.length; j++) {
	    		if (i >= item[j])
	    			dp[i] = Math.min(dp[i], 1 + dp[i-item[j]]);
	    	}
	    }
	    return dp[N];		
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new PlanarGraphShop().bestCount(36);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 1;
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
		answer = new PlanarGraphShop().bestCount(7);
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
		time = System.currentTimeMillis();
		answer = new PlanarGraphShop().bestCount(72);
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
		answer = new PlanarGraphShop().bestCount(46);
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
