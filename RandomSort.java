import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class RandomSort
{
	TreeMap<int[],  Double> mp = new TreeMap<int[], Double>(new Comparator<int[]> () {
		
				public int compare(int [] a, int[] b)
				{
					for (int i  = 0; i < a.length; i++) {
						if (a[i] != b[i])
							return a[i] - b[i];
					}
					return 0;
				}		
	});
	
	public double getExpected(int[] per)
	{
			if (mp.containsKey(per))
				return mp.get(per);
			
			double ans = 0;
			int tot = 0;
			
			for (int i = 0; i < per.length; i++) {
				for (int j = i+1; j < per.length; j++) {
					
					if (per[i] > per[j]) {
						tot++;
						int cp[] = per.clone();
						int t = cp[i]; cp[i] = cp[j]; cp[j] = t;
						
						ans += 1 + getExpected(cp);
					}
				}
			}
			if (tot != 0)
				ans = ans/tot;
			mp.put(per, ans);
			return ans;			
	}
	
	public static void main(String[] args)
	{
		long time;
		double answer;
		boolean errors = false;
		double desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new RandomSort().getExpected(new int[]{1,3,2});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 1.0D;
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
		answer = new RandomSort().getExpected(new int[]{4,3,2,1});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 4.066666666666666D;
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
		answer = new RandomSort().getExpected(new int[]{1});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 0.0D;
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
		answer = new RandomSort().getExpected(new int[]{2,5,1,6,3,4});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 5.666666666666666D;
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
