package a_samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_15684_사다리조작 {

  static boolean[][] board;
  static int N, M, H; // N - 세로선 개수, M - 가로선 개수, H - 가로선 놓을 수 있는 위치 개수
  static int[][] tgt;
  static int srcCnt;
  static ArrayList<int[]> list;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    board = new boolean[H][N];

    for (int i = 0; i < M; i++) {
      // a b : a번 위치에 있는 b번, b+1 세로선을 잇는 선
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      board[a - 1][b - 1] = true;
      board[a - 1][b] = true;
    }
    // for (int i = 0; i < H; i++) {
    // for (int j = 0; j < N; j++) {
    // System.out.print(board[i][j] + " ");
    // }
    // System.out.println();
    // }

    list = new ArrayList<>();
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < N - 1; j++) {
        if (!board[i][j] || !board[i][j + 1]) {
          list.add(new int[] { i, j });
        }
      }
    }
    // for (int index = 0; index < list.size(); index++) {
    // System.err.println(Arrays.toString(list.get(index)));
    // }

    srcCnt = list.size();
    // 조합 0 개, 1개, 2개, 3개

    // 0개
    if (check()) {
      System.out.println(0);
      System.exit(0);
    }

    // 1개, 2개, 3개
    for (int i = 1; i < 4; i++) {
      tgt = new int[i][2];
      System.out.println("cnt " + i);
      comb(0, 0, i); // i 개까지 고름

    }
  }

  static void comb(int srcIdx, int tgtIdx, int cnt) {
    if (tgtIdx == cnt) {

      for (int i = 0; i < cnt; i++) {
        System.out.print(Arrays.toString(tgt[i]) + " ");
        board[tgt[i][0]][tgt[i][1]] = true;
        board[tgt[i][0]][tgt[i][1] + 1] = true;
      }
      System.out.println();

      if (check()) {
        System.out.println(cnt);
        System.exit(0);
      }
      return;
    }

    if (srcIdx == srcCnt - 1)
      return;

    tgt[tgtIdx][0] = list.get(srcIdx)[0];
    tgt[tgtIdx][1] = list.get(srcIdx)[1];
    comb(srcIdx + 1, tgtIdx + 1, cnt);
    comb(srcIdx + 1, tgtIdx, cnt);

  }

  static boolean check() {
    for (int i = 0; i < N - 1; i++) {
      // i번 라인
      int line = i;
      int num = 0; // 시작 지점 (가로 번호)
      while (true) {
        System.out.println(num + " " + line);
        if (board[line][num] && board[line][num + 1])
          line += 1;
        else
          num += 1;

        if (num == H - 1) {
          break;
        }
      }
      if (line != i)
        return false;
    }
    return true;
  }
}
