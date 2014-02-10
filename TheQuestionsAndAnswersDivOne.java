import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class TheQuestionsAndAnswersDivOne
{
	boolean[] mat;
	int tot;
	
	int rec(int un, int yn, int nn, int pos)
	{
		if (pos == mat.length) {
			if (un == 0)
				return 1;
			return 0;	
		}
		
		int ans = 0;
		if (un > 0) {
			if (mat[pos])
				ans +=  un * rec(un-1, yn+1, nn, pos+1);
			else 
				ans += un * rec(un-1, yn, nn+1, pos+1);	 
		}
		if (yn > 0 && mat[pos])
			ans += yn * rec(un, yn, nn, pos+1);
		else if (nn > 0 && !mat[pos])
			ans += nn * rec(un, yn, nn, pos+1);
		return ans;		
	}
	
	public int find(int questions, String[] answers)
	{
		tot = questions;
		int n = answers.length;
		mat = new boolean[n];
		for (int i = 0; i < answers.length; i++) {
			if (answers[i].equals("Yes"))
				mat[i] = true;
		}
		
		return rec(questions, 0, 0, 0); 
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new TheQuestionsAndAnswersDivOne().find(2, new String[]{"No", "Yes"});
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
		answer = new TheQuestionsAndAnswersDivOne().find(2, new String[]{"No", "No", "No"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 6;
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
		answer = new TheQuestionsAndAnswersDivOne().find(3, new String[]{"Yes", "No", "No", "Yes"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 12;
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
		answer = new TheQuestionsAndAnswersDivOne().find(3, new String[]{"Yes", "Yes", "Yes", "No"});
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
