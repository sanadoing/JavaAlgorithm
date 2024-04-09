package a_samsung;

// https://kau-algorithm.tistory.com/585
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B_23291_어항정리 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int N, K;
  static int[][] arr;
  static int[] dy = { -1, 0, 1, 0 };
  static int[] dx = { -1, 0, 1, 0 };

  static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    arr = new int[101][101];
    // for (int i = 0; i < arr.length; i++) {
    arr[0] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    // }
    // System.out.println(Arrays.toString(arr[0]));
  }

  static void add_fish() // 물고기가 적은 어항에 1마리씩 넣음.
  {
    List<Integer> idxs = new ArrayList<>();
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < N; ++i) {
      if (arr[0][i] == min) {
        idxs.add(i);
      } else if (arr[0][i] < min) {
        idxs.clear();
        idxs.add(i);
        min = arr[0][i];
      }
    }
    for (int idx : idxs) {
      arr[0][idx]++;
    }
  }

  static void make_fish_building() // 어항 쌓음.
  {
    boolean flag = false;
    int r = 1;
    int c = 1;

    while (true) {
      int[][] temparr = new int[c][r];
      for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
          temparr[j][r - i - 1] = arr[i][j];
        }
      }

      for (int i = 0; i < r; ++i) {
        for (int j = 0; j < c; ++j) {
          arr[i][j] = temparr[i][j];
        }
      }
    }
  }

  move_fish();

  make_fish_onefloor_building();

  make_fish_building2();

  move_fish();

  make_fish_onefloor_building();

  public static void main(String[] args) throws Exception {
    int answer = 0;
    init();
    while (max_min() > k) {
      answer++;
      add_fish(); // 물고기가 적은 어항에 1마리씩 넣음.
      make_fish_building(); // 어항 쌓음.
      move_fish();
      make_fish_onefloor_building();
      make_fish_building2();
      move_fish();
      make_fish_onefloor_building();
    }
    System.out.println(answer);
  }
}
