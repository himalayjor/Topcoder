import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class JumpingBoard
{
	int n, m;
	int val[][];
	int X[] = {1, -1, 0, 0};
	int Y[] = {0, 0, 1, -1};
	
	String[] board;
	int inf = 100000000;
	int dfs(int x, int y)
	{
		
		if (val[x][y] >= 0)
			return val[x][y];
		if (val[x][y] == -2)
			return inf;	
		int st = board[x].charAt(y) -'0';
		val[x][y] = -2;
		
		int res = 0;
		for (int i  =0; i < 4; i++) {
			int x1 = x + st*X[i];
			int y1 = y + st*Y[i];
			if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= m || board[x1].charAt(y1) == 'H')
				continue;
			
			res = Math.max(res, 1 + dfs(x1, y1));
			
		}
		return val[x][y] = res;
	}
	public int maxJumps(String[] board)
	{
		this.board = board;
		n = board.length;
		m = board[0].length();
		
		val = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				val[i][j] = (board[i].charAt(j) == 'H') ? 0 : -1;
			}
		}
			
		int ans = 1+dfs(0, 0); 
		
		return (ans >= inf) ? -1 : ans;
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new JumpingBoard().maxJumps(new String[]{"3942178", "1234567", "9123532"});
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
		answer = new JumpingBoard().maxJumps(new String[]{"2H3HH4HHH5"});
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
		answer = new JumpingBoard().maxJumps(new String[]{"3994", "9999", "9999", "2924"});
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
		answer = new JumpingBoard().maxJumps(new String[]{"123456", "234567", "345678", "456789"});
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
		answer = new JumpingBoard().maxJumps(new String[]{"9"});
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
		answer = new JumpingBoard().maxJumps(new String[]{"2H9HH11", "HHHHH11", "9HHHH11"});
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
