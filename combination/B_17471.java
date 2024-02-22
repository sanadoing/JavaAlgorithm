import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
[부족했던 점 CHECK !]

	조합 + bfs 문제라는 것은 알았으나
	1. bfs를 사용하여 탐색한 횟수가 2인 경우 min값을 저장하면 된다는 것을 생각하지 못함.
	
*/

public class B_17471 {

	static int N, peopleTotal = 0, answer = Integer.MAX_VALUE;
	static int[] people, tgt; // 0 dummy
	static boolean[] check;
	static List<List<Integer>> edgeList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		people = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			peopleTotal += people[i];
		}

		edgeList = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			edgeList.add(new ArrayList<>());
		}

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				edgeList.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}

		// 조합 구성
		tgt = new int[N + 1];
		for (int i = 1; i < N; i++) {
			comb(1, 0, i, 0);
		}
		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		System.out.println(answer);

	}

	static void comb(int tgtIdx, int count, int c, int sum) {
		if (count == c) {

			check = new boolean[N + 1];

			int cnt = 0;
			for (int i = 1; i < N + 1; i++) {
				if (check[i])
					continue;
				bfs(i, tgt[i]);
				cnt += 1;
			}

			if (cnt == 2) {
				answer = Math.min(answer, Math.abs(sum - (peopleTotal - sum)));
			}

			return;
		}
		if (tgtIdx == N + 1)
			return;

		tgt[tgtIdx] = 1;
		comb(tgtIdx + 1, count + 1, c, sum + people[tgtIdx]);
		tgt[tgtIdx] = 0;
		comb(tgtIdx + 1, count, c, sum);

	}

	static void bfs(int num, int zoneNumber) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(num);

		while (!queue.isEmpty()) {
			int now_num = queue.poll();

			for (int next : edgeList.get(now_num)) {
				if (tgt[next] == zoneNumber && !check[next]) {
					check[next] = true;
					queue.offer(next);

				}
			}

		}

	}
}
