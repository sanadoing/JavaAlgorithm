import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.StringTokenizer;

public class B_17135 {

	static int N, M, D;
	static int answer = -1;
	static int[][] board;
	static ArrayList<int[]> enemy, target;
	static int[] tgt = new int[3];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		enemy = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {

				if (Integer.parseInt(st.nextToken()) == 1) {
					enemy.add(new int[] { i, j });
				}
			}
		}
		comb(0, 0);
		System.out.println(answer);

	}

	static void comb(int tgtIdx, int srcIdx) {

		if (tgtIdx == 3) {

			answer = Math.max(answer, attack());

			return;
		}
		if (srcIdx == M)
			return;

		tgt[tgtIdx] = srcIdx;
		comb(tgtIdx + 1, srcIdx + 1);
		comb(tgtIdx, srcIdx + 1);
	}

	static int attack() {

		int[] select = new int[] { -1, -1, -1 };

		int hy;
		int hx;
		int result = 0;
		ArrayList<int[]> enemy_temp = new ArrayList<int[]>();
		for (int i = 0; i < enemy.size(); i++) {
			enemy_temp.add(new int[] { enemy.get(i)[0], enemy.get(i)[1] });

		}

		int cnt = 1;
		while (!enemy_temp.isEmpty()) {

			// 공격 대상 탐색
			for (int i = 0; i < 3; i++) {
				
				hx = tgt[i];
				hy = N;
				int min_idx = -1;
				int min_x_idx = 0;
				int min_value = Integer.MAX_VALUE;
				
				for (int j = 0; j < enemy_temp.size(); j++) {
					int distance = Math.abs(hy - enemy_temp.get(j)[0]) + Math.abs(hx - enemy_temp.get(j)[1]);

					if (distance < min_value && distance <= D) {
						min_value = distance;
						min_idx = j;
						min_x_idx = enemy_temp.get(j)[1];
					} else if (distance == min_value && enemy_temp.get(j)[1] < min_x_idx) {
						min_idx = j;
						min_x_idx = enemy_temp.get(j)[1];
					}
				}
				select[i] = min_idx;
			}

			// 공격
			for (int i = 0; i < 3; i++) {
				if (select[i] == -1)
					continue; // 공격 대상이 없을 때
				enemy_temp.get(select[i])[0] = -1; // 공격 대상 표시 (중복을 위한)
			}

			int y, x;
			ArrayList<int[]> enemy_temp_temp = new ArrayList<int[]>();
			
			for (int j = 0; j < enemy_temp.size(); j++) {
				y = enemy_temp.get(j)[0];
				x = enemy_temp.get(j)[1];
				if (y == -1) {// 공격받은 적 제외
					result += 1;
					continue;
				}

				if (y + 1 == N)
					continue; // 이동하여 격자판 나간 적 제외
				enemy_temp_temp.add(new int[] { y + 1, x });
			}

			enemy_temp = enemy_temp_temp;
		}

		return result;
	}
}
