package brute_force;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_16987 {

  static int N, answer = 0;
  static int[][] egg;
  static int[] selected;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    egg = new int[N][2];
    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      egg[i][0] = Integer.parseInt(st.nextToken());
      egg[i][1] = Integer.parseInt(st.nextToken());
    }

    selected = new int[N];

    dfs(0, 0);
    System.out.println(answer);

  }

  static void dfs(int idx, int count) {

    if (idx == N) {
      answer = Math.max(answer, count);
      return;
    }
    if (egg[idx][0] < 0 || count == N - 1) {
      dfs(idx + 1, count);
      return;
    }
    for (int i = 0; i < N; i++) {
      if (i == idx)
        continue;
      if (egg[i][0] <= 0)
        continue;
      egg[idx][0] -= egg[i][1];
      egg[i][0] -= egg[idx][1];
      if (egg[idx][0] < 0)
        count += 1;
      if (egg[i][0] < 0)
        count += 1;

      dfs(idx + 1, count);
      if (egg[idx][0] < 0)
        count -= 1;
      if (egg[i][0] < 0)
        count -= 1;
      egg[idx][0] += egg[i][1];
      egg[i][0] += egg[idx][1];

    }
  }

}