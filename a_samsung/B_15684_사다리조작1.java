package a_samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_15684_사다리조작1 {

  static int[][] board;
  static int N, M, H; // N - 세로선 개수, M - 가로선 개수, H - 가로선 놓을 수 있는 위치 개수
  static int answer;
  static boolean finish = false;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    board = new int[H + 1][N + 1];// 0 dummy

    int x, y;
    for (int i = 0; i < M; i++) {

      // a b : a번 위치에 있는 b번, b+1 세로선을 잇는 선

      // 변수 명이 헷갈릴 땐, x y 로 !
      st = new StringTokenizer(br.readLine());
      y = Integer.parseInt(st.nextToken());
      x = Integer.parseInt(st.nextToken());

      board[y][x] = 1;
      board[y][x + 1] = 2;
    }

    for (int i = 0; i <= 3; i++) {
      answer = i;
      dfs(1, 0); // 시작점, depth = count
      if (finish)
        break;
    }
    System.out.println((finish) ? answer : -1);

  }

  static void dfs(int x, int count) {

    if (finish)
      return;
    if (answer == count) {
      // check
      if (check())
        finish = true;
      return;

    }

    for (int i = x; i < H + 1; i++) {
      for (int j = 1; j < N; j++) {
        if (board[i][j] == 0 && board[i][j + 1] == 0) {
          board[i][j] = 1;
          board[i][j + 1] = 2;
          dfs(i, count + 1);
          if (finish)
            return;
          board[i][j] = board[i][j + 1] = 0;
        }
      }
    }
  }

  static boolean check() {
    for (int i = 1; i <= N; i++) {

      int x = 1;
      int y = i;
      int length = H;
      while (length > 0) {
        if (board[x][y] == 1)
          y++;
        else if (board[x][y] == 2)
          y--;
        x += 1;
        length -= 1;
      }
      if (y != i)
        return false;
    }
    return true;
  }
}
