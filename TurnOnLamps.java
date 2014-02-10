import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class TurnOnLamps
{
	int par[];
	boolean G[][];
	boolean state[][] ;
	boolean imp[][];
	int n;
	void dfs(int s, int pr)
	{
		
		par[s] = pr;
		
		for (int i = 0; i < n; i++) {
			if (G[s][i] && (i != pr) && (!imp[s][i] || state[s][i] == false)) {
				 dfs(i, s) ;
			}
		}
		return;
	}
	
	int path(int s, int d)
	{
		Arrays.fill(par, -1);
		 
		dfs(s, -1);
		
		if (par[d] == -1)
			return 0;
		int ans = 0;
		for (int i = d; i != s; i = par[i]) {
			int b = par[i];
			if (imp[b][i] && !state[b][i])
				ans++;
		}
		return ans;
	}
	public int minimize(int[] roads, String initState, String isImportant)
	{
		n = roads.length+1;
		imp = new boolean[n][n];
		state = new boolean[n][n];
		G = new boolean[n][n];
		par = new int[n];
		
		for (int i = 0; i < n-1; i++) {
			int s = roads[i];
			if (initState.charAt(i) == '1')
				state[s][i+1] = state[i+1][s] = true;
			G[s][i+1] = G[i+1][s] = true;
			if (isImportant.charAt(i) == '1')
				imp[s][i+1] = imp[i+1][s] = true;
		}
		
		int round = 0;
		while (true) {
			
			int ans = 0;
			int s = -1, d = -1;
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					int tmp = path(i,j);
					if (ans < tmp) {
						ans = tmp; s = i; d = j;
					}		
				}
			}
			System.out.println(ans);
			if (ans == 0)
				break;
			round++;
			path(s,d);
			for (int i = d; i != s; i = par[i]) {
				if (imp[par[i]][i] && state[par[i]][i] == false) {
					state[par[i]][i] = state[i][par[i]] = true; 			
					System.out.println(par[i] +  " " + i);
				}	
			}	
		}
		
		return round;
	}
	
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new TurnOnLamps().minimize(new int[]{0,0,1,1}, "0001", "0111");
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
		answer = new TurnOnLamps().minimize(new int[]{0,0,1,1}, "0000", "0111");
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
		answer = new TurnOnLamps().minimize(new int[]{0,0,1,1,4,4}, "000100", "111111");
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
		answer = new TurnOnLamps().minimize(new int[]{0,0,1,1,4,4}, "100100", "011101");
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
		answer = new TurnOnLamps().minimize(new int[]{0,0,2,2,3,1,6,3,1}, "010001110", "000110100");
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
		answer = new TurnOnLamps().minimize(new int[]{0,0,1,2,4,4,6,1,2,5,2,8,8,3,6,4,14,7,18,14,11,7,1,12,7,5,18,23,0,14,11,10,2,2,6,1,30,11,9,12,5,35,25,11,23,17,14,45,15}, "0000000000010000000000000010000010100000000000000", "1010111111111011011111000110111111111111111110111");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 14;
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
