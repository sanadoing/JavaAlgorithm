import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_15591 {

	static int N, Q;
	static List<List<Node>> nodeList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		nodeList = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			nodeList.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			nodeList.get(s).add(new Node(e, c));
			nodeList.get(e).add(new Node(s, c));
		}

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			System.out.println(bfs(K, V));
		}

	}

	static int bfs(int K, int V) {
		Queue<Node> queue = new ArrayDeque<>();
		boolean[] visit = new boolean[N + 1];
		queue.offer(new Node(V, K));
		visit[V] = true;

		int cnt = 0;
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			cnt += 1;
			for (Node next : nodeList.get(now.end)) {
				if (visit[next.end])
					continue;

				if (Math.min(next.cost, now.cost) >= K) {

					visit[next.end] = true;
					queue.offer(next);
				}
			}
		}
		return cnt - 1;
	}

	static class Node {
		int end;
		int cost;

		public Node(int end, int cost) {
			super();
			this.end = end;
			this.cost = cost;
		}

	}
}
