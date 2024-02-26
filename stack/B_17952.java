import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class B_17952 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayDeque<int[]> stack = new ArrayDeque<>();
		int answer = 0;
		
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int check = Integer.parseInt(st.nextToken());
			if (check == 1) {
				int point = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());

				stack.push(new int[] { point, time - 1 });
			} else {
				if (stack.size() > 0) {
					stack.peek()[1] -= 1;
				}
			}
			if (stack.size() > 0 && stack.peek()[1] == 0) {
				answer += stack.pop()[0];
			}
		}
		System.out.println(answer);

	}

}
