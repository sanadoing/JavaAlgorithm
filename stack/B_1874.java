package Week02_01.temp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class B_1874 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		Deque<Integer> stack = new ArrayDeque<>();
		int idx = 0;
		int input = 2;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		stack.push(1);
		sb.append("+").append("\n");

		for (int i = 0; i < N; i++) {
			while (true) {
				if (input > N + 1) {
					sb.setLength(0);

					sb.append("NO");
					System.out.println(sb);
					return;

				}
				if (!stack.isEmpty() && stack.peekFirst() == numbers[i]) {
					stack.pop();
					sb.append("-").append("\n");
					break;
				}
				stack.push(input);
				sb.append("+").append("\n");
				input += 1;

			}
		}
		System.out.println(sb);

	}

}
