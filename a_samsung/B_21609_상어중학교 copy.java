package a_samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_21609_상어중학교 {
  static int N, M;
  static int[][] board;
  static int[] dy = { -1, 0, 1, 0 };
  static int[] dx = { 0, 1, 0, -1 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    board = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    find_max_block();
  }

  static void find_max_block() {
    boolean[][] visit = new boolean[N][N];
    List<int[]> maxBlock = new ArrayList<>();
    List<int[]> tmpBlock = new ArrayList<>();

    System.out.println("start");
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visit[i][j] && board[i][j] >= 1) { // 방문하지 않은 일반 블록
          int color = board[i][j];

          tmpBlock = new ArrayList<>();

          Queue<int[]> queue = new ArrayDeque<>();
          queue.offer(new int[] { i, j });
          visit[i][j] = true;
          System.out.println(i + " " + j);
          while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cy = current[0];
            int cx = current[1];
            tmpBlock.add(new int[] { cy, cx });
            for (int k = 0; k < 4; k++) {
              int yy = cy + dy[k];
              int xx = cx + dx[k];
              if (yy < 0 || xx < 0 || yy >= N || xx >= N)
                continue;
              if (board[yy][xx] == 0) { // 무지개
                queue.offer(new int[] { yy, xx });
              }
              if (board[yy][xx] == color && !visit[yy][xx]) { // 같은 색 블럭
                queue.offer(new int[] { yy, xx });
                visit[yy][xx] = true;
              }

            }
          }

          if (tmpBlock.size() > maxBlock.size()) {
            maxBlock.clear();
            for (int[] t : tmpBlock) {
              maxBlock.add(t);
              System.out.println(Arrays.toString(t));
            }
          }
          System.out.println("tmpBlock");
          for (int[] t : tmpBlock) {
            System.out.print(Arrays.toString(t) + " ");
          }
          System.out.println("maxBlock");

          for (int[] m : maxBlock) {
            System.out.print(Arrays.toString(m) + " ");
          }

        }
      }
    }

  }
}
