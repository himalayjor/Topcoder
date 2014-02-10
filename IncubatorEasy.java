import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class IncubatorEasy
{
	String[] love;
	int n;
	void dfs(int s, boolean[] isp, boolean[] vis)
	{
		vis[s] = true;
		
		for (int i = 0; i < n; i++) {
			if (love[s].charAt(i) == 'Y') {
				isp[i] = true;
				
			}		
		}
		for (int i = 0; i < n; i++) {
			if (love[s].charAt(i) == 'Y' && !vis[i]) 
				dfs(i, isp, vis);	
		}
		
		return;
	}
		
	public int maxMagicalGirls(String[] love)
	{
		this.love = love;
		n = love.length;
		int ma = (1 << n);
		int ret = 0;
		System.out.println(ma);
		
		for (int i = 0; i < ma; i++) {
		
			boolean isp[] = new boolean[n];
			boolean mag[] = new boolean[n];
			boolean vis[] = new boolean[n];
			 for (int j = 0; j < n; j++) {
				
				if ( (i & (1 << j)) != 0) {
					mag[j] = true;
				}
			}  
			for (int j = 0; j < n; j++) {
				if (mag[j])
					dfs(j, isp, vis);
			}
			int ans = 0;
			for (int j = 0; j < n; j++) {
				if ( (isp[j] == false) && mag[j])
					ans++;
			}
			if (i == 31)
				System.out.println(ans);
			ret = Math.max(ret, ans);
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
		answer = new IncubatorEasy().maxMagicalGirls(new String[]{"NY","NN"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 1;
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
		answer = new IncubatorEasy().maxMagicalGirls(new String[]{"NYN", "NNY", "NNN"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 1;
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
		answer = new IncubatorEasy().maxMagicalGirls(new String[]{"NNYNN","NNYNN","NNNYY","NNNNN","NNNNN"});
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
		answer = new IncubatorEasy().maxMagicalGirls(new String[]{"NNNNN","NYNNN","NYNYN","YNYNN","NNNNN"});
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
		answer = new IncubatorEasy().maxMagicalGirls(new String[]{"NNNNN","NNNNN","NNNNN","NNNNN","NNNNN"});
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
		answer = new IncubatorEasy().maxMagicalGirls(new String[]{"Y"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 0;
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
