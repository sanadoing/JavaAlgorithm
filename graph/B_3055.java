import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_3055 {

	static int R, C;
	static String[][] board;
	static Queue<int[]> dochi = new ArrayDeque<>();
	static Queue<int[]> water = new ArrayDeque<>();
	static int[] dy = new int[] { -1, 0, 1, 0 };
	static int[] dx = new int[] { 0, 1, 0, -1 };
	static int T = 1;
	static int result = -1;

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
				if (board[i][j].equals("S")) {
					dochi.offer(new int[] { T, i, j });

				} else if (board[i][j].equals("*")) {
					water.offer(new int[] { T, i, j });
				}
			}
		}
		while (true) {

			move_dochi();
			if (result != -1) {
				System.out.println(result);
				break;
			}
			if (dochi.size() == 0) {
				System.out.println("KAKTUS");
				break;
			}
			move_water();
			T += 1;

		}

	}

	static void move_water() {
		while (!water.isEmpty()) {
			int[] nowWater = water.poll();
			int t = nowWater[0];
			int y = nowWater[1];
			int x = nowWater[2];

			if (t > T) {
				water.offer(new int[] { t, y, x });
				break;
			}

			for (int i = 0; i < 4; i++) {
				int yy = y + dy[i];
				int xx = x + dx[i];
				if (yy < 0 || yy >= R || xx < 0 || xx >= C)
					continue;
				// 돌이거나, 비버굴이거나, 이미 물이면
				if (board[yy][xx].equals("X") || board[yy][xx].equals("D") || board[yy][xx].equals("*"))
					continue;
				// 고슴도치이거나, 비어있는 곳이면
				board[yy][xx] = "*";
				water.offer(new int[] { t + 1, yy, xx });

			}
		}
	}

	static void move_dochi() {
		while (!dochi.isEmpty()) {
			int[] nowDochi = dochi.poll();
			int t = nowDochi[0];
			int y = nowDochi[1];
			int x = nowDochi[2];
			if (t > T) {
				dochi.offer(new int[] { t, y, x });
				break;
			}

			// 이전의 도치의 위치가 물로 뒤덮여 4방향을 볼 수 없는 경우
			if (board[y][x].equals("*"))
				continue;

			for (int i = 0; i < 4; i++) {
				int yy = y + dy[i];
				int xx = x + dx[i];
				if (yy < 0 || yy >= R || xx < 0 || xx >= C)
					continue;
				// 돌이거나, 이미 물이면, 이미 고슴도치이면
				if (board[yy][xx].equals("X") || board[yy][xx].equals("*") || board[yy][xx].equals("S"))
					continue;

				// 목적지 비버굴에 도착!
				if (board[yy][xx].equals("D")) {
					result = t;
					return;
				}
				// 비어있는 곳이면
				board[yy][xx] = "S";
				dochi.offer(new int[] { t + 1, yy, xx });
			}
		}
	}
}
