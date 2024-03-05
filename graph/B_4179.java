package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_4179 {

  static int R, C;
  static String[][] board;
  static Pos jihun, fire;
  static int[] dy = { -1, 0, 1, 0 };
  static int[] dx = { 0, 1, 0, -1 };
  static Queue<Pos> jihunQueue = new ArrayDeque<>();
  static Queue<Pos> fireQueue = new ArrayDeque<>();
  static Queue<Pos> exitQueue = new ArrayDeque<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    board = new String[R][C];
    for (int i = 0; i < R; i++) {
      String[] input = br.readLine().split("");
      for (int j = 0; j < C; j++) {
        board[i][j] = input[j];
        if (board[i][j].equals("J")) {
          jihun = new Pos(i, j, 0);
          jihunQueue.offer(jihun);
        } else if (board[i][j].equals("F")) {
          fire = new Pos(i, j, -1);
          fireQueue.offer(fire);
        }
      }
    }
    while (!jihunQueue.isEmpty()) {
      // 지훈 이동
      move_jihun();

      for (int i = 0; i < R; i++) {
        System.out.println(Arrays.toString(board[i]));
      }
      // 불 이동
      spread_fire();

      for (int i = 0; i < R; i++) {
        System.out.println(Arrays.toString(board[i]));
      }
      System.out.println();
    }
  }

  static void move_jihun() {

    Queue<Pos> tempQueue = new ArrayDeque<>();
    while (!jihunQueue.isEmpty()) {
      Pos nowJihun = jihunQueue.poll();
      int y = nowJihun.y;
      int x = nowJihun.x;

      for (int i = 0; i < 4; i++) {
        int yy = y + dy[i];
        int xx = x + dx[i];
        if (yy < 0 || yy >= R || xx < 0 || xx >= C || !board[yy][xx].equals("."))
          continue;

        board[yy][xx] = "J";
        tempQueue.offer(new Pos(yy, xx, nowJihun.cnt + 1));
        if (yy == 0 || yy == R || xx == 0 || xx == C)
          exitQueue.offer(new Pos(yy, xx, nowJihun.cnt + 1));

      }
    }
    while (!tempQueue.isEmpty()) {
      Pos tempJihun = tempQueue.poll();
      jihunQueue.offer(tempJihun);
    }

  }

  static void spread_fire() {
    Queue<Pos> tempQueue = new ArrayDeque<>();
    while (!fireQueue.isEmpty()) {
      Pos nowFire = fireQueue.poll();
      int y = nowFire.y;
      int x = nowFire.x;
System.out.println(y+" "+x);
      for (int i = 0; i < 4; i++) {
        int yy = y + dy[i];
        int xx = x + dx[i];
        if (yy < 0 || yy >= R || xx < 0 || xx >= C) {
          System.out.println(nowFire.cnt);
          System.exit(0);
        }

        if (board[yy][xx].equals(".") && board[yy][xx].equals("R")) {
          board[yy][xx] = "F";
          tempQueue.offer(new Pos(yy, xx, -1)); 
        }
        

      }
    }
    while (!tempQueue.isEmpty()) {
      Pos tempFire = tempQueue.poll();
      fireQueue.offer(tempFire);
    }
  }

  static class Pos {
    int y;
    int x;
    int cnt;

    Pos(int y, int x, int cnt) {
      this.y = y;
      this.x = x;
      this.cnt = cnt;
    }

    @Override
    public String toString() {
      return "Pos [y=" + y + ", x=" + x + ", cnt=" + cnt + "]";
    }

  }
}
