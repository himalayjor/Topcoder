import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class AddElectricalWires
{
	int n;
	boolean G[][];
	int col[];
	
	int dfs(int s, int c)
	{
		int amt = 1;
		col[s] = c;
		for (int i = 0; i < n; i++) {
			if (G[s][i] && col[i] == -1) {
				amt += dfs(i, c);
			}
		}
		return amt;
	}
	
	public int maxNewWires(String[] wires, int[] conn)
	{
		n = wires.length;
		col = new int[n];
		Arrays.fill(col, -1);
		G = new boolean[n][n];
		int ans = 0;
		
		for (int i  = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (wires[i].charAt(j) == '1') {
					G[i][j] = true;
					ans--;
				}
			}	
		}
		
		int c = 0;
		int val[] = new int[conn.length];
		
		
		for (int i =0 ; i < conn.length; i++) {
			val[i] = dfs(conn[i], c++);
		}
		
		Arrays.sort(val);
		for (int i = 0; i < n; i++) {
			if (col[i] == -1)
				val[val.length-1] += dfs(i, c++);
		}
		
		for (int i = 0; i < val.length; i++) {
			ans += (val[i] * (val[i]-1));
		}	
		return ans/2;																																		
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new AddElectricalWires().maxNewWires(new String[]{"000","000","000"}, new int[]{0});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 3;
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
		answer = new AddElectricalWires().maxNewWires(new String[]{"000","000","000"}, new int[]{0,1});
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
		answer = new AddElectricalWires().maxNewWires(new String[]{"01","10"}, new int[]{0});
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
		time = System.currentTimeMillis();
		answer = new AddElectricalWires().maxNewWires(new String[]{"00000","00000","00000","00000","00000"}, new int[]{0,1,2,3,4});
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
		time = System.currentTimeMillis();
		answer = new AddElectricalWires().maxNewWires(new String[]{"01000","10100","01010","00100","00000"}, new int[]{2,4});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 3;
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
