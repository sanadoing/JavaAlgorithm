package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2636 {
  static int N, M;
  static int[][] board;
  static int cheeseCount = 0;
  static int[] dy = {-1, 0, 1, 0};
  static int[] dx = {0, 1, 0, -1};
  static int resultTime = 0;
  static int resultCount = 0;

  public static void main(String[] args) throws Exception {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      board = new int[N][M];

      for (int i = 0; i < N; i++) {
          st = new StringTokenizer(br.readLine());
          for (int j = 0; j < M; j++) {
              board[i][j] = Integer.parseInt(st.nextToken());
              if (board[i][j] == 1) {
                  cheeseCount++;
              }
          }
      }

      while (cheeseCount > 0) {
          resultCount = cheeseCount;

          // 치즈 녹이기
          meltCheese();
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(board[i]));
		}

		System.out.println("++++++++++++++++++++++++++++++++++");

          // 공기 확장하기
          changeAir();
          		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(board[i]));
		}

		System.out.println("++++++++++++++++++++++++++++++++++");


          resultTime++;
      }

      System.out.println(resultTime);
      System.out.println(resultCount);
  }

  static void meltCheese() {
      boolean[][] visited = new boolean[N][M];
      Queue<int[]> queue = new ArrayDeque<>();
      queue.offer(new int[]{0, 0});
      visited[0][0] = true;

      while (!queue.isEmpty()) {
          int[] current = queue.poll();
          int y = current[0];
          int x = current[1];

          for (int d = 0; d < 4; d++) {
              int ny = y + dy[d];
              int nx = x + dx[d];

              if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx]) continue;

              if (board[ny][nx] == 0) {
                  queue.offer(new int[]{ny, nx});
              } else if (board[ny][nx] == 1) {
                  board[ny][nx] = 0;
                  cheeseCount--;
              }

              visited[ny][nx] = true;
          }
      }
  }

  static void changeAir() {
      boolean[][] visited = new boolean[N][M];
      Queue<int[]> queue = new ArrayDeque<>();
      queue.offer(new int[]{0, 0});
      visited[0][0] = true;

      while (!queue.isEmpty()) {
          int[] current = queue.poll();
          int y = current[0];
          int x = current[1];

          for (int d = 0; d < 4; d++) {
              int ny = y + dy[d];
              int nx = x + dx[d];

              if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx] || board[ny][nx] == 1) continue;

              queue.offer(new int[]{ny, nx});
              visited[ny][nx] = true;
          }
      }
  }

}
