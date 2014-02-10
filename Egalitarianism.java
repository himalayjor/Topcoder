import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class Egalitarianism
{
	
	
	public int maxDifference(String[] isFriend, int d)
	{
		int n = isFriend.length;
		int G[][] = new int[n][n];
		int inf = 100000;
		
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if (isFriend[i].charAt(j) == 'Y') {
					G[i][j] = G[j][i] = 1;
				}else
					G[i][j] = G[j][i] = inf;
			}
			
		}
		
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					G[i][j] = Math.min(G[i][j], G[i][k] + G[k][j]);
				}
			}
		}
		
		int ret = 0;
		for (int  i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if (G[i][j] == inf)
					return -1;
				ret = Math.max(ret, G[i][j]);	
			}
		}
		
		return ret*d;
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new Egalitarianism().maxDifference(new String[]{"NYN", "YNY", "NYN"}, 10);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 20;
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
		answer = new Egalitarianism().maxDifference(new String[]{"NN", "NN"}, 1);
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
		answer = new Egalitarianism().maxDifference(new String[]{"NNYNNN", "NNYNNN", "YYNYNN", "NNYNYY", "NNNYNN", "NNNYNN"}, 1000);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 3000;
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
		answer = new Egalitarianism().maxDifference(new String[]{"NNYN", "NNNY", "YNNN", "NYNN"}, 584);
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
		answer = new Egalitarianism().maxDifference(new String[]{"NYNYYYN", "YNNYYYN", "NNNNYNN", "YYNNYYN", "YYYYNNN", "YYNYNNY", "NNNNNYN"}, 5);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 20;
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
		answer = new Egalitarianism().maxDifference(new String[]{"NYYNNNNYYYYNNNN", "YNNNYNNNNNNYYNN", "YNNYNYNNNNYNNNN", "NNYNNYNNNNNNNNN", "NYNNNNYNNYNNNNN", "NNYYNNYNNYNNNYN", "NNNNYYNNYNNNNNN", "YNNNNNNNNNYNNNN", "YNNNNNYNNNNNYNN", "YNNNYYNNNNNNNNY", "YNYNNNNYNNNNNNN", "NYNNNNNNNNNNNNY", "NYNNNNNNYNNNNYN", "NNNNNYNNNNNNYNN", "NNNNNNNNNYNYNNN"}, 747);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 2988;
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
		answer = new Egalitarianism().maxDifference(new String[]{"NY", "YN"}, 0);
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
