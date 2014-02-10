import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class FoxAverageSequence
{
	int n;
	int seq[];
	int dp[][][][];
	int mod =(int)(1e9 + 7);
	int func(int pos, int pr1, int pr2, int sump)
	{
		if (dp[pos][pr1][pr2][sump] != -1)
			return dp[pos][pr1][pr2][sump];
		System.out.println(pos + " " + pr1 + " " + pr2 +  " " + sump);
		
		
		if (pos == n) {
			
			return dp[pos][pr1][pr2][sump] = 1;
		}	
		
		int num = seq[pos];
		int ret = 0;
			
		if (num != -1) {
			if (pr2 > pr1 && pr1 > num)
				return 0;
			double avg = (double)sump/pos;
			if (avg > num)
				return 0;	
			ret = func(pos+1, num, pr1, sump + num);			 
		}else if (pos == 0) {
			
			for (int i = 0; i < 41; i++) {
				ret = (ret + func(pos+1, i, pr1, sump + i)) % mod;
			}
		}else {
			double avg = (double)sump/pos;
			for (int i = 0; i < 41; i++) {
				if (i <= avg && !(pr2 > pr1 && pr1 > i))
				ret = (ret + func(pos+1, i, pr1, sump + i)) % mod;
			}
		}
		
		return dp[pos][pr1][pr2][sump] = ret;		
	}
	public int theCount(int[] seq)
	{
		n = seq.length;
		this.seq = seq;
		
		dp = new int[n+1][41][41][1600];
		for (int[][][] tmp : dp)
			for (int[][] tmp1: tmp)
				for (int[] tmp2: tmp1)
					Arrays.fill(tmp2, -1);
		
		return func(0, 0, 0, 0);				
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new FoxAverageSequence().theCount(new int[]{3, -1});
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
		answer = new FoxAverageSequence().theCount(new int[]{5, 3, -1});
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
		answer = new FoxAverageSequence().theCount(new int[]{-1, 0, 40});
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
		answer = new FoxAverageSequence().theCount(new int[]{-1, 40, -1, -1, -1, 10, -1, -1, -1, 21, -1});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 579347890;
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
		answer = new FoxAverageSequence().theCount(new int[]{-1, 12, 25, 0, 18, -1});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 58;
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
