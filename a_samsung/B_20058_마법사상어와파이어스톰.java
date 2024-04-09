package a_samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_20058_마법사상어와파이어스톰 {

  static int N, Q, L, mapSize;
  static int[][] map;
  static int[] dy = new int[] { -1, 0, 1, 0 };
  static int[] dx = new int[] { 0, 1, 0, -1 };
  static int iceSum = 0;
  static int iceCnt = 0;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    Q = Integer.parseInt(st.nextToken());

    mapSize = (int) Math.pow(2, N);
    map = new int[mapSize][mapSize];

    for (int i = 0; i < mapSize; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < mapSize; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < Q; i++) {
      L = Integer.parseInt(st.nextToken());
      iceCnt = 0;
      if (L == 0) {
        L = 1;
      } else {
        L = (int) Math.pow(2, L);
      }

      map_change();

      melt_ice();

      find_ice();

    }
    System.out.println(iceSum);
    System.out.println(iceCnt);
  }

  static void find_ice() {
    boolean[][] visit = new boolean[mapSize][mapSize];

    for (int i = 0; i < mapSize; i++) {
      for (int j = 0; j < mapSize; j++) {
        if (visit[i][j])
          continue;
        if (map[i][j] > 0) {
          Queue<int[]> queue = new ArrayDeque<>();
          queue.offer(new int[] { i, j });
          visit[i][j] = true;
          int cnt = 1;
          while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cy = current[0];
            int cx = current[1];

            for (int k = 0; k < 4; k++) {
              int yy = cy + dy[k];
              int xx = cx + dx[k];
              if (yy < 0 || xx < 0 || yy > mapSize - 1 || xx > mapSize - 1 || visit[yy][xx])
                continue;

              if (map[yy][xx] > 0) {
                visit[yy][xx] = true;
                queue.offer(new int[] { yy, xx });
                cnt += 1;
              }
            }
          }

          iceCnt = Math.max(iceCnt, cnt);
        }
      }
    }

  }

  static void melt_ice() {
    int[][] new_map = new int[mapSize][mapSize];
    int sum = 0;

    for (int y = 0; y < mapSize; y++) {
      for (int x = 0; x < mapSize; x++) {

        int iceCnt = 0;

        for (int i = 0; i < 4; i++) {
          int yy = y + dy[i];
          int xx = x + dx[i];

          if (0 > yy || 0 > xx || yy > mapSize - 1 || xx > mapSize - 1)
            continue;

          if (map[yy][xx] > 0)
            iceCnt += 1;

        }

        if (iceCnt < 3) {
          if (map[y][x] == 0) {
            new_map[y][x] = 0;
          } else {
            new_map[y][x] = map[y][x] - 1;
          }

        } else {
          new_map[y][x] = map[y][x];
        }
        sum += new_map[y][x];
      }

    }
    for (int i = 0; i < mapSize; i++) {
      map[i] = new_map[i].clone();
    }
    iceSum = sum;

  }

  static void map_change() {

    for (int i = 0; i < mapSize / L; i++) {
      for (int j = 0; j < mapSize / L; j++) {
        int[] tempIce = new int[L * L];
        int startY = i * L;
        int startX = j * L;
        int idx = 0;

        for (int y = startY; y < startY + L; y++) {
          for (int x = startX; x < startX + L; x++) {
            tempIce[idx] = map[y][x];

            idx += 1;
          }
        }

        idx = 0;
        for (int x = startX + L - 1; x >= startX; x--) {
          for (int y = startY; y < startY + L; y++) {
            map[y][x] = tempIce[idx];
            idx += 1;
          }
        }

      }

    }

  }
}