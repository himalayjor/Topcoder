import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class TrafficMonitor
{
	boolean G[][];
	int n;
	int dp[][];
	boolean vis[];
	int func(int s, int opt, int pr)
	{
		vis[s] = true;
		if (dp[s][opt] > -1)
			return dp[s][opt];
			
		int ret1 = 0;
		if (opt == 1) {
			ret1 = 1;
			// choose
			for (int i = 0;  i < n; i++) {
				if (G[s][i] && i != pr)
					ret1 += func(i, 0, s);
			} 
		}else {
			// 0 means choose or not
			ret1 = 1;
			for (int i = 0;  i < n; i++) {
				if (G[s][i] && i != pr)
					ret1 += func(i, 0, s);
			}
			int ret = 0;
			for (int i = 0;  i < n; i++) {
				if (G[s][i] && i != pr)
					ret += func(i, 1, s);
			}
			ret1 = Math.min(ret1, ret);
		}
		return dp[s][opt] = ret1;	
	}
	public int getMin(String[] links)
	{
		n = links.length;
		G = new boolean[n][n];
		dp = new int[n][2];
		vis = new boolean[n];
		
		for (int i = 0; i < n; i++)
			Arrays.fill(dp[i], -1);
			
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				if (links[i].charAt(j) == 'Y')
					G[i][j] = true;
		}
		
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (!vis[i])
				ans += Math.min(func(i, 0, i), func(i, 1, i));
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
		answer = new TrafficMonitor().getMin(new String[]{"NN","NN"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 0;
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
		answer = new TrafficMonitor().getMin(new String[]{"NYNN","YNYN","NYNY","NNYN"});
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
		answer = new TrafficMonitor().getMin(new String[]{"NNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN","NNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN","NNNNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNYNNNNNNN","NNNNNNNNNNNNNYNNYNNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNN","NNNNNNNNNNNNNNYNNNNNYNNNNNNNYNNNNNNNNNNNNNNNNNNNNN","NNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN","NNNNNNNNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNN","YNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNN","NYNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNYNNNNN","NNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNYNN","NNNNNNNNNNNNNNNNNNNNNNNNNNNNNYNNNNNNNNNYNNNNNNNNNN","NNNNNNNNNNNNNNNNNNNNNNNNNNNNNYNNNNNNNNYNNYNNNNNNNN","NNNNNNNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNN","NNNYNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN","NNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN","NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNYN","NNNYNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNYNNNYNNN","NNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNN","NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNN","NNNNNNNNYYNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN","NNNNYNNNNNNNNNNNNNNNNNNNNNNYNNNNYNNNNNYNNNNNNNNNNN","NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNYNNNNNNNNNYN","NNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNN","NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNY","NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNYNN","NNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNYNNNNYNNNN","NNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN","NNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNYNNN","NNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN","NNNNNNNNNNYYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN","NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN","NNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNN","NNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNN","NNNNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNN","NNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN","NNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNN","NNNNNNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNYNNNNNN","NNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN","NNNNNNNNNNNYNNNNNNNNYYNNNNNNNNNNNNNNNNNNNNNNNNNNNN","NNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNYNNNY","NNNNNNNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNN","NNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN","NNYNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN","NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNN","NNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN","NNNNNNNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNYNNNNNNNNNN","NNNNNNNNNNNNNNNNYNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNN","NNNNNNNNNYNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNN","NNNNNNNNNNNNNNNYNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNN","NNNNNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNYNNNNNNNNNN"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 22;
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
