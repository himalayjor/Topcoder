import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class RookAttack
{
	boolean cou[][];
	int R,C;
	int leftof[];
	boolean seenL[], seenR[];
	boolean bpm(int s)
	{
		if (seenL[s])
			return false;
		seenL[s] = true;
		
		for (int i = 0; i < C; i++) {
			if (!cou[s][i] && !seenR[i]) {
				seenR[i] = true;
				if (leftof[i] == -1 || bpm(leftof[i])) {
					leftof[i] = s;
					return true;
				}
			}
		}
		return false;		
	}
	public int howMany(int rows, int cols, String[] cutouts)
	{
		int n = rows * cols;
		cou = new boolean[rows][cols];
		R = rows;
		C = cols;
		
		for (int i = 0; i < cutouts.length; i++) {
			String arr[] = cutouts[i].split(",");
			for (String S:arr) {
				String co[] = S.split(" ");
				int x = Integer.parseInt(co[0]);
				int y = Integer.parseInt(co[1]);
				cou[x][y] = true;
			}
		}
		
		leftof = new int[C];
		seenL = new boolean[R];
		seenR = new boolean[C];
		Arrays.fill(leftof, -1);
		int ans = 0;
		
		for (int i = 0; i < R; i++) {
			Arrays.fill(seenL, false);
			Arrays.fill(seenR, false);
			if (bpm(i))
				ans++;
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
		answer = new RookAttack().howMany(8, 8, new String[]{});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 8;
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
		answer = new RookAttack().howMany(2, 2, new String[]{"0 0","0 1","1 1","1 0"});
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
		answer = new RookAttack().howMany(3, 3, new String[]{"0 0","1 0","1 1","2 0","2 1","2 2"});
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
		answer = new RookAttack().howMany(3, 3, new String[]{"0 0","1 2","2 2"});
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
		answer = new RookAttack().howMany(200, 200, new String[]{});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 200;
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
