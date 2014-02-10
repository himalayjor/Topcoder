import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class WolfInZooDivTwo
{
   int[] left;
   int[] right;
   int dp[][];
   int N;
   int mod = 1000000007;
   int func(int at, int last)
   {
   		if (at > N)
   			return 1;
   		
   		if (dp[at][last] > 0)
   			return dp[at][last];	
   		
   		boolean flag = true;
   		for (int i = 0; i < left.length; i++) {
   			if (right[i] == at) {
   				if (left[i] > last) {
   					flag = false;
   					break;
   				}	
   			}
   		}
   		
   		int ret = 0;
   		if (flag)
   			ret = func(at+1, last) % mod;
   		ret = (ret + func(at+1, at) ) % mod;
   		
   		return dp[at][last] = ret;										
   }
	public int count(int N, String[] L, String[] R)
	{
		this.N = N;
		StringBuilder sb = new StringBuilder();
		for (int i  =0 ;i < L.length; i++) {
			sb.append(L[i]);
		}
		StringBuilder sb1 = new StringBuilder();
		for (int i  = 0; i < R.length; i++) {
			sb1.append(R[i]);
		}
		
		String A[] = sb.toString().split(" ");
		String B[] = sb1.toString().split(" ");
		int m = A.length;
		
	    left = new int[m];
		right = new int[m];
		
		for (int i = 0; i < m; i++) {
			left[i] = Integer.parseInt(A[i]) + 1;
			right[i] = Integer.parseInt(B[i]) + 1;
		}
		
		dp = new int[N+1][N+1];
		for (int[] arr: dp)
			Arrays.fill(arr, -1);
		
		return func(1,0);
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new WolfInZooDivTwo().count(5, new String[]{"0 1"}, new String[]{"2 4"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 27;
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
		answer = new WolfInZooDivTwo().count(10, new String[]{"0 4 2 7"}, new String[]{"3 9 5 9"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 798;
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
		answer = new WolfInZooDivTwo().count(100, new String[]{"0 2 2 7 10 1","3 16 22 30 33 38"," 42 44 49 51 57 60 62"," 65 69 72 74 77 7","8 81 84 88 91 93 96"}, new String[]{"41 5 13 22 12 13 ","33 41 80 47 40 ","4","8 96 57 66 ","80 60 71 79"," 70 77 ","99"," 83 85 93 88 89 97 97 98"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 250671525;
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
		answer = new WolfInZooDivTwo().count(3, new String[]{"1"}, new String[]{"2"});
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
