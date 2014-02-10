import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class Parking
{
	int n,m;
	int h,w;
	String[] park;
	int tim[][];
	int dist[][];
	int inf = 100000;
	int X[] = {1, -1, 0, 0};
	int Y[] = {0, 0, 1, -1};
	int leftof[];
	boolean seenL[], seenR[];
	int tm;
	boolean bpm(int s)
	{
		if (seenL[s])
			return false;
		seenL[s] = true;
		
		for (int i = 0; i < m; i++) {
			if (tim[s][i] <= tm && !seenR[i]) {
				seenR[i] = true;
				if (leftof[i] == -1 || bpm(leftof[i])) {
					leftof[i] = s;
					return true;
				}
			}
		}
		return false;		
	}
	
	void bfs(int s)
	{
		boolean vis[][] =  new boolean[h][w];
		int sx = s/w;
		int sy = s%w;
		
		Queue<Integer> qu = new LinkedList<Integer>();
		qu.offer(s);
		vis[sx][sy] = true;
		dist[sx][sy] = 0;
		
		while(!qu.isEmpty()) {
			s = qu.poll();
			sx = s/w;
			sy = s%w;
			
			for (int k = 0; k < 4; k++) {
				int dx = sx + X[k];
				int dy = sy + Y[k];
				if (dx < 0 || dx >= h || dy < 0 || dy >= w)
					continue;
				char ch = park[dx].charAt(dy);
				if (ch != 'X' && !vis[dx][dy])	 {
					vis[dx][dy] = true;
					dist[dx][dy] = Math.min(dist[sx][sy] + 1, dist[dx][dy]);
					qu.offer(dx*w + dy);
				}
			}
		}
		return;
	}	
	public int minTime(String[] park)
	{
		this.park = park;
		n = 0; m = 0;
		int[] c1 = new int[101];
		int[] p1 = new int[101];
		w = park[0].length();
		h = park.length;
				
		for (int i = 0; i < park.length; i++) {
			for (int j  = 0; j < park[0].length(); j++) {
				if (park[i].charAt(j) == 'C') {
					c1[n++] = i*w + j;
				}else if (park[i].charAt(j) == 'P') {
					p1[m++] = i*w + j;
				}
			}
		}
		
		
		tim = new int[n][m];
		dist = new int[h][w];
		if (n > m)
			return -1;
		
		int ma = 0;		
		for (int i= 0; i < n; i++) {
			for (int tmp[] : dist)
				Arrays.fill(tmp, inf);
			bfs(c1[i]);
			for (int j = 0; j < m; j++) {
				int pos = p1[j];
				int dx = pos/w;
				int dy = pos%w;
				tim[i][j] = dist[dx][dy];
				if (tim[i][j] != inf)
					ma = Math.max(ma, tim[i][j]);
			}	
		}
		seenL = new boolean[n];
		seenR = new boolean[m];
		leftof = new int[m];
		
		for (int tm = 1; tm <= ma; tm++) {
			Arrays.fill(leftof, -1);
			int ans = 0;
			this.tm = tm;
			for (int i = 0; i < n; i++) {
				Arrays.fill(seenL, false);
				Arrays.fill(seenR, false);
				if (bpm(i))
					ans++;
			}
			if (ans == n)
				return tm;
		}
		
		return -1;
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new Parking().minTime(new String[]{"C.....P", "C.....P", "C.....P"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 6;
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
		answer = new Parking().minTime(new String[]{"C.X.....", "..X..X..", "..X..X..", ".....X.P"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 16;
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
		answer = new Parking().minTime(new String[]{"XXXXXXXXXXX", "X......XPPX", "XC...P.XPPX", "X......X..X", "X....C....X", "XXXXXXXXXXX"});
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
		time = System.currentTimeMillis();
		answer = new Parking().minTime(new String[]{".C.", "...", "C.C", "X.X", "PPP"});
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
		answer = new Parking().minTime(new String[]{"CCCCC", ".....", "PXPXP"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = -1;
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
		answer = new Parking().minTime(new String[]{"..X..", "C.X.P", "..X.."});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = -1;
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
