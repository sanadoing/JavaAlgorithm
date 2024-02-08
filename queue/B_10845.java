import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B_10845 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> queue = new ArrayDeque<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		String[] temp = new String[2];
		int N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			temp = br.readLine().split(" ");
			if (temp[0].equals("push")) {
				queue.offer(Integer.parseInt(temp[1]));
			} else if (temp[0].equals("pop")) {
				if (queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.poll());
				}
			} else if (temp[0].equals("size")) {
				System.out.println(queue.size());
			} else if (temp[0].equals("empty")) {
				if (queue.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}

			} else if (temp[0].equals("front")) {
				if (queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.peek());
				}
			} else {
				if (queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.peekLast());
				}
			}

		}

	}
}
