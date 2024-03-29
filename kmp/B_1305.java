import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split("");
		int[] pi = new int[N];

		int j = 0;
		for (int i = 1; i < input.length; i++) {
			while (j > 0 && !input[i].equals(input[j]))
				j = pi[j - 1];
			if (input[i].equals(input[j]))
				pi[i] = ++j;

		}
		System.out.println(N - 1 - pi[N - 1] + 1);
	}
}
