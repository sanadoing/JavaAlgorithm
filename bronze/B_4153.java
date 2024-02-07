import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B_4153 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<Integer> array;
		int t1, t2, t3;

		while (true) {
			array = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			array.add(Integer.parseInt(st.nextToken()));
			array.add(Integer.parseInt(st.nextToken()));
			array.add(Integer.parseInt(st.nextToken()));
			if (array.get(0).equals(0)) {
				break;
			}
			Collections.sort(array);

			t1 = array.get(0);
			t2 = array.get(1);
			t3 = array.get(2);
			if (t3 * t3 == t2 * t2 + t1 * t1) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}
	}

}
