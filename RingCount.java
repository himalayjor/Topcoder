import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class RingCount
{
	int vis[][];
	int n, m;
	String[] B;
	int X[] = {1, -1, 0, 0, 1, 1, -1, -1};
	int Y[] = {0, 0, -1, 1, -1, 1, -1, 1};
	
	void bfs(int x, int y, int num)
	{
		Queue<Integer> qu = new LinkedList<Integer>();
		qu.offer(x*m + y);
		vis[x][y] = num;
		char ch = B[x].charAt(y);
			
		while (!qu.isEmpty()) {
			int id = qu.poll();
			x = id/m;
			y = id%m;
			
			for (int i = 0; i < 4; i++) {
				int x1 = x + X[i];
				int y1 = y + Y[i];
				
				if (x1 < 0 || y1 < 0 || x1 >= n ||  y1 >= m)
					continue;
				if (B[x1].charAt(y1) == ch) {
					if (vis[x1][y1] == -1) {
						vis[x1][y1] = num;
						qu.offer(x1*m + y1);
					}
				}	
			}	
		}
		return ;
	}
	
	public int count(String[] bitmap)
	{
		this.B = bitmap;
		n = bitmap.length;
		m = bitmap[0].length();
		
		vis = new int[n][m];
		
		int ans = 0, number = 1;
		for (int i = 0; i < n; i++)
			Arrays.fill(vis[i], -1);
		
								
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if ( (i == 0 || i == n-1 || j == 0 || j == m-1) && bitmap[i].charAt(j) != '.')
					return -1;
				if (vis[i][j] == -1) {
					bfs(i, j, number++);
				}
			}
		}
		
		int x,y;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
			
				for (int k = 0; k < 8; k++) {
					x = i + X[k];
					y = j + Y[k];
					if (x < 0 || x >= n || y < 0 || y >= m)
						continue;
					if (Math.abs(vis[x][y] - vis[i][j]) > 1)
						return -1;		
				}
			}
		}
		number--;
		System.out.println(number);
		return (number % 2 == 0) ? number/2 : -1;
	}
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new RingCount().count(new String[]{".........", ".XXXXXXX.", ".X....XX.", ".X.XX.X..", ".X....XX.", ".XXXXXXX.", "........."});
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
		answer = new RingCount().count(new String[]{"...", ".X.", "..."});
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
		answer = new RingCount().count(new String[]{"...........", ".XXXXXXXXX.", ".X.......X.", ".X.XXXXX.X.", ".X.X...X.X.", ".X.X..XX.X.", ".X.X...X.X.", ".X.XXXXX.X.", ".X.......X.", ".XXXXXXXXX.", "..........."});
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
		answer = new RingCount().count(new String[]{".......", ".XXXXX.", ".X...X.", ".X.X.X.", ".X...X.", ".XXXX..", "......."});
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
		answer = new RingCount().count(new String[]{"X"});
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
		answer = new RingCount().count(new String[]{".........",".XXXXXXX.",".X.....X.",".X.X.X.X.",".X.....XX",".XXXXXXX.","........."});
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
