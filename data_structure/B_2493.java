package sw.Week02_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class B_2493 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int[][] top = new int[N][2];
		int[] result = new int[N];

		st = new StringTokenizer(br.readLine());
		Deque<Integer> stack = new ArrayDeque<Integer>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			top[i][0] = Integer.parseInt(st.nextToken());
			top[i][1] = (i + 1);
		}

		for (int i = 0; i < N; i++) {
			while (stack.size() > 0 && top[stack.peek()][0] < top[i][0]) {
				stack.pop();
			}
			if (stack.size() == 0) {

				sb.append(0).append(" ");
			} else {
				sb.append(top[stack.peek()][1]).append(" ");

			}
			stack.push(i);

		}
		System.out.println(sb);

	}

}
