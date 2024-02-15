package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1873 {
  static int H, W, N;
  static String[][] board;
  static int Car_y, Car_x;
  static String[] command;

  // 위 아래 왼 오
  static int[] dy = { -1, 1, 0, 0 };
  static int[] dx = { 0, 0, -1, 1 };

  static String[] change = { "^", "v", "<", ">" };
  static int car_idx = -1;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t < T + 1; t++) {
      String[] input = br.readLine().split(" ");
      H = Integer.parseInt(input[0]);
      W = Integer.parseInt(input[1]);
      board = new String[H][W];

      for (int i = 0; i < H; i++) {
        input = br.readLine().split("");
        for (int j = 0; j < W; j++) {
          board[i][j] = input[j];
          if (board[i][j].equals("^")) {
            Car_y = i;
            Car_x = j;
            car_idx = 0;
          } else if (board[i][j].equals("v")) {
            Car_y = i;
            Car_x = j;
            car_idx = 1;
          } else if (board[i][j].equals("<")) {
            Car_y = i;
            Car_x = j;
            car_idx = 2;
          } else if (board[i][j].equals(">")) {
            Car_y = i;
            Car_x = j;
            car_idx = 3;
          }

        }
      }
      N = Integer.parseInt(br.readLine());
      command = br.readLine().split("");

      for (int i = 0; i < N; i++) {
        if (command[i].equals("U")) {
          car_change(0);
        } else if (command[i].equals("D")) {
          car_change(1);
        } else if (command[i].equals("L")) {
          car_change(2);
        } else if (command[i].equals("R")) {
          car_change(3);
        } else if (command[i].equals("S")) {
          car_shoot();
        }

      }
      System.out.print("#" + t + " ");
      for (int i = 0; i < H; i++) {
        for (int j = 0; j < W; j++) {
          System.out.print(board[i][j]);
        }
        System.out.println();
      }
    }

  }

  static void car_change(int idx) {
    if (Car_y + dy[idx] >= 0 && Car_y + dy[idx] < H && Car_x + dx[idx] >= 0 && Car_x + dx[idx] < W) {
      if (board[Car_y + dy[idx]][Car_x + dx[idx]].equals(".")) {
        board[Car_y][Car_x] = ".";
        Car_y += dy[idx];
        Car_x += dx[idx];
      }
    }

    board[Car_y][Car_x] = change[idx];
    car_idx = idx;
  }

  static void car_shoot() {
    int boom_y = Car_y;
    int boom_x = Car_x;

    while (true) {
      boom_y += dy[car_idx];
      boom_x += dx[car_idx];

      if (boom_y < 0 || boom_y >= H || boom_x < 0 || boom_x >= W) {
        break;
      }
      if (board[boom_y][boom_x].equals("*")) {
        board[boom_y][boom_x] = ".";
        break;
      } else if (board[boom_y][boom_x].equals("#")) {
        break;
      }

    }
  }

}