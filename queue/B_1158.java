
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B_1158 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Deque<Integer> queue = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < N + 1; i++) {
			queue.offerLast(i);
		}
		int cnt;

		sb.append("<");
		while (!queue.isEmpty()) {

			cnt = K - 1;
			while (cnt-- > 0) {
				queue.offerLast(queue.pollFirst());

			}

			sb.append(queue.pollFirst()).append(", ");
		}
		sb.append(">");
		sb.delete(sb.length()-3, sb.length()-1);
		System.out.print(sb);

	}

}
