import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class B_15961 {

	static int N, d, k, c;
	static boolean coupon;
	static int[] sushiInfoList;
	static HashMap<Integer, Integer> window = new HashMap<>();
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		sushiInfoList = new int[N];

		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			sushiInfoList[i] = input;
		}

		int idx = 0;
		for (int i = 0; i < N + k; i++) {

			if (i == N) {
				idx = 0;
			}
			if (i >= k) {
				// 초밥 하나 빼기
				int remove = sushiInfoList[i - k];
				window.put(remove, window.get(remove) - 1);
				if (window.get(remove) == 0) {
					if (remove == c)
						coupon = false;
					window.remove(remove);
				}
			}

			// 초밥 하나 추가
			int now = sushiInfoList[idx];

			if (!window.containsKey(now))
				window.put(now, 1);
			else {
				window.put(now, window.get(now) + 1);
			}

			if (now == c) {
				coupon = true;
			}

			int size = window.size();

			if (answer < window.size() + 1) {
				if (coupon)
					answer = window.size();
				else
					answer = window.size() + 1;
			}
			idx += 1;
		}

		System.out.println(answer);

	}

}
