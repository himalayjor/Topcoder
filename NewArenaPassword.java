import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class NewArenaPassword
{
	boolean G[][];
	boolean vis[];
	int n;
	String S;
	int bfs(int s)
	{
		Queue<Integer> qu = new LinkedList<Integer>();
		qu.offer(s);
		vis[s] = true;
		int ma = 0;
		int cou[] = new int[26];
		int ans = 0;
		
		while (!qu.isEmpty()) {
			
			s = qu.poll();
			cou[S.charAt(s)-'a']++;
			ans++;
			ma = Math.max(ma, cou[S.charAt(s)-'a']);
			
			for (int i = 0; i < n; i++) {
				if (G[s][i] && !vis[i]) {
					vis[i] = true;
					qu.offer(i);
				}
			}		
		}
		
		return ans - ma;
	}
										
	public int minChange(String oP, int K)
	{
		this.S = oP;
		n = oP.length();
		G = new boolean[n][n];
		vis = new boolean[n];
		
		for (int i = 0; i < K; i++) {
			int d = n - K + i;
			G[i][d] = G[d][i] = true;
		}
		
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (!vis[i]) 
				ans += bfs(i);
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
		answer = new NewArenaPassword().minChange("topcoderopen", 5);
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
		time = System.currentTimeMillis();
		answer = new NewArenaPassword().minChange("puyopuyo", 4);
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
		answer = new NewArenaPassword().minChange("loool", 3);
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
		answer = new NewArenaPassword().minChange("arena", 5);
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
		answer = new NewArenaPassword().minChange("amavckdkz", 7);
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
		
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}

}
//Powered by [KawigiEdit] 2.0!
