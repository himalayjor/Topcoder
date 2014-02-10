import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class AlienAndGame
{
	int n,m;
	String[] board;
	
	int func(int i, int j)
	{
		int ans = 1;
		boolean flag = true;
		for (int sz = 2; flag && sz <= Math.min(n,m); sz++) {
			
			if (i+sz > n || j+sz > m)
				break;
			for (int x = i; flag && x < i+sz; x++) {
				char ch = board[x].charAt(j);
				for (int y = j; flag && y < j+sz; y++) {
						if (board[x].charAt(y) != ch)
						flag = false; 
				}
			}
			if (flag)
			ans =Math.max(ans, sz*sz);
		}
		return ans;
	}
	public int getNumber(String[] board)
	{
		 n = board.length;
		 m = board[0].length();
		int ans = 0;
		this.board = board;
		for (int i = 0;  i < n; i++) {
			for (int j = 0; j < m; j++) {
				ans = Math.max(ans, func(i,j));
			}
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
		answer = new AlienAndGame().getNumber(new String[]{"BB", "WW"});
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
		answer = new AlienAndGame().getNumber(new String[]{"W"});
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
		answer = new AlienAndGame().getNumber(new String[]{"WBBB", "WBBB", "WWWW"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 9;
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
		answer = new AlienAndGame().getNumber(new String[]{"W", "B", "W", "W", "W"});
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
		answer = new AlienAndGame().getNumber(new String[]{"BWBBWBB", "WWBWWBW", "BBBBBBW", "WBBBBWB", "BBWWWWB", "WWWWWWW", "BBWWBBB"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 9;
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
