package b_a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1486_장훈이의높은선반 {
  static int N, B;
  static int[] height;
  static int result;

  // static boolean visit;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      B = Integer.parseInt(st.nextToken());

      height = new int[N];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        height[i] = Integer.parseInt(st.nextToken());
      }
      result = Integer.MAX_VALUE;
      dfs(0, 0);
      System.out.println("#" + t + " " + result);
    }

  }

  static void dfs(int depth, int sum) {
    if (depth == N) {
      if (sum < B)
        return;
      else {
        result = Math.min(result, sum - B);
      }
      return;
    }

    dfs(depth + 1, sum + height[depth]);
    dfs(depth + 1, sum);

  }

}