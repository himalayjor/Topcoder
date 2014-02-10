import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class Stamp
{
	String s;
	int col(char ch)
	{
		int ans = -1;
		if (ch == 'R')
			ans = 0;
		else if (ch == 'B')
			ans = 1;
		else if (ch == 'G')
			ans = 2;
		
		return ans;
	}			
	int func(int l)
	{
		int ans = 0;
		int n = s.length();
		int color[] = new int[n];
		Arrays.fill(color, -1);
		
		
		for (int i = 0; i <= n-l; i++) {
			
			int c = col(s.charAt(i));
			if (color[i] == -1 && c == -1) {
				ans++;
				continue;
			}	
			if (c == -1 || color[i] == c)
				continue;
			ans++;
			for (int j = i; j < i+l; j++) 
				color[j] = c;
		}
		
		for (int i = n-l+1; i < n; i++) {
			int c = col(s.charAt(i));
			if (c != -1 && c != color[i])
				return n+1;
		}										
		
		return ans;
	}	
	public int getMinimumCost(String dc, int sc, int pc)
	{
		int n = dc.length();
		this.s = dc;
		int ret = Integer.MAX_VALUE;
		
		boolean f = true;
		for (int i = 0; i < n; i++) {
			if (dc.charAt(i) != '*')
				f = false;
		}
		
		if (f)
			return 1;
					
		for (int l = 1; l < n+1; l++) {
			int p = func(l);
			System.out.println(l + " " + p);
			ret = Math.min(ret, p * pc + sc * l);
		}
		return ret;	
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new Stamp().getMinimumCost("RRGGBB", 1, 1);
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
		answer = new Stamp().getMinimumCost("R**GB*", 1, 1);
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
		answer = new Stamp().getMinimumCost("BRRB", 2, 7);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 30;
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
		answer = new Stamp().getMinimumCost("R*RR*GG", 10, 58);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 204;
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
		answer = new Stamp().getMinimumCost("*B**B**B*BB*G*BBB**B**B*", 5, 2);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 33;
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
		answer = new Stamp().getMinimumCost("*R*RG*G*GR*RGG*G*GGR***RR*GG", 7, 1);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 30;
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
