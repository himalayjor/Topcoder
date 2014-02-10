import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class GooseTattarrattatDiv1
{
	boolean G[][];
	int n;
	String S;
	int bfs(int s, boolean[] vis, int n)
	{
		int ans = 0;
		Queue<Integer> qu = new LinkedList<Integer>();
		qu.offer(s);
		int ma = 0;
		int fr[] = new int[26];
		vis[s] = true;
		
		while (!qu.isEmpty()) {
			s = qu.poll();
			ans++;
			
			char ch = S.charAt(s);
			fr[ch-'a']++;
			ma = Math.max(ma, fr[ch-'a']);
			
			for (int i = 0; i < n; i++) {
				if (G[s][i] && !vis[i]) {
					vis[i] = true;
					qu.offer(i);
				}
			}
		}
		return ans - ma;	
	}
	public int getmin(String S)
	{
		 n = S.length();
		 this.S = S;
		 G = new boolean[n][n];
		 
		 for (int i = 0; i < n; i++) {
		 	
		 	for (int j = i+1; j < n; j++) {
		 		if (S.charAt(i) == S.charAt(j)) 
		 			G[i][j] = G[j][i] = true;
		 	}
		 	int d = n-1-i;
		 	if (d != i)
		 		G[i][d] = true;
		 }
		 
		 boolean vis[] = new boolean[n];
		 int ans = 0;
		 for (int i = 0; i < n; i++) {
		 	if (!vis[i])
		 		ans += bfs(i, vis, n);
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
		answer = new GooseTattarrattatDiv1().getmin("geese");
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
		answer = new GooseTattarrattatDiv1().getmin("tattarrattat");
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
		answer = new GooseTattarrattatDiv1().getmin("xyyzzzxxx");
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
		answer = new GooseTattarrattatDiv1().getmin("xrepayuyubctwtykrauccnquqfuqvccuaakylwlcjuyhyammag");
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
		answer = new GooseTattarrattatDiv1().getmin("abaabb");
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
