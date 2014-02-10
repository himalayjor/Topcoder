import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class InfiniteSoup
{
	int R = 3;
	int Q = 997;
	int maxwordsize = 0;
	String[] g;
	int hash(String key, int M)
	{
		int h = 0;
		for (int i = 0; i < M; i++) {
			h = (h*R%Q + key.charAt(i)) % Q;
		}
		return h;
	}
	int gcd(int a, int b)
	{
		if (a == 0)
			return b;
		return (b == 0) ? a : gcd(b, a%b);	
	}
	String getRay(int x, int y)
	{
		StringBuilder sb = new StringBuilder();
		 int R1 = g.length;
		 int C = g[0].length();
		 
		 sb.append(g[0].charAt(0));
		 int xx = x%C;
		 int yy = y%R1;
		 
		 while (xx != 0 || yy != 0) {
		 	sb.append(g[yy].charAt(xx));
		 	xx += x;
		 	yy += y;
		 	xx %= C;
		 	yy %= R1;
		 }
		 
		 String basic = sb.toString();
		 int times = (maxwordsize + basic.length()-1)/basic.length();
		 for (int i = 0; i < times; i++)
		 	sb.append(basic);
		 return sb.toString();	
	}
	boolean rabin(String ray, int phash, int M, String word)
	{
		if (ray.length() < M)
			return false;
				
		int thash = hash(ray, M);
		if (thash == phash)
			return true;
		int rm = 1;
		for (int i = 1; i <= M-1; i++)
			rm = (rm * R) % Q;
				
		for (int i = M; i < ray.length(); i++) {
			char c = ray.charAt(i-M);
			thash = (thash + Q - (rm*c)%Q)%Q;
			thash = (thash * R % Q + ray.charAt(i)) % Q;
			if (thash == phash) {
					int id = ray.indexOf(word);
					if (id != -1)				
						return true;		
			}
		} 
		return false;	
	}
	public int[] countRays(String[] g, String[] words, int k)
	{
		int n = words.length;
		this.g = g;
		int[] pathash = new int[n];
		for (int i = 0; i < n; i++) {
			maxwordsize = Math.max(maxwordsize, words[i].length());
			pathash[i] = hash(words[i], words[i].length());
		}	
		
		int ret[] = new int[n];
		for (int i = 0; i <= k; i++) {
			for (int j = 0; j <= k; j++) {
				if (gcd(i,j) != 1)
					continue;
				String ray = getRay(i,j);
				
				for (int l = 0; l < n; l++) {
					if(rabin(ray, pathash[l], words[l].length(), words[l]))
						ret[l]++;
					
				}	
			}
		}
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
		answer = new InfiniteSoup().countRays(new String[]{"abc","def","ghi"}, new String[]{"abc"}, 2);
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
		answer = new InfiniteSoup().countRays(new String[]{"abc","def","ghi"}, new String[]{"abc"}, 3);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new int[]{2 };
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
		answer = new InfiniteSoup().countRays(new String[]{"abc","def","ghi"}, new String[]{"abc"}, 4);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new int[]{3 };
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
		answer = new InfiniteSoup().countRays(new String[]{"ccbbc","baabc","ccbab","cbcaa","aacab"}, new String[]{"aaccbaaccbaacc","aabbcaabbcaabbc","babccbabccbabc","aaacaaaacaaaaca", "abbcaabbcaab","ccbbcccbbcccbbc","bbacabbacab","caacccaacccaac", "baaccbaaccbaac","caccbcaccbca"}, 10);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new int[]{0, 2, 0, 0, 2, 7, 5, 6, 0, 5 };
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
		answer = new InfiniteSoup().countRays(new String[]{"abb","bbb","bbb"}, new String[]{"aaa"}, 2);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new int[]{0 };
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
