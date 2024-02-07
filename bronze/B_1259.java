import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_1259 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n;
		int length;
		String flag;

		while (true) {
			flag = "yes";
			n = br.readLine();
			if (n.equals("0")) {
				break;
			}
			length = n.length();
			for (int i = 0; i < length / 2; i++) {
				if (n.charAt(i) != n.charAt(length - i - 1)) {
					flag = "no";
				}

			}
			System.out.println(flag);
		}

	}

}
