import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B_15686 {

	static int N, M, result;
	static int houseCnt = 0;
	static int chickenCnt = 0;
	static int[][] board;
	static int[][] distance;
	static HashMap<Integer, Integer> sum = new HashMap<>();
	static ArrayList<int[]> house = new ArrayList<>();
	static ArrayList<int[]> chicken = new ArrayList<>();
	static int[] tgt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		result = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) {
					house.add(new int[] { i, j });
					houseCnt += 1;
				} else if (board[i][j] == 2) {
					chicken.add(new int[] { i, j });
					chickenCnt += 1;
				}
			}
		}

		distance = new int[houseCnt][chickenCnt];

		for (int i = 0; i < houseCnt; i++) {

			for (int j = 0; j < chickenCnt; j++) {
				distance[i][j] = Math.abs(house.get(i)[0] - chicken.get(j)[0])
						+ Math.abs(house.get(i)[1] - chicken.get(j)[1]);

			}

		}

		tgt = new int[M];
		comb(0, 0);

		System.out.println(result);

	}

	static void comb(int tgtIdx, int srcIdx) {

		if (tgtIdx == M) {
			result = Math.min(result, cal());
			return;
		}
		if (srcIdx == chickenCnt)
			return;
		tgt[tgtIdx] = srcIdx;
		comb(tgtIdx + 1, srcIdx + 1);
		comb(tgtIdx, srcIdx + 1);
	}

	static int cal() {
		int total = 0;

		for (int i = 0; i < houseCnt; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) {

				min = Math.min(min, distance[i][tgt[j]]);
			}
			total += min;
		}
		return total;
	}
}