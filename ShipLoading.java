import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class ShipLoading
{
	public int minimumTime(int[] cranes, String[] boxes)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < boxes.length; i++)
			sb.append(boxes[i]);
		String[] arr = sb.toString().split(" ");
		int[] wt = new int[arr.length];
		
		for (int i = 0; i < wt.length; i++)
			wt[i] = Integer.parseInt(arr[i]);
		Arrays.sort(wt);
		
		int ans = 0;
		int t[] = new int[cranes.length];
		
		for (int i = wt.length-1; i > -1; i--) {
			int best = wt.length + 1;
			int bi = -1;	
			for (int j = 0; j < cranes.length; j++) {
				if (cranes[j] >= wt[i] && best > t[j]) {
					best = t[j];
					bi = j;
				}
			}
			if (bi == -1)
				return -1;
			t[bi]++;
			ans = Math.max(ans, t[bi]);	
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
		answer = new ShipLoading().minimumTime(new int[]{6,8,9}, new String[]{"2 5 2 4 7"});
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
		answer = new ShipLoading().minimumTime(new int[]{19,20}, new String[]{"14 12 16 19 16 1 5"});
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
		answer = new ShipLoading().minimumTime(new int[]{23,32,25,28}, new String[]{"5 27 10 16 24 20 2 32 18 7"});
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
		answer = new ShipLoading().minimumTime(new int[]{11,17,5,2,20,7,5,5,20,7}, new String[]{"18 18 15 15 17"});
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
		answer = new ShipLoading().minimumTime(new int[]{56,114,979,120,120,87,480}, new String[]{"221 882 504 358 642 674 212 679 203 279 632 799 79","6 502 275 823 372 594 482 343"});
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
