import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class EllysNumberGuessing
{
	public int getNumber(int[] guess, int[] ans)
	{
		int ma = (int)(1e9);
		int p1 = (guess[0] + ans[0] <= ma) ? (guess[0] + ans[0]) : 0;
		int p2 = (guess[0] - ans[0] > 0) ? (guess[0] - ans[0]) : 0;
		
		for (int i = 1; i < ans.length; i++) {
		
			int x = (guess[i] + ans[i] <= ma) ? (guess[i] + ans[i]) : 0;
			int y = (guess[i] - ans[i] <= ma) ? (guess[i] - ans[i]) : 0;
			
			if (p1 != x && p1 != y)
				p1 = 0;
			if (p2 != x && p2 != y)
				p2 = 0;	
		}
		if (p1 == 0 && p2 == 0)
			return -2;
		if (p1 != 0 && p2 != 0)
			return -1;
		return Math.max(p1, p2);		
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new EllysNumberGuessing().getNumber(new int[]{600, 594}, new int[]{6, 12});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 606;
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
		answer = new EllysNumberGuessing().getNumber(new int[]{100, 50, 34, 40}, new int[]{58, 8, 8, 2});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 42;
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
		answer = new EllysNumberGuessing().getNumber(new int[]{500000, 600000, 700000}, new int[]{120013, 220013, 79987});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = -2;
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
		answer = new EllysNumberGuessing().getNumber(new int[]{500000000}, new int[]{133742666});
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
		answer = new EllysNumberGuessing().getNumber(new int[]{76938260, 523164588, 14196746, 296286419, 535893832, 41243148, 364561227, 270003278, 472017422, 367932361, 395758413, 301278456, 186276934, 316343129, 336557549, 52536121, 98343562, 356769915, 89249181, 335191879}, new int[]{466274085, 20047757, 529015599, 246925926, 7318513, 501969197, 178651118, 273209067, 71194923, 175279984, 147453932, 241933889, 356935411, 226869216, 206654796, 490676224, 444868783, 186442430, 453963164, 208020466});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 543212345;
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
		answer = new EllysNumberGuessing().getNumber(new int[]{42}, new int[]{42});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 84;
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
		answer = new EllysNumberGuessing().getNumber(new int[]{999900000}, new int[]{100001});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 999799999;
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
