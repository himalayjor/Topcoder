import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class CombinationLockDiv2
{
	class state {
		String S;
		int move;
		state(String ss, int m)
		{
			S = ss;
			move = m;
		}
	}
	
	String nextU(String S, int j, int len)
	{
		char arr[] = S.toCharArray();
		for (int  i  = j; i < j + len; i++) {
			
			if (arr[i] == '9')
				arr[i] = '0';
			else
				arr[i] = (char)(arr[i] + 1);	
		}
		return new String(arr);
	}
	String nextD(String S, int j, int len)
	{
		char arr[] = S.toCharArray();
		for (int  i  = j; i < j + len; i++) {
			
			if (arr[i] == '0')
				arr[i] = '9';
			else
				arr[i] = (char)(arr[i] - 1);	
		}
		return new String(arr);
	}
	int diff(String S, String T)
	{
		int ans = 0;
		int ma, mi;
		int a, b;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) > T.charAt(i)) {
				ma = S.charAt(i) - '0';
				mi = T.charAt(i) - '0';
			}else {
				ma = T.charAt(i) - '0';
				mi = S.charAt(i) - '0';
			}
			ans += Math.min( ma - mi, mi + 9 - ma);
		}
		
		return ans;
	}
	public int minimumMoves(String S, String T)
	{
		if (S.equals(T))
			return 0;
		
		int d = Integer.MAX_VALUE;
		
		
		int val = 0;
		
		for (int store = 1; store <= S.length(); store++) {
			String S1 = S.substring(0, store);
			String T1 = T.substring(0, store);
			int a = 0, b = 0;
			String cp = S1;
			
			while (!S1.equals(T1)) {
				
					a++;
					System.out.println(S1 + " " + T1);
					S1 = nextU(S1, 0, store);
			}
			while(!cp.equals(T1)) {
				b++;
				cp = nextD(cp, 0, store);
			}	
			if (d > Math.min(a,b)) {
				d = Math.min(a,b);
				val = store;
			}	
		}
		
		return d + 	minimumMoves(S.substring(val), T.substring(val));	
		
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new CombinationLockDiv2().minimumMoves("123", "112");
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
		answer = new CombinationLockDiv2().minimumMoves("1", "7");
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
		answer = new CombinationLockDiv2().minimumMoves("607", "607");
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
		answer = new CombinationLockDiv2().minimumMoves("1234", "4567");
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
		answer = new CombinationLockDiv2().minimumMoves("020", "909");
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
		answer = new CombinationLockDiv2().minimumMoves("4423232218340", "6290421476245");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 18;
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
