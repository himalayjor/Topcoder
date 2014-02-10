import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class ForbiddenStrings
{
	int n;
	long dp[][][];
	long func(int id, int p1, int p2)
	{
		if (id == n-1) {
			if (p1 == p2)
				return 3;
			else if (p1 != p2)
				return 2;	
		}
		
		if (dp[id][p1][p2] > 0)
			return dp[id][p1][p2];
			
		long ret = 0;
		if (p1 == p2) {
		
			ret += func(id+1, p1, 0);
			ret += func(id+1, p1, 1);
			ret += func(id+1, p1, 2);
		}else if (p1 != p2) {
			ret += func(id+1, p2, p1);
			ret += func(id+1, p2, p2);
		}						
		dp[id][p1][p2] = ret;
		return ret;
	}			
	public long countNotForbidden(int n)
	{
		this.n = n;
		if (n == 1)
			return 3;
		else if (n == 2)
			return 9;
		
		dp = new long[n+1][3][3];	
		long ret = 0;			
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				ret += func(2, i, j);
			}
		}
		return ret;	  
	}
	public static void main(String[] args)
	{
		long time;
		long answer;
		boolean errors = false;
		long desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new ForbiddenStrings().countNotForbidden(2);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 9L;
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
		answer = new ForbiddenStrings().countNotForbidden(3);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 21L;
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
		answer = new ForbiddenStrings().countNotForbidden(4);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 51L;
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
