import java.io.*;
import java.util.*;

public class B_27172 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int MAX_SIZE = 1000001;
    int[] cards = new int[N]; // 입력 값, 가지고 있는 카드
    boolean[] check = new boolean[MAX_SIZE]; // 그 카드가 해당 게임에 나온 카드인지 체크
    int[] result = new int[MAX_SIZE]; // 각 플레이어 마다 결과값을 저장하기 위한

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int input = Integer.parseInt(st.nextToken());
      cards[i] = input;
      check[input] = true;
    }
    StringBuilder sb = new StringBuilder();
    for (int now : cards) {
      for (int j = (now * 2); j < MAX_SIZE; j += now) {
        if (check[j]) {
          result[now] += 1;
          result[j] -= 1;
        }
      }
    }
    for (int now : cards) {
      sb.append(result[now]).append(" ");
    }
    System.out.println(sb);
  }
}
