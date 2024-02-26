import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_20361 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// int T = Integer.parseInt(br.readLine()); // Test Case 수
		StringBuilder sb = new StringBuilder();

		// for (int t = 1; t <= T; t++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 종이컵의 수
		int X = Integer.parseInt(st.nextToken()); // 간식이 들어있는 종이컵 (왼쪽에서 부터)
		int K = Integer.parseInt(st.nextToken()); // 컵의 위치를 맞바꾸는 횟수

		boolean[] info = new boolean[N + 1]; // 0 dummy
		info[X] = true; // 간식이 들어 있는 컵의 위치

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			// 맞바꿀 위치 A, B
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			// 두 개의 위치 중에 공이 있다면
			if (info[A] || info[B]) {
				// swap - 컵 위치 바꿈.
				boolean temp = info[A];
				info[A] = info[B];
				info[B] = temp;

				if (info[A])
					X = A;
				else
					X = B;
			}

		}
		System.out.println(X);
		// sb.append("#").append(t).append(" ").append(X).append("\n");

	}
	// sb.replace(sb.length()-1, sb.length(),"");
	// System.out.println(sb);

	// }

}
