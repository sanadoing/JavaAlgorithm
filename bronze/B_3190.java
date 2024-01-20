package bronze;
import java.util.*;
import java.io.*;

class Pos {
	int y, x;

	Pos(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class B_3190 {

// class Main{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
		int N = scan.nextInt(); // 보드의 크기
		int K = scan.nextInt(); // 사과의 개수

		// 우, 아래, 좌, 위
		int[] dy = { 0, 1, 0, -1 };
		int[] dx = { 1, 0, -1, 0 };

    // 사과(2), 뱀(1) 의 정보를 담을 2차원 배열 
		int[][] board = new int[N][N];

    // 사과의 위치를 담기 위한 변수와 반복문
		int y, x;
		for (int i = 0; i < K; i++) {
			y = scan.nextInt();
			x = scan.nextInt();
			board[y - 1][x - 1] = 2;
		}

		int L = scan.nextInt(); // 뱀의 방향 변환 횟수
    
    // 뱀의 방향 변환 정보(시간, 방향)를 담을 배열 
		int[] sec = new int[L+1];
		String[] dir = new String[L+1];

		for (int i = 0; i < L; i++) {
			sec[i] = scan.nextInt();
			dir[i] = scan.next();
		}

		int d = 0;
		int result_time = 1;
		int dir_index = 0;

		Deque<Pos> deq = new ArrayDeque<>();  // 뱀의 위치정보를 담을 deque (머리 ~ 꼬리)
		deq.addLast(new Pos(0, 0)); // 초기 뱀의 머리 위치 
		board[0][0] = 1; 
    int snake_length = 1;
		while (true) {
      System.out.println(result_time);
      System.err.println();
      System.out.print(deq.peek().y);
      System.out.print(deq.peek().x);
      System.err.println();
  
			// 방향 변경
			if (dir_index < L && (sec[dir_index] == result_time)) {
				if (dir[dir_index].equals("D")) {
					d = (d + 1) % 4; 
				} else {
					d = (d + 3) % 4; 
				}
        dir_index++;
			}

			// 뱀 이동
			Pos snake_head = deq.getFirst();
     
			snake_head.y += dy[d];
			snake_head.x += dx[d];
			

			// 벽이나 자기자신의 몸과 부딪히는지
			if ((snake_head.y < 0) || (N - 1 < snake_head.y) || (snake_head.x < 0) || (N - 1 < snake_head.x)
					|| (board[snake_head.y][snake_head.x] == 1)) {
				System.out.println(result_time+1);
				break;
			} else { // 부딪히지 않는다면,
				board[snake_head.y][snake_head.x] = 1;
				deq.addFirst(snake_head);

      
  
				if (board[snake_head.y][snake_head.x] != 2) {
					Pos snake_tail = deq.removeLast();
					board[snake_tail.y][snake_tail.x] = 0;
				}

			}
			result_time += 1;

		}
  }
}