import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static char[] Qube, colors;
	static int[][] change;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());

			// 큐브 초기화
			Qube = new char[] { 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g',
					'g', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'o',
					'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'y', 'y', 'y', 'y', 'y', 'y', 'y', 'y', 'y' };
			colors = new char[] { 'w', 'g', 'r', 'b', 'o', 'y' };

			int colorIdx = 0;
			int idx = 0;

			change = new int[][] { { 38, 37, 36, 29, 28, 27, 20, 19, 18, 11, 10, 9 }, // U - w (흰)
					{ 0, 3, 6, 18, 21, 24, 45, 48, 51, 44, 41, 38 }, // L - g (초록)
					{ 6, 7, 8, 27, 30, 33, 47, 46, 45, 17, 14, 11 }, // F - r (빨간)
					{ 8, 5, 2, 36, 39, 42, 53, 50, 47, 26, 23, 20 }, // R - b (파란)
					{ 2, 1, 0, 9, 12, 15, 51, 52, 53, 35, 32, 29 }, // B - o (오렌지)
					{ 24, 25, 26, 33, 34, 35, 42, 43, 44, 15, 16, 17 } // D - y (노랑)
			};

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				String command = st.nextToken();
				char c = command.charAt(0); // U, L, F, R, B, D
				char d = command.charAt(1); // -, +

				int changeIdx = 0;
				int cnt;
				if (d == '+') {
					cnt = 1;
				} else {
					cnt = 3;
				}
				if (c == 'U') {
					changeIdx = 0;
				} else if (c == 'L') {
					changeIdx = 1;
				} else if (c == 'F') {
					changeIdx = 2;
				} else if (c == 'R') {
					changeIdx = 3;
				} else if (c == 'B') {
					changeIdx = 4;
				} else if (c == 'D') {
					changeIdx = 5;
				}

				change_qube(changeIdx, cnt);

			}
			for (int f = 0; f < 9; f++) {
				System.out.print(Qube[f]);
				if (f % 3 == 2) {
					System.out.println();
				}

			}
		}
	}

	static void change_qube(int changeIdx, int cnt) {

		for (int i = 0; i < cnt; i++) {
			char temp1 = Qube[change[changeIdx][9]];
			char temp2 = Qube[change[changeIdx][10]];
			char temp3 = Qube[change[changeIdx][11]];

			for (int j = 3; j > 0; j--) {
				Qube[change[changeIdx][j * 3 + 0]] = Qube[change[changeIdx][(j - 1) * 3 + 0]];
				Qube[change[changeIdx][j * 3 + 1]] = Qube[change[changeIdx][(j - 1) * 3 + 1]];
				Qube[change[changeIdx][j * 3 + 2]] = Qube[change[changeIdx][(j - 1) * 3 + 2]];
			}
			Qube[change[changeIdx][0]] = temp1;
			Qube[change[changeIdx][1]] = temp2;
			Qube[change[changeIdx][2]] = temp3;

			temp1 = Qube[changeIdx * 9 + 2];
			temp2 = Qube[changeIdx * 9 + 1];
			temp3 = Qube[changeIdx * 9];

			Qube[changeIdx * 9 + 2] = Qube[changeIdx * 9];
			Qube[changeIdx * 9 + 1] = Qube[changeIdx * 9 + 3];
			Qube[changeIdx * 9] = Qube[changeIdx * 9 + 6];

			Qube[changeIdx * 9] = Qube[changeIdx * 9 + 6];
			Qube[changeIdx * 9 + 3] = Qube[changeIdx * 9 + 7];
			Qube[changeIdx * 9 + 6] = Qube[changeIdx * 9 + 8];

			Qube[changeIdx * 9 + 6] = Qube[changeIdx * 9 + 8];
			Qube[changeIdx * 9 + 7] = Qube[changeIdx * 9 + 5];
			Qube[changeIdx * 9 + 8] = Qube[changeIdx * 9 + 2];

			Qube[changeIdx * 9 + 8] = temp1;
			Qube[changeIdx * 9 + 5] = temp2;
			Qube[changeIdx * 9 + 2] = temp3;
		}
	}

}
