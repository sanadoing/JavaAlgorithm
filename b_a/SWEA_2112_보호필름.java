package b_a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2112_보호필름 {

  static int D, W, K;
  static int[][] board;
  static int result;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringTokenizer st;
    for (int t = 1; t <= T; t++) {
      st = new StringTokenizer(br.readLine());
      D = Integer.parseInt(st.nextToken()); // 보호 필름 두께
      W = Integer.parseInt(st.nextToken()); // 가로 크기
      K = Integer.parseInt(st.nextToken()); // 합격 기준

      board = new int[D][W];
      for (int y = 0; y < D; y++) {
        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < W; x++) {
          board[y][x] = Integer.parseInt(st.nextToken());
        }
      }

      result = Integer.MAX_VALUE;
      // System.out.println("D " + D);
      dfs(0, 0);
      System.out.println("#" + t + " " + result);
    }
  }

  static void dfs(int depth, int cnt) {
    // System.out.println(D + " " + W + " " + K + " " + cnt + " " + result + " " +
    // depth);
    if (cnt >= result) {
      return;
    }
    if (depth == D) {
      // System.out.println("????" + depth + " " + D);
      for (int x = 0; x < W; x++) {
        int same = 1;
        int sameMax = -1;
        for (int y = 1; y < D; y++) {
          if (board[y][x] == board[y - 1][x]) {
            same += 1;
          } else {

            same = 1;
          }
          sameMax = Math.max(sameMax, same);
        }
        if (sameMax < K)
          return;
      }

      result = Math.min(result, cnt);
      return;
    }

    int[] tmp = board[depth].clone();

    dfs(depth + 1, cnt);

    Arrays.fill(board[depth], 0);
    dfs(depth + 1, cnt + 1);

    Arrays.fill(board[depth], 1);
    dfs(depth + 1, cnt + 1);

    board[depth] = tmp;

  }
}
