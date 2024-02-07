import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B_2798 {

	static int N, M, result;
	static List<Integer> array;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array.add(Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < N - 2; i++) {

			dfs(i, 1, array.get(i));
		}
		System.out.println(result);

	}

	static void dfs(int idx, int cnt, int sum) {
		if (cnt == 3) {
			result = Math.max(result, sum);
			return;
		}
		for (int i = idx + 1; i < N; i++) {
			if (sum + array.get(i) <= M) {
				dfs(i, cnt + 1, sum + array.get(i));
			}
		}
		return;
	}

}
