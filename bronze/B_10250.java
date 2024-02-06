import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_10250 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int H, W, N, temp;
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int floor = 0, room = 1;
			while (N-- > 0) {
				if (floor >= H) {
					room += 1;
					floor = 1;
				} else {
					floor += 1;
				}
			}
			System.out.printf("%d%02d", floor, room);
			System.out.println();
		}

	}
}
