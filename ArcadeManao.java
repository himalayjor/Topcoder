import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class ArcadeManao
{
	int n,m;
	boolean G[][];
	
	boolean vis[][];
	void dfs(int si, int sj, int L)
	{
		vis[si][sj] = true;
		System.out.println(si + " " + sj + " " + L);
		if (sj-1 > -1 && G[si][sj-1] && !vis[si][sj-1])
			dfs(si, sj-1, L);
		if (sj+1 < m && G[si][sj+1] && !vis[si][sj+1])
			dfs(si, sj+1, L);
		
		for (int r = 0; r < n; r++) {
			if (Math.abs(r-si) <= L && G[r][sj] && !vis[r][sj])
				dfs(r, sj, L);
		}				
	}	
	public int shortestLadder(String[] level, int cr, int cc)
	{
		n = level.length;
		m = level[0].length();
		G = new boolean[n][m];
		cr--;
		cc--;
		vis = new boolean[n][m];
			
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (level[i].charAt(j) == 'X')
					G[i][j] = true;
			}
		}
		
		for (int l = 0; l <= n; l++) {
			
			dfs(n-1, 0,l);
			if (vis[cr][cc])
				return l;
			for (int i = 0; i < n; i++) 
				for (int j = 0; j < m; j++)
					vis[i][j] = false;				
		}
		
		return 0; 		
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new ArcadeManao().shortestLadder(new String[]{"XXXX....", "...X.XXX", "XXX..X..", "......X.", "XXXXXXXX"}, 2, 4);
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
		answer = new ArcadeManao().shortestLadder(new String[]{"XXXX", "...X", "XXXX"}, 1, 1);
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
		answer = new ArcadeManao().shortestLadder(new String[]{"..X..", ".X.X.", "X...X", ".X.X.", "..X..", "XXXXX"}, 1, 3);
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
		answer = new ArcadeManao().shortestLadder(new String[]{"X"}, 1, 1);
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
		answer = new ArcadeManao().shortestLadder(new String[]{"XXXXXXXXXX", "...X......", "XXX.......", "X.....XXXX", "..XXXXX..X", ".........X", ".........X", "XXXXXXXXXX"}, 1, 1);
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
