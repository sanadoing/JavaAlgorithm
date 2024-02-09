import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B_11650 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Node> array = new ArrayList<>();

		int N = Integer.parseInt(st.nextToken());
		int x, y;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			array.add(new Node(x, y));
		}

		Collections.sort(array, (a1, a2) -> a1.x == a2.x ? a1.y - a2.y : a1.x - a2.x);
		for (int i = 0; i < N; i++) {
			System.out.println(array.get(i));
		}

	}

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return x + " " + y;
		}

	}

}
