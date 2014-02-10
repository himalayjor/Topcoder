import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class RunningLetters
{
	int[] prefix(String S)
	{
		int pre[] = new int[S.length()];
		int cur = 0;
		
		for (int i = 1; i < S.length(); i++) {
			
			while (cur > 0 && S.charAt(cur) != S.charAt(i)) {
				cur = pre[cur-1];
			}
			
			if (S.charAt(i) == S.charAt(cur)) 
				cur++;
			pre[i] = cur;	
		}
		return pre;
	}
	
	public int newsLength(String[] running)
	{
		StringBuilder sb = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		
		for (int i = 0; i < running.length; i++) {
			sb1.append(running[i]);
		}
		String s = sb1.toString();
		String arr[] = s.split(" ");
		
		for (int i = 0; i < arr.length; i += 2) {
			
			int amt = Integer.parseInt(arr[i]);
			for (int j = 0; j < amt; j++)
				sb.append(arr[i+1]);
		}
	
	
		String S = sb.toString();
		
		int[] pre = prefix(S);
		return S.length() - pre[S.length()-1];
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new RunningLetters().newsLength(new String[]{"3 abc 1 ab"});
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
		answer = new RunningLetters().newsLength(new String[]{"1 babaaba"});
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
		answer = new RunningLetters().newsLength(new String[]{"1 ba 1 c 1 bacba 3 cba"});
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
		answer = new RunningLetters().newsLength(new String[]{"42 runningletters 42 runningletters 1 running"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 14;
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
		answer = new RunningLetters().newsLength(new String[]{"1 b ", "1 a ", "1 b ", "1 a", " 1 b"});
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
		
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}

}
//Powered by [KawigiEdit] 2.0!
