import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class SWEA_1225 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Deque<Integer> deque = new ArrayDeque<Integer>();

		for (int t = 1; t < 11; t++) {
			String N = br.readLine();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				deque.offer(Integer.parseInt(st.nextToken()));
			}
			int minus = 1;
			int temp;
			while (true) {
				temp = deque.poll() - minus;
				temp = (temp < 1) ? 0 : temp;
				deque.offer(temp);
				if (temp == 0) {
					break;
				}
				minus += 1;
				if (minus == 6) {
					minus = 1;
				}

			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(deque.poll() + " ");
			}
			System.out.println();

		}
	}

}
