package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_5557 {
  static int[] numbers;
  static int N, result;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    numbers = new int[N+1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i < N - 1; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }
    int total = Integer.parseInt(st.nextToken());
    long[][] dp = new long[N+1][21];

dp[1][numbers[1]]= 1;
  

    for (int i = 1; i < N - 2; i++) {
      for (int j = 0; j <= 20; j++) {
        if (dp[i][j] != 0) {
          int plus = j + numbers[i + 1];
          int minus = j - numbers[i + 1];
          if (plus >= 0 && plus <= 20) {
            dp[i + 1][plus] += dp[i][j];
          }
          if (minus >= 0 && minus <= 20) {
            dp[i + 1][minus] += dp[i][j];
          }
        }
      }
    }

    // BFS(1, numbers[0]);
    System.out.println(dp[N-1][total]);
  }

  // static void BFS(int idx, int sum) {
  // if (idx == N - 1) {
  // if (sum == numbers[N - 1]) {
  // result += 1;
  // }
  // return;
  // }
  // int temp = sum + numbers[idx];
  // if (0 <= temp && temp <= 20) {
  // BFS(idx + 1, temp);
  // }
  // temp = sum - numbers[idx];
  // if (0 <= temp && temp <= 20) {
  // BFS(idx + 1, temp);
  // }
  // }

}
