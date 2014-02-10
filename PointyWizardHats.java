import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class PointyWizardHats
{
	int n,m;
	boolean G[][];
	boolean seenL[];
	boolean seenR[];
	int leftof[];
	
	boolean bpm(int s)
	{
		if (seenL[s])
			return false;
		seenL[s] = true;
		
		for (int i = 0; i < m; i++) {
			
			if (G[s][i] && !seenR[i]) {
				seenR[i] = true;
				if (leftof[i] == -1 || bpm(leftof[i])) {
					leftof[i] = s;
					return true;
				}
			}
		}
		return false;
	}
				
	public int getNumHats(int[] tH, int[] tR, int[] bH, int[] bR)
	{
		n = tH.length;
		m = bH.length;
		
		G = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			int rt = tR[i];
			int ht = tH[i];
			for (int j = 0; j < m; j++) {
				if (rt < bR[j] && (rt*bH[j] < bR[j]*ht))
					G[i][j] = true;
			}
		}
		
		seenL = new boolean[n];
		seenR = new boolean[m];
		leftof = new int[m];
		Arrays.fill(leftof, -1);
		
		int ans = 0;
		
		for (int i = 0; i < n; i++) {
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
		answer = new PointyWizardHats().getNumHats(new int[]{30}, new int[]{3}, new int[]{3}, new int[]{30});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 1;
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
		answer = new PointyWizardHats().getNumHats(new int[]{4,4}, new int[]{4,3}, new int[]{5,12}, new int[]{5,4});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 1;
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
		answer = new PointyWizardHats().getNumHats(new int[]{3}, new int[]{3}, new int[]{1,1}, new int[]{2,4});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 1;
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
		answer = new PointyWizardHats().getNumHats(new int[]{10,10}, new int[]{2,5}, new int[]{2,9}, new int[]{3,6});
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
		answer = new PointyWizardHats().getNumHats(new int[]{3,4,5}, new int[]{5,4,3}, new int[]{3,4,5}, new int[]{3,8,5});
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
		answer = new PointyWizardHats().getNumHats(new int[]{1,2,3,4,5}, new int[]{2,3,4,5,6}, new int[]{2,3,4,5,6}, new int[]{1,2,3,4,5});
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
		answer = new PointyWizardHats().getNumHats(new int[]{123,214,232,323,342,343}, new int[]{123,123,232,123,323,434}, new int[]{545,322,123,545,777,999}, new int[]{323,443,123,656,767,888});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 5;
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
		answer = new PointyWizardHats().getNumHats(new int[]{999,999,999,10000,10000,10000}, new int[]{10000,10000,10000,1,2,3}, new int[]{2324,2323,234,5454,323,232}, new int[]{1,2,3222,434,5454,23});
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
		
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}

}
//Powered by [KawigiEdit] 2.0!
