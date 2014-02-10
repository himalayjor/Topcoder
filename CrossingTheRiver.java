import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class CrossingTheRiver
{
	public String isItEvenPossible(int ww, int lw, int[] bH, int depth)
	{
		int n = bH.length;
		boolean inwater[] = new boolean[n+1];
		int steps[] = new int[n+1];
		Arrays.sort(bH);
		
		int height[] = new int[n+1];
		for (int i = 1; i <= n; i++)
			height[i] = bH[i-1];
		
		for (int i = 1; i < n+1; i++) {
			
			for (int j = 0; j < i; j++) {
				int dif = height[i] - height[j];
				if (j == 0)
					dif -= depth;
				if (inwater[j] && steps[j] == ww) 
					 dif += depth;
				if (dif == 0 || dif == 1)
					steps[i] = Math.max(steps[i], steps[j] + 1);
 				
			}
			if (steps[i] <= ww)
				inwater[i] = true;
			System.out.println(steps[i]);	
			if (steps[i] == (ww + lw))
				return "POSSIBLE";	
		}
		
		return "IMPOSSIBLE";
	}
	
	public static void main(String[] args)
	{
		long time;
		String answer;
		boolean errors = false;
		String desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new CrossingTheRiver().isItEvenPossible(3, 3, new int[]{3,4,4,5,5, 6}, 2);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "POSSIBLE";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new CrossingTheRiver().isItEvenPossible(3, 3, new int[]{3,4,4,5,6, 6}, 2);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "IMPOSSIBLE";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new CrossingTheRiver().isItEvenPossible(5, 2, new int[]{4,4,4,4,4}, 4);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "POSSIBLE";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new CrossingTheRiver().isItEvenPossible(5, 5, new int[]{5,5,5,5,5,5, 2,3,4,4,6, 7, 3, 2}, 2);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "POSSIBLE";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new CrossingTheRiver().isItEvenPossible(5, 7, new int[]{6,6,6,6,6,6,6, 6,6,6,6,6,7,8,9,10}, 5);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "POSSIBLE";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new CrossingTheRiver().isItEvenPossible(1, 1, new int[]{5,3,4}, 2);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "IMPOSSIBLE";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
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
