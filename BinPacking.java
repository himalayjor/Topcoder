import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class BinPacking
{
	public int func(int[] item)
	{
		int n = item.length;
		boolean used[] = new boolean[n];
		int ans = 0;
		
		for (int i = 0; i < n; i++) {
			if (used[i])
				continue;
			int ma = 0;
			int desti = i;
			for (int j = i+1;	j < n; j++) {
				if (!used[j] && (item[i] + item[j] <= 300) && ma < item[j]) {
					ma = item[j];
					desti = j;
				}
			}
			used[i] = used[desti] = true;
			ans++;
		}
		return ans;
	}
	
	public int minBins(int[] item)
	{
	   Arrays.sort(item);
	   int ans = Integer.MAX_VALUE;
	   int c100 = 0;
	   int n = item.length;
	   
	   for (int i = 0; i < item.length; i++) {
	   	if (item[i] == 100) 
	   		c100++;
	   }
	   
	   for (int i = 0; i <= c100/3; i++) {
	   		
	   		int nitem[] = new int[n-i*3];
	   		for (int j = i*3; j < n; j++) {
	   			nitem[j-i*3] = item[j];
	   		}
	   		ans = Math.min(ans, i + func(nitem));
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
		answer = new BinPacking().minBins(new int[]{150, 150, 150, 150, 150});
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
		answer = new BinPacking().minBins(new int[]{130, 140, 150, 160});
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
		answer = new BinPacking().minBins(new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100});
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
		answer = new BinPacking().minBins(new int[]{100, 200, 100, 100, 100, 100, 200, 100, 200});
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
		answer = new BinPacking().minBins(new int[]{157, 142, 167, 133, 135, 157, 143, 160, 141, 123, 162, 159, 165, 137, 138, 152});
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
		
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}

	
}
//Powered by [KawigiEdit] 2.0!
