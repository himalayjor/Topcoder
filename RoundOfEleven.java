import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class RoundOfEleven
{
	String S;
	long dp[][][];
	
	long func(int dig, int sum, int money)
	{
		if (dig == S.length()) {
			if ( (sum % 11) ==  0)
				return money;
			else
				return 0;	
		}
		
		if (dp[dig][sum][money] > 0)
			return dp[dig][sum][money];
			
		int diff;
		long ans = 0;
		int ch = S.charAt(dig)-'0';
		for (int i = 0; i < 10; i++) {
			diff = Math.abs(ch-i);
			if (money - diff > 0)
				ans += func(dig+1, ((dig%2==0) ? (sum + i)%11 : (sum+11-i)%11 ), money-diff);
		}
		
		dp[dig][sum][money] = ans;
		return ans;			
	}
	
	public long maxIncome(int n, int money)
	{
		S = "" + n;
		dp = new long[13][11][money+1];
		for (int i = 0; i < 13; i++) 
			for (int j = 0; j < 11; j++)
				Arrays.fill(dp[i][j] , -1);
		
		return func(0, 0, money);			
	}
	
	public static void main(String[] args)
	{
		long time;
		long answer;
		boolean errors = false;
		long desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new RoundOfEleven().maxIncome(31, 4);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 6L;
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
		answer = new RoundOfEleven().maxIncome(31, 5);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 11L;
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
		answer = new RoundOfEleven().maxIncome(110, 3);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 7L;
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
		answer = new RoundOfEleven().maxIncome(19759, 435);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 3788217L;
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
