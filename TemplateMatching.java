import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class TemplateMatching
{
	int pscore(String text, String prefix)
	{
		int l = 0;
		int pl = prefix.length();
		int ans = 0;
		while (l <= text.length() && l <= prefix.length()) {
			if (text.substring(0, l).equals(prefix.substring(pl-l)))
				ans = Math.max(ans, l);
			l++;
		}
		return ans;		
	}
	int sscore(String text, String suffix)
	{
		int l = 0;
		int ans = 0;
		int tl = text.length();
		
		
		while (l <=text.length() && l <= suffix.length() ) {
			if (text.substring(tl - l).equals(suffix.substring(0, l)))
				ans = Math.max(ans, l);
			l++;
		}
		return ans;		
	}
	public String bestMatch(String text, String prefix, String suffix)
	{
		int n = text.length();
		int ans = 0;
		String ret = "";
		int pans = 0;
		
		for (int i = 0; i < n; i++) {
			for (int l = 1; i+l <= text.length(); l++) {
				String sub = text.substring(i, i+l);
				int p = pscore(sub, prefix);
				int s = sscore(sub, suffix);
				
				if (ans < p+s) {
					ans = p+s;
					pans = p;
					ret = sub;
				}else if (ans == p+s && pans < p) {
					pans = p;
					ret = sub;
				}else if (ans == p+s && pans == p){
					if (ret.compareTo(sub) > 0)
						ret = sub;
				}	
				
			}
		}
		if (ans == 0) {
			char ch = text.charAt(0);
			for (int i = 1; i < text.length(); i++) {
				if (ch > text.charAt(i))
					ch = text.charAt(i);
			}
			ret += ch;
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
		answer = new TemplateMatching().bestMatch("something", "awesome", "ingenious");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "something";
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
		answer = new TemplateMatching().bestMatch("havka", "eto", "papstvo");
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
		answer = new TemplateMatching().bestMatch("abracadabra", "habrahabr", "bracket");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "abrac";
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
		answer = new TemplateMatching().bestMatch("mississippi", "promise", "piccolo");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "ippi";
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
		answer = new TemplateMatching().bestMatch("a a a a a a", "a a", "a");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "a a";
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
		answer = new TemplateMatching().bestMatch("ab", "b", "a");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "b";
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
