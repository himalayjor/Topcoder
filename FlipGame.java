import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class FlipGame
{
	int n,m;
	boolean G[][];
	boolean func()
	{
		boolean valid = false;
		int max = -1;
		for (int i = 0; i < n; i++) {
			int j = m-1;
			for ( j = m-1; j > max; j--) {
				if (G[i][j]) {
					max = Math.max(max, j);
					valid= true; 
					break;
				}	
			}
			while (j > -1) {
				G[i][j] = !G[i][j];
				j--;
			}
		}
		return valid;
	}
	public int minOperations(String[] board)
	{
		n = board.length;
		m = board[0].length();
		G = new boolean[n][m];
		
		for (int i = 0; i< n; i++){
			for (int j = 0; j < m; j++)
			 	if (board[i].charAt(j) == '1')
			 		G[i][j] = true;
		}
		
		int ans = 0;
		while (func())
			ans++;
		
		return ans;		
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new FlipGame().minOperations(new String[]{"1000", "1110", "1111"});
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
		answer = new FlipGame().minOperations(new String[]{"1111", "1111", "1111"});
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
		answer = new FlipGame().minOperations(new String[]{"00", "00", "00"});
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
		answer = new FlipGame().minOperations(new String[]{"00000000", "00100000", "01000000", "00001000", "00000000"});
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
		answer = new FlipGame().minOperations(new String[]{"000000000000001100000000000000", "000000000000011110000000000000", "000000000000111111000000000000", "000000000001111111100000000000", "000000000011111111110000000000", "000000000111111111111000000000", "000000001100111111001100000000", "000000011000011110000110000000", "000000111100111111001111000000", "000001111111111111111111100000", "000011111111111111111111110000", "000111111111000000111111111000", "001111111111100001111111111100", "011111111111110011111111111110", "111111111111111111111111111111"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 29;
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
