import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String input = st.nextToken();
		long K = Integer.parseInt(st.nextToken());

		int[] pi = new int[input.length()];

		int j = 0;
		for (int i = 1; i < pi.length; i++) {
			while (j > 0 && input.charAt(j) != input.charAt(i))
				j = pi[j - 1];
			if (input.charAt(j) == input.charAt(i))
				pi[i] = ++j;
		}

		System.out.println(input.length() * K - pi[pi.length - 1] * (K - 1));

	}

}
