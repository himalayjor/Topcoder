import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class SkiResorts
{
	int inf = (int)1e9;
	long dp[][];
	int alti[];
	boolean G[][];
	int n;
	
	long func(int s, int h)
	{
		if (s == n-1)
			return 0;
		
		long ret = Long.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			if (G[s][i]) {
				for (int j = 0; j < n; j++) {
					if (alti[j] < h) {
						long ans = Math.abs(alti[s] - h) + func(i, alti[j]);
						ret = Math.min(ans, ret);
					}	
				}
			}
		}
		return ret;
	}			
	public long minCost(String[] road, int[] alti)
	{
		n = road.length;
		this.alti = alti;
		G = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if (road[i].charAt(j) == 'Y') 
					G[j][i] = G[i][j] = true;
			}
			
		}
		
		dp = new long[n][n];
		long res = Long.MAX_VALUE;
		
		for (int i = 0; i < n; i++)	
			res = Math.min(res, func(0, alti[i]));
		
		return res;	
	}
	
	public static void main(String[] args)
	{
		long time;
		long answer;
		boolean errors = false;
		long desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new SkiResorts().minCost(new String[]{"NYN", "YNY", "NYN"}, new int[]{30, 20, 10});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 0L;
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
		answer = new SkiResorts().minCost(new String[]{"NY", "YN"}, new int[]{10, 20});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 10L;
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
		answer = new SkiResorts().minCost(new String[]{"NYN", "YNN", "NNN"}, new int[]{573, 573, 573});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = -1L;
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
		answer = new SkiResorts().minCost(new String[]{"NNYNNYYYNN", "NNNNYNYNNN", "YNNNNYYNNN", "NNNNNNYNYY", "NYNNNNNNYY", "YNYNNNNYNN", "YYYYNNNYNN", "YNNNNYYNNN", "NNNYYNNNNN", "NNNYYNNNNN"}, new int[]{7, 4, 13, 2, 8, 1, 8, 15, 5, 15});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 12L;
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
