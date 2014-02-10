import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class SentenceDecomposition
{
	boolean func(String s, String s1)
	{
		int dp[] = new int[26];
		for (int i = 0; i < s.length(); i++) {
			dp[s.charAt(i) -'a']++;
			dp[s1.charAt(i)-'a']--;
		}
		for (int i = 0; i < 26; i++)
			if (dp[i] > 0)
				return false;
		return true;		
	}
	
	int Cost(String s, String s1)
	{
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != s1.charAt(i))
				ans++;
		}
		return ans;
	}
	public int decompose(String sentence, String[] validWords)
	{
		int n = validWords.length;
		int sz = sentence.length();
		int inf = 1000;
		
		int dp[] = new int[sz+1];
		Arrays.fill(dp, inf);
		
		dp[0] = 0;
		
		for (int i = 1; i < sz+1; i++) {
			
			
			for (int j = 0; j < n; j++) {
				int l = validWords[j].length();
				
				if (i >= l) {
					String s = sentence.substring(i-l, i);
					if (func(s, validWords[j])) {
						dp[i] = Math.min(dp[i], dp[i-l] + Cost(s, validWords[j]));
					}
				}
			}
		}
		
		return (dp[sz] == inf) ? -1: dp[sz];
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new SentenceDecomposition().decompose("neotowheret", new String[]{"one", "two", "three", "there"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 8;
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
		answer = new SentenceDecomposition().decompose("abba", new String[]{"ab", "ac", "ad"});
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
		answer = new SentenceDecomposition().decompose("thisismeaningless", new String[]{"this", "is", "meaningful"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = -1;
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
		answer = new SentenceDecomposition().decompose("ommwreehisymkiml", new String[]{"we", "were", "here", "my", "is", "mom", "here", "si", "milk", "where", "si"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 10;
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
		answer = new SentenceDecomposition().decompose("ogodtsneeencs", new String[]{"go", "good", "do", "sentences", "tense", "scen"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 8;
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
		answer = new SentenceDecomposition().decompose("sepawaterords", new String[]{"separate","words"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = -1;
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
