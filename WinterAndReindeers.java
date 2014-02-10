import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class WinterAndReindeers
{
	int[] endfunc(String A, String C)
	{
		int[] enda = new int[A.length()];
		
		for (int i = 0; i < A.length(); i++) {
			enda[i] = -1;
			int k = 0;
			for (int j = i; j < A.length(); j++) {
			
				if (A.charAt(j) == C.charAt(k))
					k++;
				if (k == C.length()) {
					enda[i] = j+1;
					break;
				}	
			}
		}
		return enda;
	}
	
	public int getNumber(String[] allA, String[] allB, String[] allC)
	{
		StringBuilder sa = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		StringBuilder sc = new StringBuilder();
		
		for (int i = 0; i < allA.length; i++) {
			sa.append(allA[i]);
		}
		for (int i = 0; i < allB.length; i++) {
			sb.append(allB[i]);
		}
		for (int i = 0; i < allC.length; i++) {
			sc.append(allC[i]);
		}
		
		String A = sa.toString();
		String B = sb.toString();
		String C = sc.toString();
		
		int enda[] = endfunc(A, C);
		int endb[] = endfunc(B,C);
		
		int dp[][][] = new int[A.length()+1][B.length()+1][2];
		int inf = 50000;
				
		for (int i = A.length(); i >= 0; i--) {
			for (int j = B.length(); j >= 0; j--) {
				for (int d = 0; d < 2; d++) {
					int res = -inf;
					if (i == A.length() || j == B.length())
						res = (d == 0) ? -inf : 0;
					else {
						
						if (A.charAt(i) == B.charAt(j))
							res = Math.max(res, 1 + dp[i+1][j+1][d]);
						else	
							res = Math.max(res, Math.max(dp[i+1][j][d], dp[i][j+1][d]));
						if ( enda[i] != -1 && endb[j] != -1)
							res = Math.max(res, C.length() + dp[enda[i]][endb[j]][1]);		
					}
					dp[i][j][d] = res;
				}
			}
		}
		
		return Math.max(0, dp[0][0][0]);
	}
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new WinterAndReindeers().getNumber(new String[]{"X"}, new String[]{"X", "Y"}, new String[]{"X"});
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
		answer = new WinterAndReindeers().getNumber(new String[]{"ABCXD"}, new String[]{"BCDEF"}, new String[]{"CD"});
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
		answer = new WinterAndReindeers().getNumber(new String[]{"WE", "LOVE"}, new String[]{"WORKING", "FOR", "SANTA"}, new String[]{"JK"});
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
		answer = new WinterAndReindeers().getNumber(new String[]{"ABCDE"}, new String[]{"CDEAB"}, new String[]{"B"});
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
		answer = new WinterAndReindeers().getNumber(new String[]{"ABCABDEGAXAHDJBAAHFJDXBB", "ABHFHCDALFDJDBBA", "BABBAXAXXX"}, new String[]{"ABLOCBAXBAHAJDXBIJKA", "JBABCDAHKFIUDALPJAH", "AABACX"}, new String[]{"AXBADXBBAB", "CDD"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 23;
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
