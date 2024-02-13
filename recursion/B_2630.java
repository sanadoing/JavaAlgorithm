import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2630 {

	static int N;
	static int[][] whole;
	static int white = 0;
	static int blue = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		whole = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				whole[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cut(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}

	static void cut(int sy, int sx, int length) {
		int color = whole[sy][sx];

		for (int y = sy; y < sy + length; y++) {
			for (int x = sx; x < sx + length; x++) {
				if (color != whole[y][x]) {
					cut(sy, sx, length / 2);
					cut(sy, sx + length / 2, length / 2);
					cut(sy + length / 2, sx, length / 2);
					cut(sy + length / 2, sx + length / 2, length / 2);
					return;

				}

			}
		}
		if (color == 1) {
			blue += 1;
		} else {
			white += 1;
		}
		return;
	}

}
