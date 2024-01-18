// package workshop.ws01;

import java.util.*;

class Pos {
	int y, x;

	Pos(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class B_3190 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt(); // 보드의 크기
		int K = scan.nextInt(); // 사과의 개수

		// 우, 아래, 좌, 위
		int[] dy = { 0, 1, 0, -1 };
		int[] dx = { 1, 0, -1, 0 };

		int[][] board = new int[N][N];
		int y, x;
		for (int i = 0; i < K; i++) {
			y = scan.nextInt();
			x = scan.nextInt();
			board[y - 1][x - 1] = 2;
		}

		int L = scan.nextInt(); // 뱀의 방향 변환 횟수
		int[] sec = new int[L + 1];
		String[] dir = new String[L + 1];

		for (int i = 0; i < L; i++) {
			sec[i] = scan.nextInt();
			dir[i] = scan.next();
		}

		int d = 0;
		int result_time = 0;
		int dir_index = 0;

		Deque<Pos> deq = new ArrayDeque<>();
		deq.addLast(new Pos(0, 0));
		board[0][0] = 1;

		while (true) {

			// 방향 변경
			if (dir_index < L && (sec[dir_index] == result_time)) {
				if (dir[dir_index].equals("D")) {
					d = (d + 1) % 4;
					dir_index++;
				} else {
					d = (d + 3) % 4;
					dir_index++;
				}

			}

			// 뱀 이동

			Pos snake_head = deq.getFirst();
			int yy = snake_head.y + dy[d];
			int xx = snake_head.x + dx[d];
			// 벽이나 자기자신의 몸과 부딪히는지
			if (yy < 0 || N - 1 < yy || xx < 0 || N - 1 < xx || board[yy][xx] == 1) {
				
				System.out.println(result_time + 1);
				break;
			} else {
				if (board[yy][xx] != 2) { // 사과가 없다면, 꼬리 땡기기
					Pos snake_tail = deq.removeLast();
					board[snake_tail.y][snake_tail.x] = 0;
				}
				board[yy][xx] = 1;
				deq.addFirst(new Pos(yy, xx));
			}
			result_time += 1;
		}
	}
}
