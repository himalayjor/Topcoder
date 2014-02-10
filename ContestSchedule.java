import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class ContestSchedule
{
	class state implements Comparable<state>
	{
		int s, e, p;
		state(int a, int b, int c)
		{	s = a;
			e = b;
			p = c;
		}	
		public int compareTo(state s1)
		{
			if (e == s1.e) {
				
				if (s == s1.s)
					return p - s1.p;
				return s - s1.s;	
			}
			return e - s1.e;
		}
		
	}		
		
	public double expectedWinnings(String[] con)
	{
		int n = con.length;
		int st[] = new int[n+1];
		int en[] = new int[n+1];
		double pr[] = new double[n+1];
		double dp[] = new double[n+1];
		state ss[] = new state[n];
		
		for (int i = 1; i < n+1; i++) {
			String[] arr = con[i-1].split(" ");
			int s = Integer.parseInt(arr[0]);
			int e = Integer.parseInt(arr[1]);
			int p = Integer.parseInt(arr[2]) ;
			ss[i-1] = new state(s,e,p);
			
		} 
		
		Arrays.sort(ss);
		for (int i = 1; i < n+1; i++) {
			st[i] = ss[i-1].s;
			en[i] = ss[i-1].e;
			pr[i] = ss[i-1].p / 100.0;
			
		}
		double ans = 0.0;
		for (int i = 1; i <n+1; i++) {
			
			for (int j = 0; j < i; j++) {
				
				if (en[j] <= st[i]) {
					dp[i] = Math.max(dp[i], dp[j] + pr[i]);	
				}
			}
			ans = Math.max(ans, dp[i]);
		}
		return ans;
	}
	
	public static void main(String[] args)
	{
		long time;
		double answer;
		boolean errors = false;
		double desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new ContestSchedule().expectedWinnings(new String[]{"1 10 100","10 20 100","20 30 100","30 40 100"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 4.0D;
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
		answer = new ContestSchedule().expectedWinnings(new String[]{"10 20 20","30 40 60","15 35 90"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 0.9D;
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
		answer = new ContestSchedule().expectedWinnings(new String[]{"1 100 85","99 102 100","101 200 60"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 1.45D;
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
		answer = new ContestSchedule().expectedWinnings(new String[]{"1 1000000000 1"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 0.01D;
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
		answer = new ContestSchedule().expectedWinnings(new String[]{"1361955 8940967 10","628145516 644285978 17","883515280 910484865 36","762888635 769291174 52","98152102 136328674 1","9580638 20450682 50","646139319 664648341 20","484027666 505290970 57","841082555 879295329 99","940563715 966953344 4","579113528 595261527 25","925801172 962952912 9","285845005 307916055 45","403573723 410697485 10","9467290 25698952 90","631265400 650639733 3","520690249 559261759 96","491747709 531061081 86","643215695 672420161 94","614608448 617341712 44","456517316 491770747 24","806956091 828414045 88","528156706 559510719 15","158398859 190439269 4","743974602 761975244 49","882264704 887725893 1","877444309 884479317 59","785986538 806192822 19","732553407 747696021 81","132099860 148305810 97","555144412 572785730 99","506507263 535927950 82","489726669 505160939 90","793692316 804153358 99","901329638 919179990 10","29523791 44318662 58","570497239 595701008 73","706091347 730328348 23","118054686 135301010 39","307178252 337804001 93","896162463 900667971 39","271356542 273095245 80","865692962 891795950 91","593986003 596160000 58","807688147 831190344 59","468916697 496462595 92"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 14.12D;
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
