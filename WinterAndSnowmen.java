import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class WinterAndSnowmen
{
	int dp[][][];
	int bit;
	int mod = (int)(1e9 + 7);
	int N, M;
	int func(int t, int z, int b)
	{
		if (dp[t][z][b] > -1)
			return dp[t][z][b];
			
		if (t  == 0) {
			if (b == 0 && z == 1)
			 	return dp[t][z][b] = 1;
			 return dp[t][z][b] = 0;	 		
		}
		
		
		int ret = 0;		
		if (t <= N) {
			int k = ((t & (1 << bit)) != 0) ? 1 : 0;
			ret = func(t-1, z^(t >> bit), b^k);
		}
		
		if (t <= M)
			ret = (ret + func(t-1, z^(t >> bit), b)) % mod;
		
		ret = (ret + func(t-1, z, b)) % mod;
		
		return dp[t][z][b] = ret;				
	}
	public int getNumber(int N, int M)
	{
		int ma = Math.max(N,M);
		dp = new int[ma+1][2048][2];
		this.N = N;
		this.M = M;
		
		int ret = 0;
		for (int i = 0; i < 11; i++) {
			for (int[][] tmp1 : dp)
				for (int[] tmp : tmp1)
					Arrays.fill(tmp, -1);
			this.bit = i;
			ret = (ret + func(ma, 0, 0)) % mod;		
		}
		return ret;
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new WinterAndSnowmen().getNumber(2, 2);
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
		answer = new WinterAndSnowmen().getNumber(1, 1);
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
		answer = new WinterAndSnowmen().getNumber(3, 5);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 74;
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
		answer = new WinterAndSnowmen().getNumber(7, 4);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 216;
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
		answer = new WinterAndSnowmen().getNumber(47, 74);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 962557390;
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
