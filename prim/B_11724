package Month03.Week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_11724 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<List<Integer>> nodeList = new ArrayList<>();
		boolean[] check = new boolean[N + 1];

		for (int i = 0; i < N + 1; i++) {
			nodeList.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			nodeList.get(s).add(e);
			nodeList.get(e).add(s);

		}

		int answer = 0;
		for (int i = 1; i < N + 1; i++) {
			if (check[i])
				continue;

			Queue<Integer> queue = new ArrayDeque<>();
			queue.offer(i);

			while (!queue.isEmpty()) {
				int nowNode = queue.poll();
				if (check[nowNode])
					continue;
				check[nowNode] = true;
				for (Integer next : nodeList.get(nowNode)) {
					if (check[next])
						continue;
					queue.offer(next);
				}

			}

			answer += 1;

		}
		System.out.println(answer);
	}

}
