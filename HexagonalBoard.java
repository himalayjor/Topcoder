import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class HexagonalBoard
{
	boolean G[][];
	int X[] = {-1, -1, 0, 0, 1 ,1};
	int Y[] = {0, 1, -1, 1, -1, 0 };
	boolean bfs(int si, int sj, boolean[][] vis, boolean[][] mark)
	{
		Queue<Integer> qu = new LinkedList<Integer>();
		qu.offer(si);
		qu.offer(sj);
		vis[si][sj] = true;
		mark[si][sj] = true;
		int n = vis.length;
		
		while (!qu.isEmpty()) {
				
				si = qu.poll();
				sj = qu.poll();
				
				for (int k = 0; k < 6; k++) {
					int di = si + X[k];
					int dj = sj + Y[k];
					if (di < 0 || di >= n || dj < 0 || dj >= n)
							continue;
					if (G[di][dj] && !vis[di][dj]) {
						vis[di][dj] = true;
						mark[di][dj] = !mark[si][sj];
						qu.offer(di);
						qu.offer(dj);
					}else if (G[di][dj] && vis[di][dj]) {
						if (mark[di][dj] == mark[si][sj])
							return false;
					}		
				}	
		}
		return true;
	}
	
	public int minColors(String[] board)
	{
		int n = board.length;
		G = new boolean[n][n];
		int x = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i].charAt(j) == 'X') {
					G[i][j] = true;
					
					x++;
					
				}
			}
		}
		
		if (x == 0)
			return 0;
			
		boolean val = true;	
		for (int i = 0; val && i < n; i++) {
			for (int j =0; val && j < n;j++) {
				if (G[i][j]) {
					
					for (int k = 0; k < 6; k++) {
						int di = i + X[k];
						int dj = j + Y[k];
						
						if (di < 0 || di >= n || dj < 0 || dj >= n)
							continue;
						if (G[di][dj]) {
							val = false;
							break;
						}	
					}
				}
			}
		}
		if (val)
			return 1;
		
		boolean vis[][] = new boolean[n][n];
		boolean mark[][] = new boolean[n][n];
		
		val = true;
		for (int i = 0; val && i < n; i++) {
			for (int j = 0; val && j < n; j++) {
				if (G[i][j] && !vis[i][j])
					val = bfs(i, j, vis, mark);
			}
		}
		
		if (val)
			return 2;
		
		return 3;									
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new HexagonalBoard().minColors(new String[]{"---", "---", "---"} );
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
		answer = new HexagonalBoard().minColors(new String[]{"-X--", "---X", "----", "-X--"});
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
		answer = new HexagonalBoard().minColors(new String[]{"XXXX", "---X", "---X", "---X"});
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
		answer = new HexagonalBoard().minColors(new String[]{"XX-XX--","-XX-XXX","X-XX--X","X--X-X-","XX-X-XX","-X-XX-X","-XX-XX-"});
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
