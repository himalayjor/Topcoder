import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class LittleElephantAndIntervalsDiv2
{
	int col[], L[], R[];
	int tot;
	HashSet<String> se;
	int M;
	void process()
	{
		int seq[] = new int[M+1];
		for (int i = 0; i < col.length; i++) {
			
			for (int j = L[i]; j <= R[i]; j++)
				seq[j] = col[i];
				
		}
		StringBuilder sb = new StringBuilder();
		for (int val : seq) {
			char ch = (val == 0) ? 'a' : 'b' ;
			sb.append(ch);
		}
		
			if (!se.contains(sb.toString())) {
				tot++;
				se.add(sb.toString());
			}		
	}
	void back(int p, int tot)
	{
		if (p == tot) {
			process();
			return;
		}
		col[p] = 0;
		back(p+1, tot);
		col[p] = 1;
		back(p+1, tot);
	}
	public int getNumber(int M, int[] L, int[] R)
	{
		int st = L.length;
		col = new int[st];
		tot = 0;
		this.M = M;
		this.L = L;
		this.R = R;
		se = new HashSet<String>();
		back(0,st);
		
		return tot;
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new LittleElephantAndIntervalsDiv2().getNumber(4, new int[]{1, 2, 3}, new int[]{1, 2, 3});
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
		answer = new LittleElephantAndIntervalsDiv2().getNumber(3, new int[]{1, 1, 2}, new int[]{3, 1, 3});
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
		answer = new LittleElephantAndIntervalsDiv2().getNumber(100, new int[]{47}, new int[]{74});
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
		answer = new LittleElephantAndIntervalsDiv2().getNumber(100, new int[]{10, 20, 50}, new int[]{20, 50, 100});
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
		answer = new LittleElephantAndIntervalsDiv2().getNumber(42, new int[]{5, 23, 4, 1, 15, 2, 22, 26, 13, 16}, new int[]{30, 41, 17, 1, 21, 6, 28, 30, 15, 19});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 512;
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
