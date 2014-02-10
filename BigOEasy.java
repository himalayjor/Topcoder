import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class BigOEasy
{
	boolean G[][];
	boolean vis[];
	boolean  rec[];
	
	boolean isCycle(int s)
	{
		System.out.print(s);
		if (!vis[s]) {
			vis[s] = true;
			rec[s] = true;
			
			for (int i = 0; i < vis.length; i++) {
				if (!G[s][i] )
					continue;
				if (!vis[i] && isCycle(i))
					return true;
				else if (rec[i])
					return true;		
			}
		}
		rec[s] = false;
		return false;
	}
	public String isBounded(String[] graph)
	{
		int n;
		n = graph.length;
		G = new boolean[n][n];
		vis = new boolean[n];
		rec = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (graph[i].charAt(j) == 'Y')
					G[i][j] = true;
			}
		}
		System.out.println(G[2][0]);
		
		for (int i = 0; i < n; i++) {
			for ( int j = 0; j < n; j++) {
				if (G[i][j] && G[j][i])
				return "Unbounded";
			}
		}
		
		for (int i = 0; i < n; i++) {
			if (!vis[i] && isCycle(i))
				return "Unbounded";
		}
		return "Bounded";								
	}
	
	public static void main(String[] args)
	{
		long time;
		String answer;
		boolean errors = false;
		String desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new BigOEasy().isBounded(new String[]{"NYY", "YNY", "YYN"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Unbounded";
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
		answer = new BigOEasy().isBounded(new String[]{"NYYN", "NNNY", "NNNY", "NNNN"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Bounded";
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
		answer = new BigOEasy().isBounded(new String[]{"NYN", "NNY", "YNN"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Bounded";
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
		answer = new BigOEasy().isBounded(new String[]{"NYYN", "YNNN", "NNNY", "NNYN"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Bounded";
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
		answer = new BigOEasy().isBounded(new String[]{"NYY", "YNN", "YNN"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Unbounded";
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
		answer = new BigOEasy().isBounded(new String[]{"NYNYN", "NNYNY", "YNNNN", "NNNNN", "YNNNN"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Unbounded";
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
		answer = new BigOEasy().isBounded(new String[]{"NYYN", "NNYN", "NNNY", "YNNN"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Unbounded";
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
		answer = new BigOEasy().isBounded(new String[]{"NYYNNNNYNNYNYNNNNYYNNYNYNNNNNNNNNNYNNNNNNNYYNYNNNN", "NNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN", "NNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN", "YYYNYYNYYYYYYYYYYYYYYYYYYNYYYYYYYYYYYYYYNYYYYYNYYN", "YYYNNNNYNNYNYNNNNYYNNNNYNNNNNNNNNNYNNNNNNNYYNYNNNN", "YYYNYNNYNNYYYNNNYYYNNYNYNNYNYYYNYYYYYYNYNYYYNYNYNN", "YYYYYYNYYYYYYYYYYYYYYYYYYNYNYYYYYYYYYYYYNYYYYYNYYN", "NYYNNNNNNNYNYNNNNYNNNNNYNNNNNNNNNNNNNNNNNNYNNYNNNN", "YYYNYNNYNNYYYNNNNYYNNYNYNNYNYYYYYYYYYYNYNYYYNYNYNN", "YYYNYNNYNNYYYNNNNYYNYYNYNNYNYYYNYYYYYYNYNYYYNYNYNN", "NNNNNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNN", "NYYNNNNYNNYNYNNNNYYNNNNYNNNNNNNNNNYYNNNNNNYYNYNNNN", "NNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN", "YYYNYNNYYNYYYNNNNYYNNYNYNNYNYYYNYYYYYYNYNYYYNYNYNN", "YYYNYNNYNNYYYNNNNYYYNYNYNNYNYYYNYYYYYYNYNYYYNYNYNN", "YYYNYNNYNNYYYNNNNYYNNYYYNNYNYYYNYYYYYYNYNYYYNYNYNN", "YYYNYNNYNYYYYNNNNYYNNYNYNNYNYYYNYYYYYYNYNYYYNYNYNN", "NNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN", "NYYNNNNNNNYNYNNNNYNNNNNYNNNNNNNNNNYNNNNNNNNNNYNNNN", "YYYNYNNYNNYYYNNNNYYNNYNYNNYNYYYNYYYYYYYYNYYYNYNYNN", "YYYNYNNYNNYYYNNNNYYNNYNYYNYNYYYNYYYYYYNYNYYYNYNYNN", "NYYNNNNYNNYNYNNNNYYNNNNYNNNNNNYNNNYNNNNNNNYYNYNNNN", "YYYNYYNYNNYYYNNNNYYNNYNYNNYNYYYNYYYYYYNYNYYYNYNYNN", "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNYNNNN", "YYYNYNNYNNYYYYNNNYYNNYNYNNYNYYYNYYYYYYNYNYYYNYNYNN", "YYYNYYNYYYYYYYYYYYYYYYYYYNYNYYYYYYYYYYYYNYYYYYNYYY", "NYYNNNNYNNYNYNNNNYYNNNNYNNNNYNNNNNYNNNNNNNYYNYNNNN", "YYYNYYNYYYYYYYYYYYYYYYYYYNYNYYYYYYYYYYYYYYYYYYNYYN", "NYYNNNNYNNYNYNNNNYYNNNNYNNNNNNNNNNYNNNNNNNYYNYNYNN", "NYYNNNNYNNYYYNNNNYYNNNNYNNNNNNNNNNYNNNNNNNYYNYNNNN", "NYYNNNNYNNYNYNNNNYYNNNNYNNYNNNNNNNYNNNNNNNYYNYNNNN", "YYYNYNNYNNYYYNYNNYYNNYNYNNYNYYYNYYYYYYNYNYYYNYNYNN", "YYYNYNNYNNYYYNNNNYYNNYNYNNYNYYYNNYYYNYNYNYYYNYNYNN", "NYYNNNNYNNYNYNNNNYYNNNNYNNNNNNNNNNYNNNNYNNYYNYNNNN", "NYYNNNNYNNYNYNNNNYNNNNNYNNNNNNNNNNNNNNNNNNNNNYNNNN", "NYYNNNNYNNYNYNNNNYYNNNNYNNNNNNNNNYYNNNNNNNYYNYNNNN", "YYYNYNNYNNYYYNNNNYYNNYNYNNYNYYYNYYYYNNNYNYYYNYNYNN", "YYYNYNNYNNYYYNNNNYYNNYNYNNYNYYYNNYYYYNNYNYYYNYNYNN", "YYYNYNNYNNYYYNNYNYYNNYNYNNYNYYYNYYYYYYNYNYYYNYNYNN", "NYYNNNNYNNYNYNNNNYYNNNNYNNNNNNNNNNYNNNNNNYYYNYNNNN", "YYYNYYNYYYYYYYYYYYYYYYYYYNYNYYYYYYYYYYYYNYYYYYYYYN", "NYYNYNNYNNYNYNNNNYYNNNNYNNNNNNNNNNYNNNNNNNYYNYNNNN", "NYYNNNNNNNYNYNNNNYNNNNNYNNNNNNNNNNNNNNNNNNNYNYNNNN", "NYYNNNNNNNYNYNNNNYYNNNNYNNNNNNNNNNNNNNNNNNNNNYNNNN", "YYYNYYNYYYYYYYYYYYYYYYYYYNYNYYYYYYYYYYYYNYYYNYNYNN", "NYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN", "YYYNYYNYYYYYYYYYYYYYYYYYYYYNYYYYYYYYYYYYNYYYYYNYYN", "NYYNNNNYNNYNYNNNNYYNNNNYNNNNNYNNNNYNNNNNNNYYNYNNNN", "YYYNYYNYYYYYYYYYYYYYYYYYYNYNYYYYYYYYYYYYNYYYYYNYNN", "YYYNYYYYYYYYYYYYYYYYYYYYYNYNYYYYYYYYYYYYNYYYYYNYYN"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Bounded";
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
