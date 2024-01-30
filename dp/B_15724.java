import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_15724 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);

		int[][] board = new int[N][M];
		int[][] sum = new int[N + 1][M + 1];
		int result = 0;

		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(str[j]);
				sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + board[i][j];
			}
		}

		int K = Integer.parseInt(br.readLine());
		int y1, y2, x1, x2;

		for (int i = 0; i < K; i++) {
			str = br.readLine().split(" ");
			y1 = Integer.parseInt(str[0]);
			y2 = Integer.parseInt(str[2]);
			x1 = Integer.parseInt(str[1]);
			x2 = Integer.parseInt(str[3]);
			result = sum[y2][x2] - sum[y2][x1 - 1] - sum[y1 - 1][x2] + sum[y1 - 1][x1 - 1];
			System.out.println(result);

		}

	}

}
