package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11660 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] board = new int[N + 1][N + 1];
		int y1, y2, x1, x2;

		for (int i = 1; i < N + 1; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			for (int j = 1; j < N + 1; j++) {
				board[i][j] = board[i - 1][j] + board[i][j - 1] + Integer.parseInt(st.nextToken())
						- board[i - 1][j - 1];
			}
		}

		for (int i = 0; i < M; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			y1 = Integer.parseInt(st.nextToken());
			x1 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			System.out.println(board[y2][x2] - board[y2][x1 - 1] - board[y1 - 1][x2] + board[y1 - 1][x1 - 1]);
		}
	}

}
