import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class SWEA_1218 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean flag;
		for (int t = 1; t < 11; t++) {
			String n = br.readLine();
			Deque<Character> stack = new ArrayDeque();
			String input = br.readLine();
			flag = true;
			for (int i = 0; i < input.length(); i++) {
				char now = input.charAt(i);
				if (now == '(' || now == '[' || now == '{' || now == '<') {
					stack.push(now);
				} else {
					if (now == ')' && stack.peek() == '(') {
						stack.pop();
					} else if (now == ']' && stack.peek() == '[') {
						stack.pop();
					} else if (now == '}' && stack.peek() == '{') {
						stack.pop();
					} else if (now == '>' && stack.peek() == '<') {
						stack.pop();
					} else {
						flag = false;
						break;
					}
				}

			}
			if (flag && stack.size() == 0) {
				System.out.println("#" + t + " " + 1);
			} else {
				System.out.println("#" + t + " " + 0);
			}
		}

	}

}
