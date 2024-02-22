import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1238 {

	static int N, start;
	static HashMap<Integer, List<Integer>> edgeList;
	static int answer, edgeCount;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			answer = Integer.MAX_VALUE;
			edgeCount = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());

			edgeList = new HashMap<>();
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				if (!edgeList.containsKey(from)) {
					ArrayList<Integer> temp = new ArrayList<>();
					temp.add(to);
					edgeList.put(from, temp);
				} else {
					edgeList.get(from).add(to);
				}
			}
			bfs(start);
			System.out.println("#" + t + " " + answer);
		}

	}

	static void bfs(int start) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { start, 0 });
		boolean[] visited = new boolean[102];

		answer = start;

		int[] nowNode;
		while (!queue.isEmpty()) {
			nowNode = queue.poll();

			if (edgeCount < nowNode[1]) {
				answer = nowNode[0];
				edgeCount = nowNode[1];

			} else if (edgeCount >= nowNode[1]) {
				answer = Math.max(nowNode[0], answer);
			}

			if (edgeList.containsKey(nowNode[0])) {
				for (int nextNode : edgeList.get(nowNode[0])) {

					if (visited[nextNode] == false) {

						visited[nextNode] = true;
						queue.offer(new int[] { nextNode, nowNode[1] + 1 });
					}

				}
			}
		}
	}

}
