import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class B_3109 {
	static String[][] board;
	static int R, C;
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new String[R][C];

		for (int i = 0; i < R; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				board[i][j] = input[j];
			}
		}
		for (int i = 0; i < R; i++) {
			if (board[i][0].equals(".")) {
				board[i][0] = "x";
				if (dfs(i, 0)) {
					ans++;
				}

			}

		}
		System.out.println(ans);

	}

	static boolean dfs(int y, int x) {

		if (x == C - 1) {

			return true;

		}
		if (y - 1 >= 0 && board[y - 1][x + 1].equals(".")) {
			board[y - 1][x + 1] = "x";
			if (dfs(y - 1, x + 1)) {
				return true;
			}

		}

		if (board[y][x + 1].equals(".")) {
			board[y][x + 1] = "x";
			if (dfs(y, x + 1)) {
				return true;
			}

		}

		if (y + 1 < R && board[y + 1][x + 1].equals(".")) {
			board[y + 1][x + 1] = "x";
			if (dfs(y + 1, x + 1)) {
				return true;
			}

		}
		return false;

	}

}
