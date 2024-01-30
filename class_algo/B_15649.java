import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_15649 {

	static boolean[] check;
	static int[] select;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);

		check = new boolean[N];
		select = new int[M];
		perm(0);
	}

	static void perm(int idx) {
		if (idx == M) {

			for (int i = 0; i < M; i++) {
				System.out.print(select[i] + " ");
			}
			System.out.println();

			return;
		}

		for (int i = 0; i < N; i++) {
			if (check[i])
				continue;
			select[idx] = (i + 1);
			check[i] = true;
			perm(idx + 1);
			check[i] = false;

		}

	}

}
