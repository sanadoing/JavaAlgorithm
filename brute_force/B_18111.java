package brute_force;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_18111 {

  static int N, M, B, min, max;
  static int result_time = Integer.MAX_VALUE;
  static int result_height = 0;
  static int[][] ground;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());

    min = Integer.MAX_VALUE;
    max = Integer.MIN_VALUE;

    ground = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        ground[i][j] = Integer.parseInt(st.nextToken());
        if (ground[i][j] < min) {
          min = ground[i][j];
        }
        if (ground[i][j] > max) {
          max = ground[i][j];
        }
      }
    }
    for (int i = min; i <= max; i++) {
      find(i);
    }
    System.out.println(result_time+" "+result_height);
  }

  static void find(int target) {

    int t_result = 0;
    int t_B = B;
    
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (ground[i][j] < target) {
          if (target - ground[i][j] <= t_B) {
            t_B -= target - ground[i][j];
            t_result += (target - ground[i][j]);
          } else {
            return;
          }
        } else if (ground[i][j] > target) {
          t_B += ground[i][j] - target;
          t_result += (ground[i][j] - target) * 2;
        }

      }
    }

    if(result_time > t_result){
      result_time = t_result;
      result_height = target;
    }
  }
}
