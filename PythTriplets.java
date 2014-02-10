import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class PythTriplets
{
	int n;
	boolean G[][];
	int leftof[];
	int dist[];
	boolean used[];
	long[] ar;
	
	long gcd(long x, long y)
	{
		if (x == 0)
			return y;
		if (y == 0)
			return x;
		return gcd(y%x, x);		
	}
	
	boolean func(long x, long y)
	{
		if (gcd(x, y) != 1)
			return false;
		long z = (long)Math.hypot(x,y);
		return (x*x + y*y == z*z); 	
	}
	
	void bfs()
	{
		Arrays.fill(dist, -1);
		Queue<Integer> qu = new LinkedList<Integer>();
		
		for (int i = 1; i <= n; i++) {
			if (!used[i] && G[0][i]) {
				qu.offer(i);
				dist[i] = 0;
			}	
		}
		
		while (!qu.isEmpty()) {
			int s = qu.poll();
			
			for (int i = 1; i <= n; i++) {
				if (!G[s][i])
					continue;
				int left = leftof[i];
				if (left > 0 && dist[left] < 0) {
					dist[left] = dist[s] + 1;
					qu.offer(left);
				}	
			}
		}
	}
	
	boolean dfs(int s, boolean[] vis)
	{
		if (vis[s])
			return false;
		vis[s] = true;
		
		for (int  i = 1; i <= n; i++) {
			if (!G[s][i])
				continue;
			int left = leftof[i];
			if (left == -1 || (dist[left] == dist[s]+1 && dfs(left, vis))) {
				leftof[i] = s;
				used[s] = true;
				return true;
			} 	
		}
		return false;		
	}
	int matching()
	{
		leftof = new int[n+1];
		dist = new int[n+1];
		used= new  boolean[n+1];
		
		Arrays.fill(leftof, -1);
		
		for (int res = 0; res < 1000; ) {
			bfs();
			boolean seenr[] = new boolean[n+1];
			int path = 0;
			for (int i = 1; i <= n; i++) {
				if (!used[i] && dfs(i, seenr))
					path++;
			}
			if (path == 0)
				return res;
			res += path;	
		}
		return -1;
	}
	public int findMax(String[] stick)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < stick.length; i++) {
			sb.append(stick[i]);
		}
		String S = sb.toString();
		
		String[] arr = S.split(" ");
		ar = new long[arr.length];
		n = arr.length;
		
		for (int i = 0; i < arr.length; i++) 
			ar[i] = Long.parseLong(arr[i]);	
		
		G = new boolean[n+1][n+1];
						
		for (int i = 1; i <= n; i++) {
			
				if (ar[i-1] % 2 == 0L ) {
					G[0][i] = true;
					
					for (int j = 1; j <= n; j++) {
						if (func(ar[i-1], ar[j-1])) {
							G[i][j] = true;
							System.out.println(ar[i-1] + " " + ar[j-1]);
						}	
					}	
				}
		}
		
		return matching();
	}
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new PythTriplets().findMax(new String[]{"3 4 4 3 11 5 12 9 4"});
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
		answer = new PythTriplets().findMax(new String[]{"20 21 3021 220"});
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
		answer = new PythTriplets().findMax(new String[]{"28 19", "5 1035 21412 37995"});
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
