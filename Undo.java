import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class Undo
{
	int getT(String S)
	{
		int ret = 0;
		String arr[] = S.split(" ");
		ret  = Integer.parseInt(arr[1]);
		return ret;
	}
	String getS(String S)
	{
		String arr[] = S.split(" ");
		return arr[1];
	}
	public String getText(String[] commands, int[] time)
	{
		int n = time.length;
		int cur = time[n-1];
		
		boolean undo = false;
		String ret = "";
		
		
		for (int i = n-1; i > -1; i--) {
			
			if (undo == false) {
				if (commands[i].charAt(0) == 'u') {
					undo = true;
					cur = cur - getT(commands[i]);
				}else {
					ret =  getS(commands[i]) + ret;
					cur = time[i];
				}
			}else {
				int tm = time[i];
				if (tm >= cur)
					continue;
				else {
					cur = tm;
					undo = false;
					if (commands[i].charAt(0) == 'u') {
						undo = true;
						cur = cur - getT(commands[i]);
					}else {
						ret =  getS(commands[i]) + ret;
						cur = time[i];
					}
				}	
			}
		}
		
		return ret;
	}
	
	public static void main(String[] args)
	{
		long time;
		String answer;
		boolean errors = false;
		String desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new Undo().getText(new String[]{"type a", "type b", "type c", "undo 3"}, new int[]{1, 2, 3, 5});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "a";
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
		answer = new Undo().getText(new String[]{"type a", "type b", "undo 2", "undo 2"}, new int[]{1,2,3,4});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "a";
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
		answer = new Undo().getText(new String[]{"type a", "undo 1", "undo 1"}, new int[]{1,2,3});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "a";
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
		answer = new Undo().getText(new String[]{"type a", "type b", "type c", "undo 10"}, new int[]{1, 2, 3, 1000});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "abc";
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
		answer = new Undo().getText(new String[]{"undo 1"}, new int[]{1});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "";
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
