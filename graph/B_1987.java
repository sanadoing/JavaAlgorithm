import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B_1987 {

	static int R, C, result;
	static String[][] board;
	static boolean[][] visited;
	static HashMap<String, Integer> map;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		board = new String[R][C];
		visited = new boolean[R][C];
		map = new HashMap<>();

		for (int i = 0; i < R; i++) {
			input = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				board[i][j] = input[j];
			}
		}
		result = 0;
		map.put(board[0][0], 1);
		DFS(0, 0, 1);
		System.out.println(result);
	}

	static void DFS(int y, int x, int cnt) {
		result = Math.max(result, cnt);
		if (y == R - 1 && x == C - 1) {
			return;
		}

		int yy, xx;
		for (int i = 0; i < 4; i++) {
			yy = y + dy[i];
			xx = x + dx[i];
			if (yy < 0 || yy >= R || xx < 0 || xx >= C || visited[yy][xx])
				continue;
			if (map.containsKey(board[yy][xx])) {
				if (map.get(board[yy][xx]) == 1) {
					continue;
				}
				map.replace(board[yy][xx], 1);
			} else {
				map.put(board[yy][xx], 1);
			}

			visited[yy][xx] = true;
			DFS(yy, xx, cnt + 1);
			visited[yy][xx] = false;
			map.replace(board[yy][xx], 0);

		}
		return;
	}

}
