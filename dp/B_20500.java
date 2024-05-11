// 다른 사람 풀이 보고 이해하는 걸 목표로 함 !
// 3의 배수 => 각 자리의 수의 합이 3의 배수 
// 5의 배수 => 1의 자리 0 or 5
// 근데 1과 5로만 구성된 수 => 1의 자리 5로 고정 

// 결국 우리는 각 자리의 모든 합을 3으로 나눴을 때, 나머지가 0인 나눠떨어지는 수를 찾아야 함.
/*
dp[3을 나눈 나머지][자릿 수]
1의 자리가 5이면서 1과 5로 이루어진 수 = 15, 55 
각 자리의 합을 3으로 나눈 나머지가 0(15), 1(55), 2
dp[0][2] = 1
dp[1][2] = 1
dp[2][2] = 0

자릿 수를 + 1 을 하면
       N - 1           =>      N  
각 자릿수의 합이 0 + 1 = 1 => 3으로 나눈 나머지 1 -----|
               + 5 = 5 => 3으로 나눈 나머지 2 -|   |
                                           |   |
각 자릿수의 합이 1 + 1 = 2 => 3으로 나눈 나머지 2 -|   |
               + 5 = 6 => 3으로 나눈 나머지 0 ---| |
                                             | |
각 자릿수의 합이 2 + 1 = 3 => 3으로 나눈 나머지 0 ---| |
               + 5 = 7 => 3으로 나눈 나머지 1 -----|

dp[N][0] = dp[N-1][1] + dp[N-1][2] 
이 의미는, 다음 (N)자리에서 각자리의 합이 0이 나올 수 있는 경우는, 
(N-1)자리에서 각 자리의 합을 3으로 나눈 나머지가 1인 경우일 때의 cnt + (N-1)자리에서 각 자리의 합을 3으로 나눈 나머지가 2인 경우일 때의 cnt임

dp[N][1] = dp[N-1][0] + dp[N-1][2]
dp[N][2] = dp[N-1][0] + dp[N-1][1]
 */

import java.util.Scanner;

public class B_20500 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    int MOD = 1000000007;
    int[][] dp = new int[3][2 + N];
    dp[0][2] = 1;
    dp[1][2] = 1;
    dp[2][2] = 0;

    for (int i = 3; i <= N; i++) {
      dp[0][i] = (dp[1][i - 1] + dp[2][i - 1]) % MOD;
      dp[1][i] = (dp[0][i - 1] + dp[2][i - 1]) % MOD;
      dp[2][i] = (dp[0][i - 1] + dp[1][i - 1]) % MOD;
    }
    System.out.println(dp[0][N]);
  }
}