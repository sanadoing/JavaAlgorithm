import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_17144 {

	static int R, C, T;
	static int[][] board;
	static Pos[] cleaner = new Pos[2];

	static Queue<Pos> dust = new ArrayDeque<>();
	static int[] dy = new int[] { -1, 0, 1, 0 };
	static int[] dx = new int[] { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		board = new int[R][C];
		int c = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == -1) {
					cleaner[c] = new Pos(i, j);
					c += 1;
				} else if (board[i][j] != 0) {
					dust.add(new Pos(i, j));
				}
			}
		}

		while (T-- > 0) {

			spread_dust();
//			System.out.println("====================");
//			for (int i = 0; i < R; i++) {
//				System.out.println(Arrays.toString(board[i]));
//			}
//			System.out.println();
			on_cleaner();
//			for (int i = 0; i < R; i++) {
//				System.out.println(Arrays.toString(board[i]));
//			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (board[i][j] > 0) {
						dust.add(new Pos(i, j));
					}
				}
			}

		}
		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				result += board[i][j];
			}
		}
		System.out.println(result);

	}

	static void on_cleaner() {
		// 위쪽 확산
		int cleaner1 = cleaner[0].y;
		// 1.c

		for (int y = cleaner1; y >= 0; y--) {
			board[y + 1][0] = board[y][0];
		}
		board[0][0] = board[0][1];
		// 2.

		for (int x = 1; x < C - 1; x++) {
			board[0][x] = board[0][x + 1];
		}
		board[0][C - 1] = board[1][C - 1];

		// 3.

		for (int y = 1; y < cleaner1; y++) {
			board[y][C - 1] = board[y + 1][C - 1];
		}
		board[cleaner1][C - 1] = board[cleaner1][C - 2];

		// 4.

		for (int x = C - 2; x > 0; x--) {
			board[cleaner1][x + 1] = board[cleaner1][x];
		}
		board[cleaner1][1] = 0; // 공기청정기에서 나온 깨끗한 바람

		// 아래쪽 확산
		int cleaner2 = cleaner[1].y;

		// 1.

		for (int y = cleaner2; y < R - 1; y++) {
			board[y][0] = board[y + 1][0];
		}
		board[R - 1][0] = board[R - 1][1];
		// 2.
		for (int x = 1; x < C - 1; x++) {
			board[R - 1][x] = board[R - 1][x + 1];
		}
		board[R - 1][C - 1] = board[R - 1][C - 1];

		// 3.
		for (int y = R - 2; y > cleaner2 - 1; y--) {
			board[y + 1][C - 1] = board[y][C - 1];
		}
		board[cleaner2][C - 1] = board[cleaner2][C - 2];

		// 4.
		for (int x = C - 2; x > 0; x--) {
			board[cleaner2][x + 1] = board[cleaner2][x];
		}
		board[cleaner2][1] = 0; // 공기청정기에서 나온 깨끗한 바람

		board[cleaner1][0] = 0;
		board[cleaner2][0] = 0;

	}

	static void spread_dust() {
		int[][] newBoard = new int[R][C];

		while (!dust.isEmpty()) {
			Pos current = dust.poll();

			int y = current.y;
			int x = current.x;

			int dustAmount = board[y][x];

			int spreadCnt = 0;
			for (int i = 0; i < 4; i++) {
				int yy = y + dy[i];
				int xx = x + dx[i];

				if (xx < 0 || yy < 0 || xx >= C || yy >= R || board[yy][xx] == -1)
					continue;
				if (newBoard[yy][xx] == 0) {
				}
				newBoard[yy][xx] += dustAmount / 5;
				spreadCnt += 1;
			}
			newBoard[y][x] += dustAmount - (dustAmount / 5) * spreadCnt;

		}

		for (int i = 0; i < R; i++) {
			board[i] = newBoard[i].clone();
		}

	}

	static class Pos {
		int y;
		int x;

		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Pos [y=" + y + ", x=" + x + "]";
		}

	}

}
