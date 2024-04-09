package b_a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 테케 14 / 15
public class SWEA_4193_수영대회결승전 {

  static int[] dy = { -1, 0, 1, 0 };
  static int[] dx = { 0, 1, 0, -1 };
  static int result = -1;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringTokenizer st;
    for (int t = 1; t <= T; t++) {
      int N = Integer.parseInt(br.readLine());

      int[][] map = new int[N][N];
      boolean[][] visit = new boolean[N][N];

      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
          if (map[i][j] == 5) {
            map[i][j] = 0;
          }
        }
      }
      st = new StringTokenizer(br.readLine());
      int sy = Integer.parseInt(st.nextToken());
      int sx = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      int ey = Integer.parseInt(st.nextToken());
      int ex = Integer.parseInt(st.nextToken());

      // for (int i = 0; i < N; i++) {
      // Arrays.fill(visit[i], Integer.MAX_VALUE);
      // }

      Queue<int[]> queue = new ArrayDeque<>();

      if (map[sy][sx] == 2) {
        queue.offer(new int[] { sy, sx, 3 });
      } else {
        queue.offer(new int[] { sy, sx, 0 });
      }
      while (!queue.isEmpty()) {
        int[] current = queue.poll();
        int cy = current[0];
        int cx = current[1];
        int ct = current[2];

        visit[sy][sx] = true;

        if (cy == ey && cx == ex) {
          result = ct;
          break;
        }

        for (int i = 0; i < 4; i++) {
          int yy = cy + dy[i];
          int xx = cx + dx[i];
          if (yy < 0 || xx < 0 || yy >= N || xx >= N)
            continue;
          if (visit[yy][xx])
            continue;
          if (map[yy][xx] == 1) // 1. 장애물
            continue;
          else if (map[yy][xx] == 2) { // 2. 소용돌이
            if ((ct) % 3 == 2) { // 2 - 1 소용돌이를 지나갈 수 있는
              visit[yy][xx] = true;
              queue.offer(new int[] { yy, xx, ct + 1 });
            } else { // 2 - 2 소용돌이를 지나갈 수 없는
              visit[cy][cx] = true;
              queue.offer(new int[] { cy, cx, ct + 1 });
            }
          } else if (map[yy][xx] == 0) { // 3. 지나갈 수 있는 곳
            visit[yy][xx] = true;
            queue.offer(new int[] { yy, xx, ct + 1 });
          }

        }

      }
      System.out.println("#" + t + " " + (result));

    }

  }

}