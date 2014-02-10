import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class GameOnABoard
{
	int X[] = {0, 0, 1, -1};
	int Y[] = {1, -1, 0, 0};
	int G[][];
	int n, m;
	
	int bfs(int si, int sj)
	{
		Deque<Integer> qu = new LinkedList<Integer>();
		qu.offerFirst(si * m + sj);
		
		int dist[][] = new int[n][m];
		boolean vis[][] = new boolean[n][m];
		int inf = 10000;
		
		for (int[] arr : dist)
			Arrays.fill(arr, inf);
		
		dist[si][sj] = G[si][sj];
		int worst = 0;
		while (!qu.isEmpty()) {
			int num = qu.pollFirst();
			si = num/m;
			sj = num%m;
			
			vis[si][sj] = true;
			worst = Math.max(worst, dist[si][sj]);
			
			for (int i = 0; i < 4; i++) {
				int di = si + X[i];
				int dj = sj + Y[i];
				
				if (di < 0 || di >= n || dj < 0 || dj >= m)
					continue;
				if (dist[di][dj] > dist[si][sj] + G[di][dj]) {
					if (G[di][dj] == 0) {
						qu.offerFirst(di*m + dj);
						
					}else {
						qu.offerLast(di*m + dj);
						
					}
					dist[di][dj] = dist[si][sj] + G[di][dj];
				}	
			}
		}
		return worst;
	}	
	public int optimalChoice(String[] cost)
	{
		n = cost.length;
		m = cost[0].length();
		
		G = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				G[i][j] = (cost[i].charAt(j) == '1') ? 1 : 0;
			}
		}
		
		int ret = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			for (int j =0; j < m; j++) {
				int ans = bfs(i, j);
				ret = Math.min(ret, ans);
			}
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
		answer = new GameOnABoard().optimalChoice(new String[]{"11", "10"});
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
		answer = new GameOnABoard().optimalChoice(new String[]{"01", "10"});
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
		answer = new GameOnABoard().optimalChoice(new String[]{"111001", "001000", "111111", "001111", "001100", "001011", "111001", "010011"});
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
		answer = new GameOnABoard().optimalChoice(new String[]{"001001101011", "110011001101", "111111000001", "111101010001", "011100101111", "110010111000", "111111110101", "111011110111", "111100100011", "000000000110", "101011011110", "011111000111", "101111001011"});
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
		answer = new GameOnABoard().optimalChoice(new String[]{"110010100101010110100010001100111011", "001000000110100011010100000001001000", "011000110111101001011101110111000100", "111001011000100101111010100110110011", "111000011101001010000100001010000010", "111001110010100101000001001100011011", "111110100111010101100000100111000111", "011111111100100111111110000001110111", "110000010101001111100011110000001000", "010010110111111100011101100000011010", "110001100001111001101000101110110001", "110010000111011110000010110111010101", "100100110101001001101000001101101101", "001011101101001100111110101111001110", "111010111111111100110100000011111100", "110101101000001001000100101011100000", "011011001011010001001000100000110101", "011111111100000011010111010011010100", "111001111110001110001110010100111010", "000001111000001100101010000001101110", "010000110000010010111110111000010101", "100010010100110011000111101001101011", "111010110001101011010001111101111100", "000111110000110000000101100101000110", "110000010111001001110001101010111100", "011111101101001011011010011111100010", "110101111101010100110010000011001101", "101101111001010100101111100001110001", "000110010100101111011011110010010010", "110101010011101000111011100000010011", "110001010001110011010100110000010001", "111010101100111100100011001101010100", "011000000000100001011010000100010001", "100000110110000001010001001111010000", "100011111110010011011011001110011111", "101100001111100101001101100000100001", "010000111011010110011001110011111000", "100010100111110111001010100101111010", "000110011110111011111000101000001000"});
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
		
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}

}	
