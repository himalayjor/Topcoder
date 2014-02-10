import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class GooseInZooDivOne
{
	int n,m;
	boolean G[][];
	boolean vis[][];
	int mod =  1000000007;
	int X[] = {0, 0, 1, -1};
	int Y[] = {1, -1, 0, 0};
	int dist;
	
	int bfs(int si, int sj)
	{
		Queue<Integer> qu = new LinkedList<Integer>();
		qu.offer(si*m+sj);
		vis[si][sj] = true;
		int ans = 0;
		
		while (!qu.isEmpty()) {
			int num = qu.poll();
			si = num/m;
			sj = num%m;
			ans++;
				
			for (int r = 0; r < n; r++) {
				for (int c= 0; c < m; c++) {
					
					if (Math.abs(r-si) + Math.abs(c-sj) > dist)
						continue;
					if (G[r][c] && !vis[r][c]) {
						qu.offer(r*m  + c);
						vis[r][c] = true;
					}	
				}
			}
		}
		
		return ans;		
	}
	public int count(String[] field, int dist)
	{
		n = field.length;
		m = field[0].length();
		this.dist = dist;
		G = new boolean[n][m];
		vis = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (field[i].charAt(j) == 'v')
					G[i][j] = true;
			}
		}
		int even = 0;
		int odd = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (G[i][j] && !vis[i][j]) {
					int tmp = bfs(i,j);
					if (tmp % 2 == 0)
						even++;
					else
						odd++;	
				}
			}
		}
		System.out.println(even + " " + odd);
		
		int cnt = even + ((odd > 0) ? (odd-1) : 0);
		long ans = 1;
		
		for (int i = 0; i < cnt; i++) {
			ans = (ans * 2) % mod;
		}
		
		ans = (ans + mod-1) % mod;
		
		return (int)ans;
	}
public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new GooseInZooDivOne().count(new String[]{"vvv"}, 0);
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
		answer = new GooseInZooDivOne().count(new String[]{"."}, 100);
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
		answer = new GooseInZooDivOne().count(new String[]{"vvv"}, 1);
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
		answer = new GooseInZooDivOne().count(new String[]{"v.v..................v............................",".v......v..................v.....................v","..v.....v....v.........v...............v......v...",".........vvv...vv.v.........v.v..................v",".....v..........v......v..v...v.......v...........","...................vv...............v.v..v.v..v...",".v.vv.................v..............v............","..vv.......v...vv.v............vv.....v.....v.....","....v..........v....v........v.......v.v.v........",".v.......v.............v.v..........vv......v.....","....v.v.......v........v.....v.................v..","....v..v..v.v..............v.v.v....v..........v..","..........v...v...................v..............v","..v........v..........................v....v..v...","....................v..v.........vv........v......","..v......v...............................v.v......","..v.v..............v........v...............vv.vv.","...vv......v...............v.v..............v.....","............................v..v.................v",".v.............v.......v..........................","......v...v........................v..............",".........v.....v..............vv..................","................v..v..v.........v....v.......v....","........v.....v.............v......v.v............","...........v....................v.v....v.v.v...v..","...........v......................v...v...........","..........vv...........v.v.....................v..",".....................v......v............v...v....",".....vv..........................vv.v.....v.v.....",".vv.......v...............v.......v..v.....v......","............v................v..........v....v....","................vv...v............................","................v...........v........v...v....v...","..v...v...v.............v...v........v....v..v....","......v..v.......v........v..v....vv..............","...........v..........v........v.v................","v.v......v................v....................v..",".v........v................................v......","............................v...v.......v.........","........................vv.v..............v...vv..",".......................vv........v.............v..","...v.............v.........................v......","....v......vv...........................v.........","....vv....v................v...vv..............v..","..................................................","vv........v...v..v.....v..v..................v....",".........v..............v.vv.v.............v......",".......v.....v......v...............v.............","..v..................v................v....v......",".....v.....v.....................v.v......v......."}, 3);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 898961330;
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
