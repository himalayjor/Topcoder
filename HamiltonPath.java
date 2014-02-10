import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class HamiltonPath
{
	boolean G[][];
	int n;
	boolean vis[];
	int mod = 1000000007;
	void dfs(int s)
	{
		vis[s] = true;
		for (int i = 0; i < n; i++) {
			if (!vis[i] && G[s][i])
				dfs(i);
		}
	}
	
	public int countPaths(String[] roads)
	{
		n = roads.length;
		G = new boolean[n][n];
		int deg[] = new int[n];
		
		for (int i =0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if (roads[i].charAt(j) == 'Y') {
					G[i][j] = G[j][i] = true;
					deg[i]++; deg[j]++;
				}	
			}
		}
		for (int i = 0; i < n; i++)
			if (deg[i] >= 3)
				return 0;
		
		vis = new boolean[n];
		int c = 0, point = 0;
		for (int i = 0; i < n; i++) {
			if (deg[i] == 0) {
				vis[i] = true;
				point++;
			} else if (deg[i] == 1 && !vis[i]) {
				c++;
				dfs(i);
			}	
		}		 		 
		for (int i = 0; i < n; i++) 
			if (!vis[i])
				return 0;
		
		long ans = 1;
		for (int i = 1; i <= (c + point); i++) {
			ans = (ans * i) % mod;
		}
		for (int  i = 0; i < c; i++) {
			ans = (ans * 2) % mod;
		}
		return (int)ans;				
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new HamiltonPath().countPaths(new String[]{"NYN", "YNN", "NNN"});
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
		answer = new HamiltonPath().countPaths(new String[]{"NYYY", "YNNN", "YNNN", "YNNN"});
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
		answer = new HamiltonPath().countPaths(new String[]{"NYY", "YNY", "YYN"});
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
		answer = new HamiltonPath().countPaths(new String[]{"NNNNNY", "NNNNYN", "NNNNYN", "NNNNNN", "NYYNNN", "YNNNNN"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 24;
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
