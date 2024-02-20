package graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class B_10026 {

	static int N;
	static String[][] board, board1;
	static boolean[][] visited, visited1;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new String[N][N];
		board1 = new String[N][N];
		visited = new boolean[N][N];
		visited1 = new boolean[N][N];
		int result = 0;
		int result1 = 0;

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				board[i][j] = input[j];
				if (input[j].equals("R") || input[j].equals("G")) {
					board1[i][j] = "R";
				} else {
					board1[i][j] = input[j];
				}

			}
		}

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {
				if (visited[i][j] == false) {
					visited[i][j] = true;
					BFS(i, j, board[i][j], 0);
					result++;
				}
				if (visited1[i][j] == false) {
					visited1[i][j] = true;
					BFS(i, j, board1[i][j], 1);
					result1++;
				}
			}
		}

		System.out.println(result + " " + result1);

	}

	static void BFS(int y, int x, String color, int type) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { y, x });
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			if (type == 0) {
				for (int i = 0; i < 4; i++) {
					int yy = now[0] + dy[i];
					int xx = now[1] + dx[i];

					if (yy >= 0 && yy < N && xx >= 0 && xx < N && visited[yy][xx] == false
							&& board[yy][xx].equals(color)) {
						queue.offer(new int[] { yy, xx });

						visited[yy][xx] = true;

					}

				}
			} else {
				for (int i = 0; i < 4; i++) {
					int yy = now[0] + dy[i];
					int xx = now[1] + dx[i];

					if (yy >= 0 && yy < N && xx >= 0 && xx < N && visited1[yy][xx] == false
							&& board1[yy][xx].equals(color)) {
						queue.offer(new int[] { yy, xx });

						visited1[yy][xx] = true;

					}

				}
			}

		}
	}

}
