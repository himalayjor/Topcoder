import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class CactusCount
{
	int n;
	boolean[][] G;
	boolean[] vis;
	public int countCacti(int n, String[] edges)
	{
		this.n = n;
		G = new boolean[n][n];
		vis = new boolean[n];
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < edges.length; i++)
			sb.append(edges[i]);
		String[] arr = sb.toString().split(",");
		
		if (edges.length == 0)
			return n;
			
		for (String edge : arr)
		{
			String[] ee = edge.split(" ");
			int v = Integer.parseInt(ee[0])-1;
			int w = Integer.parseInt(ee[1])-1;
			G[v][w] = G[w][v] = true;
		}
		
		int cc[] = new int[n];
		for (int i = 0; i < n; i++) {
			cc[i] = ncycle(i, i, -1);
			Arrays.fill(vis, false);
		}
		
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (!vis[i]) {
				if (bfs(i, cc))
					ans++;
			}
		}
		return ans;				
	}
	boolean bfs(int st, int[] cc)
	{
		Queue<Integer> qu = new LinkedList<Integer>();
		qu.offer(st);
		vis[st] = true;
		boolean valid = true;
		
		while (!qu.isEmpty()) {
			st = qu.poll();
			if (cc[st] > 1)
				valid = false;
			
			for (int i = 0; i < n; i++) {
				if (!vis[i] && G[st][i]) {
					vis[i] = true;
					qu.offer(i);
				}
			}		
		}
		
		return valid;
	}
	int ncycle(int v, int start, int par)
	{
		if (vis[v]) {
			if (v == start)
				return 1;
			return 0;	
		}
		vis[v] = true;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (G[v][i] && i != par)
				ans += ncycle(i, start, v);
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
		answer = new CactusCount().countCacti(3, new String[]{"1 2,1 3,2 3"});
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
		answer = new CactusCount().countCacti(10, new String[]{});
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
		answer = new CactusCount().countCacti(5, new String[]{"1 2,3 4,4 5"});
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
		answer = new CactusCount().countCacti(17, new String[]{"1 2,2 3,3 4,4 5,5 3,1 3,6 7,7 8,6 8,8 9,9 1", "0,10 11,11 9,12 13,14 15,15 16,16 17,14 17,14 16"});
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
		
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}

	
}
//Powered by [KawigiEdit] 2.0!
