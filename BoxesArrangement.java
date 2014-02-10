import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class BoxesArrangement
{
	
	int inf = 10000;
	int dp[][][][][];
	int arr[];
	int maxa = 0, maxb = 0, maxc = 0;
	int func(int a, int b, int c, int col, int last)
	{
		if (a > maxa || b > maxb || c > maxc || last == 3)
			return -inf;
		
		
		if (dp[a][b][c][col+1][last] != -1)
			return dp[a][b][c][col+1][last];
			
		int n = a+b+c;
		if (n == arr.length)
			return dp[a][b][c][col+1][last] = 0;
			
		int ret = -inf;													
		for (int i = 0; i < 3; i++) {
			int tmp = ((arr[n] == i) ? 1 :0) + func(a + ((i == 0)?1:0)  , b + ((i == 1)?1:0), c+ ((i == 2)?1:0), i, ((col == i) ? (last + 1) : 1));
			ret = Math.max(ret, tmp);
		}
		return 	dp[a][b][c][col+1][last] = ret;
	}
	public int maxUntouched(String boxes)
	{	
		int n = boxes.length();
		arr = new int[n];
	
		
		for (int i = 0; i < n; i++) {
			if (boxes.charAt(i) == 'A') {
				arr[i] = 0;
				maxa++;
			} else if (boxes.charAt(i) == 'B') {
				maxb++;
				arr[i] = 1;
			} else {
				maxc++;
				arr[i] = 2;
			}			
		}
		dp = new int[51][51][51][4][3];
		for (int[][][][] tmp: dp)
			for (int[][][] tmp1: tmp)
				for (int[][] tmp2: tmp1)
					for (int[] tmp3: tmp2)
						Arrays.fill(tmp3, -1);
		 
		int res = func(0, 0, 0, -1, 0);
		
		 return (res >= 0) ? res : -1; 				
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new BoxesArrangement().maxUntouched("AAABBBCCC");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 6;
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
		answer = new BoxesArrangement().maxUntouched("AAAAAAAACBB");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 7;
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
		answer = new BoxesArrangement().maxUntouched("CCCCCB");
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
		answer = new BoxesArrangement().maxUntouched("BAACAABAACAAA");
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
		answer = new BoxesArrangement().maxUntouched("CBBABA");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 6;
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
