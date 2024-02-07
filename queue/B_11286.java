import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B_11286 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int temp;
		for (int i = 0; i < N; i++) {
			temp = Integer.parseInt(br.readLine());
			if (temp == 0) {
				if (!pq.isEmpty())
					System.out.println(pq.poll().x);
				else
					System.out.println(0);
			} else {
				pq.offer(new Node(Math.abs(temp), temp));
			}

		}

	}

	static class Node implements Comparable<Node> {
		int abs_x, x;

		Node(int abs_x, int x) {
			this.abs_x = abs_x;
			this.x = x;
		}

		@Override
		public int compareTo(Node o) {

			if (o.abs_x < this.abs_x)
				return 1;
			else if (o.abs_x == this.abs_x)
				return x - o.x;
			else
				return -1;

		}

	}

}
