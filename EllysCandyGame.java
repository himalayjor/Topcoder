import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class EllysCandyGame
{
	int func(int[] sw, int a, int b, int chance)
	{
		boolean empty = true;
		for (int i = 0; i < sw.length; i++) {
			if (sw[i] != 0)
				empty = false;
		}
		if (empty)
			return a-b;
		
		int ans = (chance == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		
		for (int i = 0; i < sw.length; i++) {
			
			if (sw[i] != 0) {
				int[] arr = sw.clone();
				arr[i] = 0;
				if (i-1 >= 0) arr[i-1] *= 2;
				if (i+1 < arr.length) arr[i+1] *= 2;
				
				if (chance == 0) {
					ans = Math.max(func(arr, a + sw[i], b, 1), ans);
					if (ans > 0)
						return ans;
				}		
				else {
					ans = Math.min(func(arr, a, b+sw[i], 0), ans); 	
					if (ans < 0)
						return ans;
				}
			}
		}
		
	    return ans;		
	}
	public String getWinner(int[] sweets)
	{
		int ans = func(sweets, 0, 0, 0);
		String ret = "";
		
		if (ans == 0)
			ret = "Draw";
		else if (ans > 0)
			ret = "Elly";
		else
			ret = "Kris";
			
		return ret;							
	}
	
	public static void main(String[] args)
	{
		long time;
		String answer;
		boolean errors = false;
		String desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new EllysCandyGame().getWinner(new int[]{20, 50, 70, 0, 30});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Kris";
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
		answer = new EllysCandyGame().getWinner(new int[]{42, 13, 7});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Elly";
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
		answer = new EllysCandyGame().getWinner(new int[]{10, 20});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Draw";
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
		answer = new EllysCandyGame().getWinner(new int[]{3, 1, 7, 11, 1, 1});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Kris";
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
		answer = new EllysCandyGame().getWinner(new int[]{41, 449, 328, 474, 150, 501, 467, 329, 536, 440});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Kris";
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
		answer = new EllysCandyGame().getWinner(new int[]{177, 131, 142, 171, 411, 391, 17, 222, 100, 298});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Elly";
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
