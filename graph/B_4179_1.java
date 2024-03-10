package graph;

import java.io.*;
import java.util.*;

public class B_4179_1 {

	static int R, C, answer = Integer.MAX_VALUE;
	static String[][] board;
	static boolean[][] visit;

	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static Queue<Pos> jihunQueue = new ArrayDeque<>();
	static Queue<Pos> fireQueue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new String[R][C];
		visit = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				board[i][j] = input[j];
				if (board[i][j].equals("J")) {
					jihunQueue.offer(new Pos(i, j, 0));
					visit[i][j] = true;
				} else if (board[i][j].equals("F")) {
					fireQueue.offer(new Pos(i, j, -1));
					visit[i][j] = true;
				}
			}
		}
		while (true) {
			// 불 이동
			Queue<Pos> tempQueue = new ArrayDeque<>();
			while (!fireQueue.isEmpty()) {
				Pos nowFire = fireQueue.poll();
				int y = nowFire.y;
				int x = nowFire.x;

				for (int i = 0; i < 4; i++) {
					int yy = y + dy[i];
					int xx = x + dx[i];
				
					if (yy < 0 || yy >= R || xx < 0 || xx >= C || visit[yy][xx])
						continue;
					if (board[yy][xx].equals("J") || board[yy][xx].equals(".")) {
						board[yy][xx] = "F";
						tempQueue.offer(new Pos(yy, xx, -1));
						visit[yy][xx] = true;
					}

				}
			}
			while (!tempQueue.isEmpty()) {
				fireQueue.offer(tempQueue.poll());
			}
			System.out.println(fireQueue);
			// 지훈 이동

			for (int i = 0; i < R; i++) {
				System.out.println(Arrays.toString(board[i]));
			}
			System.out.println();

			Queue<Pos> tempQueue2 = new ArrayDeque<>();
			while (!jihunQueue.isEmpty()) {
				Pos nowJihun = jihunQueue.poll();
				int y = nowJihun.y;
				int x = nowJihun.x;

				if(visit[y][x]) continue;

				for (int i = 0; i < 4; i++) {
					int yy = y + dy[i];
					int xx = x + dx[i];
					System.out.println(yy+" "+xx);
					if (yy < 0 || yy >= R || xx < 0 || xx >= C|| visit[yy][xx]) {
						answer = Math.min(answer, nowJihun.cnt + 1);
						break;
					}
					if (board[yy][xx].equals(".")) {
		
						board[yy][xx] = "J";
						tempQueue2.offer(new Pos(yy, xx, nowJihun.cnt + 1));
					}
					continue;

				}
				if(jihunQueue.isEmpty() || answer != Integer.MAX_VALUE)break;
			}

			while (!tempQueue2.isEmpty()) {
				jihunQueue.offer(tempQueue2.poll());
			}
			// System.out.println(jihunQueue);
			for (int i = 0; i < R; i++) {
				System.out.println(Arrays.toString(board[i]));
			}
			System.out.println();
			if(answer != Integer.MAX_VALUE || jihunQueue.isEmpty()){
				break;
			}
		}
		// if (answer == Integer.MAX_VALUE) {
		// System.out.println("IMPOSSIBLE");
		// } else {
		// System.out.println(answer);
		// }
	}

	static class Pos {
		int y;
		int x;
		int cnt;

		Pos(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Pos [y=" + y + ", x=" + x + ", cnt=" + cnt + "]";
		}

	}
}
