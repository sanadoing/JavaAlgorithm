import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_15829 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int result = 0;
		int hash = 1;
		for (int i = 0; i < input.length(); i++) {
			result += (input.charAt(i) - '0'-48) * hash;
			hash *= 31;
		}
		System.out.println(result);
	}

}

