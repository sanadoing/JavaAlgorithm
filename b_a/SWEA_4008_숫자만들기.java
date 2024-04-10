package b_a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4008_숫자만들기 {

  static int N;
  // static String[] o = { "+", "-", "*", "/" };
  static int[] operator;
  static int[] numbers;
  static int[] tgt;
  static boolean[] visit;
  static int resultMin, resultMax;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      N = Integer.parseInt(br.readLine());

      operator = new int[4];

      StringTokenizer st = new StringTokenizer(br.readLine());

      for (int i = 0; i < 4; i++) {
        int cnt = Integer.parseInt(st.nextToken());
        operator[i] = cnt;
      }

      numbers = new int[N];
      st = new StringTokenizer(br.readLine());

      for (int i = 0; i < N; i++) {
        numbers[i] = Integer.parseInt(st.nextToken());
      }

      tgt = new int[N - 1];
      visit = new boolean[N - 1];
      resultMin = Integer.MAX_VALUE;
      resultMax = Integer.MIN_VALUE;
      perm(0);
      sb.append("#").append(t).append(" ").append(resultMax - resultMin).append("\n");

    }
    System.out.println(sb);
  }

  static void perm(int tgtIdx) {
    if (tgtIdx == N - 1) {
      // System.out.println(Arrays.toString(tgt));
      cal();
      return;
    }

    for (int i = 0; i < 4; i++) {
      if (operator[i] == 0)
        continue;
      operator[i]--;
      tgt[tgtIdx] = i;
      perm(tgtIdx + 1);
      operator[i]++;

    }
  }

  static void cal() {
    int sum = numbers[0];
    for (int i = 0; i < N - 1; i++) {
      if (tgt[i] == 0) {
        sum += numbers[i + 1];
      } else if (tgt[i] == 1) {
        sum -= numbers[i + 1];
      } else if (tgt[i] == 2) {
        sum *= numbers[i + 1];
      } else { // /
        sum /= numbers[i + 1];
      }
    }
    resultMax = Math.max(resultMax, sum);
    resultMin = Math.min(resultMin, sum);
  }
}