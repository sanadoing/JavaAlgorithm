import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1992 {

	static int[][] board;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(temp[j]);
			}
		}
		check(N, 0, 0);

		System.out.println(sb);
	}

	static void check(int length, int y, int x) {

		int first;
		boolean flag = true;

		if (length == 1) {
			sb.append(board[y][x]);

			return;
		}

		first = board[y][x];

		for (int i = y; i < y + length; i++) {
			for (int j = x; j < x + length; j++) {
				if (first != board[i][j]) {
					flag = false;
					sb.append("(");
					check(length / 2, y, x);
					check(length / 2, y, x + length / 2);
					check(length / 2, y + length / 2, x);
					check(length / 2, y + length / 2, x + length / 2);
					sb.append(")");
					return;
				}
			}
		}
		if (flag) {
			sb.append(first);

		}

	}

}
