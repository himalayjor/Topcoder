import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class AlienAndHamburgers
{
	public int getNumber(int[] type, int[] taste)
	{
		List<Integer> G[] = new List[101];
		for (int i = 0; i < 101; i++)
			G[i] = new ArrayList<Integer>();
		
		
		List<Integer> cost = new ArrayList<Integer>();
		
		for (int i = 0; i < type.length; i++) {
			int tp = type[i];
			G[tp].add(taste[i]);
		}
		
		
		for (int i = 0; i < 101; i++) {
			Collections.sort(G[i], Collections.reverseOrder());
			if (G[i].size() == 0)
				continue;
			if (G[i].get(0) < 0)
				cost.add(G[i].get(0));
			else {
				int sum = 0;
				for (int k = 0; k < G[i].size(); k++) {
					if (G[i].get(k) < 0)
						break;
					sum += G[i].get(k);
				}	
				cost.add(sum);
			}	
		}
		
		Collections.sort(cost, Collections.reverseOrder());
		int joy = 0;
		int sum = 0;
		for (int i = 0; i < cost.size(); i++) {
			sum += cost.get(i);
			joy = Math.max(joy, sum * (i+1)); 
		}
		return joy;
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new AlienAndHamburgers().getNumber(new int[]{1, 2}, new int[]{4, 7});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 22;
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
		answer = new AlienAndHamburgers().getNumber(new int[]{1, 1}, new int[]{-1, -1});
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
		answer = new AlienAndHamburgers().getNumber(new int[]{1, 2, 3}, new int[]{7, 4, -1});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 30;
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
		answer = new AlienAndHamburgers().getNumber(new int[]{1, 2, 3, 2, 3, 1, 3, 2, 3, 1, 1, 1}, new int[]{1, 7, -2, 3, -4, -1, 3, 1, 3, -5, -1, 0});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 54;
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
		answer = new AlienAndHamburgers().getNumber(new int[]{30, 20, 10}, new int[]{100000, -100000, 100000});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 400000;
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
