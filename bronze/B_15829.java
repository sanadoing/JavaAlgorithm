import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_15829 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		long result = 0;
		long hash = 1;
		long M = 1234567891;
		for (int i = 0; i < input.length(); i++) {
			result += ((input.charAt(i) - 96) * hash);
			hash = (hash * 31) % M;
		}
		System.out.println(result % M);
	}

}
