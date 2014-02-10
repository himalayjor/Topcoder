import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class TravelOnMars
{
	boolean G[][];
	int n;
	int bfs(int s, int fi)
	{
		Queue<Integer> qu = new LinkedList<Integer>();
		boolean vis[] = new boolean[n];
		vis[s] = true;
		int dist[] = new int[n];
		qu.offer(s);
		dist[s] = 0;
		
		while (!qu.isEmpty()) {
			
			s = qu.poll();
			if (s == fi)
				return dist[fi];
			
			for (int i = 0; i < n; i++) {
				if (G[s][i] && !vis[i]) {
					dist[i] = dist[s] + 1;
					vis[i] = true;
					qu.offer(i);
				}
			}	
		}
		
		return -1;
	}	
	public int minTimes(int[] range, int st, int en)
	{
		n = range.length;
		 G = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			
			int s = i;
			int fr = (s + 1) % n;
			int bc = (s-1 +n) % n;
			for (int count = 0; count < range[i]; count++) {
				G[s][fr] = G[s][bc] = true;
				fr = (fr + 1) % n;
				bc = (bc-1 + n) % n;
			} 
		}
		
		return bfs(st, en);
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new TravelOnMars().minTimes(new int[]{2,1,1,1,1,1}, 1, 4);
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
		answer = new TravelOnMars().minTimes(new int[]{2,1,1,1,1,1}, 4, 1);
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
		answer = new TravelOnMars().minTimes(new int[]{2,1,1,2,1,2,1,1}, 2, 6);
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
		answer = new TravelOnMars().minTimes(new int[]{3,2,1,1,3,1,2,2,1,1,2,2,2,2,3}, 6, 13);
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
		
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}

}
//Powered by [KawigiEdit] 2.0!
