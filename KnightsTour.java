import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class KnightsTour
{
	
	int n,m;
	int ret;
	int X[] = {-2,-2,-1,-1,1,1,2,2};
	int Y[] = {-1,1,-2,2,-2,2,-1,1};
	
	boolean inside(int x, int y)
	{
		return x>=0 && x < 8 && y >=0 && y < 8;
	}
	
	int getA(int x, int y, boolean vis[][])
	{
		int ans = 0;
		int dx, dy;
		for (int i = 0; i < 8; i++) {
			dx = x + X[i];
			dy = y + Y[i];
			if (inside(dx, dy) && !vis[dx][dy])
				ans++;
		}
		return ans;
	}
	void func(int sx, int sy, boolean vis[][])
	{
		vis[sx][sy] = true;
		ret++;
		int ans = 1000;
		int dx, dy;
		int tx = -1, ty= -1;
		
		for (int i = 0; i < 8; i++) {
			dx = sx + X[i];
			dy = sy + Y[i];
			if (!inside(dx, dy) || vis[dx][dy])
				continue;
			int tmp = getA(dx, dy, vis);
	
			if (tmp < ans) {
				ans = tmp;
				tx = dx; ty = dy;
			}else if (tmp == ans && tx > dx) {
				tx = dx; ty = dy;
			}else if (tmp == ans && tx == dx && ty > dy) {
				ty = dy;
			}						
		}
		if (ans == 1000)
			return;
		
		func(tx, ty, vis);
		return;			
	}
	public int visitedPositions(String[] board)
	{
		
		n = m = 8;
		boolean vis[][] = new boolean[n][m];
		int sx = -1, sy = -1;
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length(); j++) {
				if (board[i].charAt(j) == '*')	 {
					vis[i][j] = true;
				}
				if (board[i].charAt(j) == 'K') {
					sx = i; sy = j;
				}	
			}
		}
		
		func(sx, sy, vis);
		
		 return ret;		
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new KnightsTour().visitedPositions(new String[]{"........",".*.*....",".*......","..K...*.","*...*...","...*....","...*.*..","........"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 39;
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
		answer = new KnightsTour().visitedPositions(new String[]{"K.......","........","........","........","........","........","........","........"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 64;
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
		answer = new KnightsTour().visitedPositions(new String[]{"********","*******.","********","**.***.*","********","***.*.**","********","****K***"});
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
		answer = new KnightsTour().visitedPositions(new String[]{"*.*....*",".......*","**...*..","..***...",".**.*...","..*.*..K","..***.*.","**...*.."});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 17;
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
		answer = new KnightsTour().visitedPositions(new String[]{"..*...*.","**.....*","*..*....","*..*....",".....*..","....*..K","**.*...*","..**...."});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 27;
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
