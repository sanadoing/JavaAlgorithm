import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1389 {

	static int N, M;
	static List<List<Integer>> connection;
	static int baconCnt = Integer.MAX_VALUE, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		connection = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			connection.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			connection.get(s).add(e);
			connection.get(e).add(s);

		}

		for (int i = 1; i < N + 1; i++) {
			int s = check(i);
			if (baconCnt > s) {
				baconCnt = s;
				answer = i;
			}
		}
		System.out.println(answer);
	}

	static int check(int start) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { start, 0 });
		boolean[] visited = new boolean[N + 1];
		int sum = 0;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int nowNode = now[0];
			int nowCnt = now[1];

			if (visited[nowNode])
				continue;

			visited[nowNode] = true;
			sum += nowCnt;

			for (int next : connection.get(nowNode)) {
				if (visited[next])
					continue;
				queue.offer(new int[] { next, nowCnt + 1 });

			}

		}
		return sum;
	}

}
