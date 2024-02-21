import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_15683 {

	static int N, M, cctvCnt = 0, zeroCnt = 0;
	static int[][] board;
	static ArrayList<int[]> cctv = new ArrayList<>();
	static int[][][] direction = { {}, { { 0 }, { 1 }, { 2 }, { 3 } }, { { 0, 2 }, { 1, 3 } },
			{ { 0, 3 }, { 0, 1 }, { 1, 2 }, { 2, 3 } }, { { 0, 2, 3 }, { 0, 1, 3 }, { 0, 1, 2 }, { 1, 2, 3 } },
			{ { 0, 1, 2, 3 } } }; // 0 dummy
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };
	static int result = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];

		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] != 0 && board[i][j] != 6) {
					cctv.add(new int[] { i, j, board[i][j], 0 }); // y, x, type, direction(초기화)
					cctvCnt++;
				} else if (board[i][j] == 0) {
					zeroCnt++;
				}
			}
		}

		// cctv 상태 변화
		change_direction(0);
		System.out.println(zeroCnt - result);

	}

	static void change_direction(int cctvNumber) {

		if (cctvNumber == cctvCnt) {
			result = Math.max(result, checkArea());
			return;
		}

		int directionCnt = direction[cctv.get(cctvNumber)[2]].length; // cctv type 별로 움직일 수 있는 방향의 갯수

		for (int i = 0; i < directionCnt; i++) {
			cctv.get(cctvNumber)[3] = i;
			change_direction(cctvNumber + 1);
		}
	}

	static int checkArea() {
		int[][] visited = new int[N][M];
		int count = 0;

		for (int i = 0; i < cctvCnt; i++) {

			int[] cctv_d = direction[cctv.get(i)[2]][cctv.get(i)[3]];

			for (int j = 0; j < cctv_d.length; j++) {
				int cctv_y = cctv.get(i)[0];
				int cctv_x = cctv.get(i)[1];
				while (true) {
					cctv_y += dy[cctv_d[j]];
					cctv_x += dx[cctv_d[j]];
					if (cctv_y < 0 || cctv_y >= N || cctv_x < 0 || cctv_x >= M || board[cctv_y][cctv_x] == 6)
						break;
					if (visited[cctv_y][cctv_x] == 0 && board[cctv_y][cctv_x] != 6) {
						if (board[cctv_y][cctv_x] == 0) {
							count += 1;
						}
						visited[cctv_y][cctv_x] = 1;

					}
				}

			}

		}

		return count;
	}
}
