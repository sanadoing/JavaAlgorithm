package b_a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_2382_미생물격리 {

  static int N, M, K;
  static int[][][] board;
  static Queue<int[]> queue;

  // 0 dummy / 상 - 하 - 좌 - 우
  static int[] dy = { 0, -1, 1, 0, 0 };
  static int[] dx = { 0, 0, 0, -1, 1 };

  static int[] dd = { 0, 2, 1, 4, 3 };

  static int result;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringTokenizer st;
    for (int t = 1; t <= T; t++) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken()); // 셀의 개수
      M = Integer.parseInt(st.nextToken()); // 격리 시작
      K = Integer.parseInt(st.nextToken()); // 미생물 군집의 개수

      board = new int[N][N][3]; // [i][j][0] : 해당 자리의 군집의 미생물 수의 합 , [i][j][1] : 각각 군집의 최댓값 (방향 선정을 위한 ),
                                // [i][j][2] : 해당 자리의 군집의 방향
      queue = new ArrayDeque<>();

      int y, x, c, d;
      for (int i = 0; i < K; i++) {
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken()); // 세로
        x = Integer.parseInt(st.nextToken()); // 가로
        c = Integer.parseInt(st.nextToken()); // 미생물 수
        d = Integer.parseInt(st.nextToken()); // 이동 방향

        board[y][x][0] = c;
        board[y][x][1] = c;
        board[y][x][2] = d;

        queue.offer(new int[] { y, x, c, d });
      }

      while (M-- > 0) {
        // System.out.println(M);
        move();
        // for (int i = 0; i < N; i++) {
        // for (int j = 0; j < N; j++) {
        // System.out.print(Arrays.toString(board[i][j]) + " ");
        // }
        // System.out.println();
        // }
      }

      System.out.println("#" + t + " " + result);
    }

  }

  static void move() {
    int[][][] newBoard = new int[N][N][3];

    result = 0;
    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int cy = current[0];
      int cx = current[1];
      int cc = current[2];
      int cd = current[3];

      int ny = cy + dy[cd];
      int nx = cx + dx[cd];

      // System.out.println("queue " + Arrays.toString(current));
      if (newBoard[ny][nx][0] != 0) {
        newBoard[ny][nx][0] += cc;
        if (newBoard[ny][nx][1] > cc) {
          continue;
        } else {
          newBoard[ny][nx][1] = cc;
          newBoard[ny][nx][2] = cd;
        }
      } else {
        newBoard[ny][nx][0] = cc;
        newBoard[ny][nx][1] = cc;
        newBoard[ny][nx][2] = cd;
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (newBoard[i][j][0] != 0) {
          if ((i == 0 || j == 0 || i >= N - 1 || j >= N - 1)) {
            // System.out.println("case1 " + Arrays.toString(newBoard[i][j]));
            queue.offer(new int[] { i, j, newBoard[i][j][0] / 2, dd[newBoard[i][j][2]] });
            newBoard[i][j] = new int[] { newBoard[i][j][0] / 2, newBoard[i][j][0] / 2, dd[newBoard[i][j][2]] };
          } else {
            // System.out.println("case2 " + Arrays.toString(newBoard[i][j]));
            queue.offer(new int[] { i, j, newBoard[i][j][0], newBoard[i][j][2] });
          }
          result += newBoard[i][j][0];
        }
      }
      board[i] = newBoard[i].clone();
    }
  }
}
