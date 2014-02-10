// By Himalay Joriwal
// END CUT HERE
import java.util.*;
public class FactoVisors {
	int[] dx={+0,+0,+1,-1,+1,+1,-1,-1};
    int[] dy={+1,-1,+0,+0,+1,-1,+1,-1};
public int[] getHappy(String[] grid) {
    int n = grid.length, m = grid[0].length();
    int[] ret = {0,0,0};
    for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) if (grid[i].charAt(j) == '.') {
        boolean a = true, b = true;
        for (int k = 0; k < 8; k++) {
            int ni = i + dy[k], nj = j + dx[k];
            if (ni < 0 || nj < 0 || ni == n || nj == m || grid[ni].charAt(nj) == 'X') continue;
            if (k < 4) a = false;
            else b = false;
        }
        if (a && b) ret[0]++;
        else if (a) ret[1]++;
        else if (b) ret[2]++;
    }
    return ret;
}
	public static void main(String[] args) {
		FactoVisors temp = new FactoVisors();
		System.out.println(temp.getNum(int[] divisors, int[] multiples));
	}
}
