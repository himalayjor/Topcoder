import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class MatrixTransforming
{
	boolean[][]  conv(String[] a)
	{
		int n = a.length;
		int m = a[0].length();
		boolean[][] arr = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i].charAt(j) == '1')
					arr[i][j] = true;
			}
		}
		return arr;
	}
	
	public int minPushes(String[] a, String[] b)
	{
		int n = a.length;
		int m = a[0].length();
		
		boolean A[][] = conv(a);
		boolean B[][] = conv(b);
		
		int ans = 0;
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < m; j++) {
				if (A[i][j] != B[i][j]) {
					if (i+3 <=n && j+3 <= m) {
						ans++;
						System.out.println(i + " " + j);
						for (int k1 = i; k1 < i+3; k1++) {
							for (int k2 = j; k2 < j+3; k2++) {
								A[k1][k2] = !A[k1][k2];
							}
						}
					}else
						return -1;
						
				}
			}
		}
		return ans;
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new MatrixTransforming().minPushes(new String[]{"111","111","111"}, new String[]{"000","000","000"});
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
		answer = new MatrixTransforming().minPushes(new String[]{"1"}, new String[]{"0"});
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
		answer = new MatrixTransforming().minPushes(new String[]{"001","100","100","000","011","010","100","100","010","010","010","110","101","101","000","110","000","110"}, new String[]{"001","100","011","000","100","010","011","100","101","101","010","001","010","010","111","110","111","001"});
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
		answer = new MatrixTransforming().minPushes(new String[]{"0000","0010","0000"}, new String[]{"1001","1011","1001"});
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
		
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}

}
//Powered by [KawigiEdit] 2.0!
