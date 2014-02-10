import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class GridGame
{
	int X[] = {-1, 0, 0, 1};
	int Y[] = {0, -1, 1, 0};
	
	boolean valid(int x, int y, boolean G[][])
	{
		int x1, y1;
		for (int i = 0; i < 4; i++) {
			x1 = x + X[i];
			y1 = y + Y[i];
			if (x1 < 0 || x1 > 3 || y1 < 0 || y1 > 3)
				continue;
			if (G[x1][y1])
				return false;	
		}
		return true;	
	}
	int func(boolean G[][])
	{
		int ans = 0;
	
		for (int i = 0; i < 4; i++) {
			for (int j = 0;j < 4; j++) {
				if (G[i][j] == false && valid(i,j, G)) {
					G[i][j] = true;
					if (func(G) == 0)
						ans++;
					G[i][j] = false;	
				}
			}
		}
		
		return ans;
	}
	public int winningMoves(String[] grid)
	{
		boolean G[][] = new boolean[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				 if (grid[i].charAt(j) == 'X')
				 	G[i][j] = true;
			}
		}
		
		return func(G);		
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new GridGame().winningMoves(new String[]{"....", "....", "....", "...."});
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
		answer = new GridGame().winningMoves(new String[]{"....", "....", ".X..", "...."});
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
		answer = new GridGame().winningMoves(new String[]{".X.X", "..X.", ".X..", "...."});
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
		answer = new GridGame().winningMoves(new String[]{".X.X", "..X.", "X..X", "..X."});
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
		answer = new GridGame().winningMoves(new String[]{"X..X", "..X.", ".X..", "X..X"});
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
		
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}

}
//Powered by [KawigiEdit] 2.0!
