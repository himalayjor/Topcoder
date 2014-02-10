import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class PlayingCubes
{
	String[] cubes;
	int n;
	int leftof[];
	boolean seenR[];
	boolean seenL[];
	boolean G[][];
	
	boolean bpm(int s)
	{
		if (seenL[s])
			return false;
		seenL[s] = true;
		
		for (int i = 0; i < n; i++) {
			if (G[s][i] && !seenR[i]) {
				seenR[i] = false;
				if (leftof[i] == -1 || bpm(leftof[i])) {
					leftof[i] = s;
					return true;
				}
			}
		}
		return false;		
	}		
	boolean func(String S)
	{
		int l = S.length();
		G = new boolean[l][n];
		
		for (int i = 0; i < l; i++) {
			char ch = S.charAt(i);
			for (int j = 0; j < n; j++) {
				if (cubes[j].indexOf(ch) != -1)
					G[i][j] = true;
			}
		}
		
		leftof = new int[n];
		seenL = new boolean[l];
		seenR = new boolean[n];
		
		int ans = 0;
		Arrays.fill(leftof, -1);
		
		for (int i = 0; i < l; i++) {
			Arrays.fill(seenL, false);
			Arrays.fill(seenR, false);
			if (bpm(i))
				ans++;
		}
		return ans == l;
	} 
	public int[] composeWords( String[] cubes, String[] words)
	{
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int m = words.length;
		n = cubes.length;
		this.cubes = cubes;
		
		for (int i = 0; i< m; i++) {
			if (func(words[i]))
				arr.add(i);
		}
		
		int ret[] = new int[arr.size()];
		for (int i = 0; i<arr.size(); i++)
			ret[i] = arr.get(i);
			
		return ret; 
	}
public static void main(String[] args)
	{
		long time;
		int[] answer;
		boolean errors = false;
		int[] desiredAnswer;
		
		boolean same;
		
		time = System.currentTimeMillis();
		answer = new PlayingCubes().composeWords(new String[]{"ABCDEF", "DEFGHI", "OPQRST", "ZZZZZZ", "YYYYYY"}, new String[]{"CAT", "DOG", "PIZZA"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new int[]{1 };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ " + answer[0]);
			for (int i=1; i<answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new PlayingCubes().composeWords(new String[]{"ABCDEF", "DEFGHI", "OPQRST", "MNZLSA", "QEIOGH", "IARJGS"}, new String[]{"DOG", "CAT", "MOUSE", "BIRD", "CHICKEN", "PIG", "ANIMAL"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new int[]{0, 1, 3, 5 };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ " + answer[0]);
			for (int i=1; i<answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new PlayingCubes().composeWords(new String[]{"AAAAAA", "AAAAAA", "AAAAAA", "AAAAAA"}, new String[]{"AA", "AAA", "AAAA", "AAAAA", "AAAAAA"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new int[]{0, 1, 2 };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ " + answer[0]);
			for (int i=1; i<answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new PlayingCubes().composeWords(new String[]{"ABCDEF", "DEFGHI", "OPQRST", "ZZZZZZ", "ZZZZZZ"}, new String[]{"CAT", "DOG", "PIZZA"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new int[]{1, 2 };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ " + answer[0]);
			for (int i=1; i<answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
				same = false;
		if (!same)
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
