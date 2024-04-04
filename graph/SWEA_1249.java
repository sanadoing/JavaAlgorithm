import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class SWEA_1249 {

	static int N;
	static int[][] map, time;
	static int[] dy = new int[] { -1, 0, 1, 0 };
	static int[] dx = new int[] { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			time = new int[N][N];

			for (int i = 0; i < N; i++) {
				Arrays.fill(time[i], Integer.MAX_VALUE);
			}

			for (int i = 0; i < N; i++) {
				String[] input = br.readLine().split("");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(input[j]);
				}
			}
			bfs();
			System.out.println("#" + t + " " + time[N - 1][N - 1]);
		}

	}

	static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { 0, 0 });
		boolean[][] visit = new boolean[N][N];
		visit[0][0] = true;
		time[0][0] = 0;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int ny = now[0];
			int nx = now[1];

			for (int i = 0; i < 4; i++) {
				int yy = ny + dy[i];
				int xx = nx + dx[i];
				if (yy < 0 || xx < 0 || yy > N - 1 || xx > N - 1)
					continue;
				if (visit[yy][xx]) {
					if (time[yy][xx] > time[ny][nx] + map[ny][nx]) {
						time[yy][xx] = time[ny][nx] + map[ny][nx];
						queue.offer(new int[] { yy, xx });
						continue;
					}

				} else {
					visit[yy][xx] = true;
					time[yy][xx] = time[ny][nx] + map[ny][nx];
					queue.offer(new int[] { yy, xx });

				}

			}

		}

	}

}
