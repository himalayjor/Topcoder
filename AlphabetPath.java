import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class AlphabetPath
{
	int X[] = {1, -1, 0, 0};
	int Y[] = {0, 0, -1, 1};
	
	public String doesItExist(String[] maze)
	{
		int n = maze.length;
		int m = maze[0].length();
		Queue<Integer> qu = new LinkedList<Integer>();
		boolean flag = true;
		
		for (int i = 0; flag && i < n; i++) {
			for (int j = 0; flag && j < m; j++) {
				if (maze[i].charAt(j) == 'A') {
					qu.offer(i*m+j);
					flag = false;
				}
			}
		}
		
		while (!qu.isEmpty()) {
			int s = qu.poll();
			int x = s/m, y = s%m;
			char ch = maze[x].charAt(y);
			if (ch == 'Z')
			  return "YES";
			ch = (char)(ch+1);
			
			for (int k = 0; k < 4; k++) {
				int x1 = x + X[k];
				int y1 = y + Y[k];
				if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= m)
					continue;
				if (maze[x1].charAt(y1) == 	ch) {
					qu.offer(x1*m+y1);
					break;
				}
			}   
		}
		return "NO";
	}
	
	public static void main(String[] args)
	{
		long time;
		String answer;
		boolean errors = false;
		String desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new AlphabetPath().doesItExist(new String[]{"ABCDEFGHIJKLMNOPQRSTUVWXYZ"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "YES";
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
		answer = new AlphabetPath().doesItExist(new String[]{"ADEHI..Z", "BCFGJK.Y", ".PONML.X", ".QRSTUVW"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "YES";
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
		answer = new AlphabetPath().doesItExist(new String[]{"ACBDEFGHIJKLMNOPQRSTUVWXYZ"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "NO";
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
		answer = new AlphabetPath().doesItExist(new String[]{"ABC.......", "...DEFGHIJ", "TSRQPONMLK", "UVWXYZ...."});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "NO";
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
		answer = new AlphabetPath().doesItExist(new String[]{"..............", "..............", "..............", "...DEFGHIJK...", "...C......L...", "...B......M...", "...A......N...", "..........O...", "..ZY..TSRQP...", "...XWVU.......", ".............."});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "YES";
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
