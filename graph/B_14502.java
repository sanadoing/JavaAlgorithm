import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_14502 {

	static int N, M, zeroCnt = 0, wallCnt = 0, virusCnt = 0, answer = 0;
	static int[] tgt = new int[3];
	static int[][] map, visited;
	static List<int[]> zeroPosition = new ArrayList<>();
	static List<int[]> wallPosition = new ArrayList<>();
	static List<int[]> virusPosition = new ArrayList<>();
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					zeroPosition.add(new int[] { i, j });
					zeroCnt += 1;
				} else if (map[i][j] == 2) {
					virusPosition.add(new int[] { i, j });
					virusCnt += 1;
				} else {
					wallPosition.add(new int[] { i, j });
					wallCnt += 1;
				}
			}
		}

		comb(0, 0);
		System.out.println(answer);

	}

	static void comb(int tgtIdx, int srcIdx) {
		if (tgtIdx == 3) {

			bfs();
			return;
		}
		if (srcIdx == zeroCnt) {
			return;
		}
		tgt[tgtIdx] = srcIdx;
		comb(tgtIdx + 1, srcIdx + 1);
		comb(tgtIdx, srcIdx + 1);
	}

	static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		visited = new int[N][M];
		int safeToVirus = 0;

		for (int i = 0; i < N; i++) {
			visited[i] = map[i].clone();
		}
		for (int i = 0; i < virusCnt; i++) {
			int[] nowVirus = virusPosition.get(i);
			queue.offer(new int[] { nowVirus[0], nowVirus[1] });

		}
		for (int i = 0; i < 3; i++) {
			int[] selectedWall = zeroPosition.get(tgt[i]);
			visited[selectedWall[0]][selectedWall[1]] = 1;
		}

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int ny = now[0];
			int nx = now[1];

			for (int i = 0; i < 4; i++) {
				int yy = ny + dy[i];
				int xx = nx + dx[i];

				if (yy < 0 || yy >= N || xx < 0 || xx >= M || visited[yy][xx] != 0)
					continue;
				visited[yy][xx] = 3;
				queue.offer(new int[] { yy, xx });
				safeToVirus += 1;
			}
		}

		answer = Math.max(answer, zeroCnt - safeToVirus - 3);

	}
}
