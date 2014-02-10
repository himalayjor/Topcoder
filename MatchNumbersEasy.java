import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class MatchNumbersEasy
{
	public String maxNumber(int[] mat, int n)
	{
		dp = new BigInteger[51];
		for (int i = 0; i < 51; i++)
		{
			dp[i] = BigInteger.valueOf(0);
		}
		BigInteger val = Solve(mat, n);
		return val.toString();
	}
	
	BigInteger dp[];
	BigInteger Solve(int[] mat, int n)
	{
		BigInteger ret = BigInteger.valueOf(0);
		if (dp[n].compareTo(ret) != 0) 
			return dp[n];
		BigInteger ten = BigInteger.valueOf(10);
		for (int i = 0; i < mat.length; i++) {
			
			if (mat[i] <= n) {
				BigInteger tmp = ten.multiply(Solve(mat, n- mat[i])).add(BigInteger.valueOf(i));
				ret = ret.max(tmp);
			}
		}
		dp[n] = ret;
		return ret;
	}
	public static void main(String[] args)
	{
		long time;
		String answer;
		boolean errors = false;
		String desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new MatchNumbersEasy().maxNumber(new int[]{6,7,8}, 21);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "210";
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
		answer = new MatchNumbersEasy().maxNumber(new int[]{5,23,24}, 30);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "20";
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
		answer = new MatchNumbersEasy().maxNumber(new int[]{1,5,3,2}, 1);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "0";
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
		answer = new MatchNumbersEasy().maxNumber(new int[]{1,1,1,1,1,1,1,1,1,1}, 50);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "99999999999999999999999999999999999999999999999999";
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
