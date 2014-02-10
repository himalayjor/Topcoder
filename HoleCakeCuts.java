import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class HoleCakeCuts
{
    boolean hcut[];
	boolean vcut[];
	boolean G[][];
	int cl;
	
	public int cutTheCake(int cakeLength, int holeLength, int[] hor, int[] ver)
	{
	   cl = cakeLength;
		G = new boolean[2*cakeLength][2*cakeLength];
		hcut = new boolean[2*cakeLength-1];
		vcut = new boolean[2*cakeLength-1];
		
		for (int i = -holeLength; i < holeLength; i++) {
			for (int j = -holeLength; j < holeLength; j++) {
				G[cakeLength + i][cakeLength + j] = true;
			}
		}
		
		for (int i = 0; i < hor.length; i++) {
			hcut[cakeLength + hor[i]-1] = true;
		}		
		for (int i = 0; i < ver.length; i++) {
			vcut[cakeLength + ver[i]-1] = true;
		}
		
		int ans = 0;
		for (int i = 0; i < 2*cakeLength; i++) {
			for (int j = 0; j < 2*cakeLength; j++) {
				if (!G[i][j]) {
					ans++;
					dfs(i,j);
				}
			}
		}
		return ans;
	}
	
	void dfs(int i, int j)
	{
		if (G[i][j])
			return;
		G[i][j] = true;
		if (i -1 > 0  && !vcut[i-1])
		 	dfs(i-1, j);
		if (i+1 < 2*cl && !vcut[i])
			dfs(i+1, j);
		if (j-1 > 0 && !hcut[j-1])
			dfs(i, j-1);
		if (j+1 < 2*cl && !hcut[j])
			dfs(i, j+1);			
	}
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new HoleCakeCuts().cutTheCake(5, 3, new int[]{1, -4}, new int[]{1});
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
		answer = new HoleCakeCuts().cutTheCake(10, 5, new int[]{}, new int[]{-2, 2});
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
		answer = new HoleCakeCuts().cutTheCake(10, 5, new int[]{1}, new int[]{-5, 5});
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
		answer = new HoleCakeCuts().cutTheCake(50, 5, new int[]{40, -40}, new int[]{20, 0, -20});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 12;
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
