import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_17471_1 {

  static int N, peopleTotal;
  static int[] people;
  static int[] tgt; // 1 선거구 - 1, 2 선거구 - 0
  static List<List<Integer>> edgesList;
  static boolean[] check;
  static int answer = Integer.MAX_VALUE;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    people = new int[N];
    peopleTotal = 0;
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      people[i] = num;
      peopleTotal = people[i];
    }
    edgesList = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      edgesList.add(new ArrayList<>());
    }

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int cnt = Integer.parseInt(st.nextToken());
      for (int j = 0; j < cnt; j++) {
        edgesList.get(i).add(Integer.parseInt(st.nextToken()));
      }
    }

    tgt = new int[N];
    comb(0, 0);
    if(peopleTotal == Integer.MAX_VALUE){
      System.out.println(-1);
    }else{
      System.out.println(answer);
    }
  }

  static void comb(int tgtIdx, int sum) {

    if (tgtIdx >= N) {

      check = new boolean[N];
      int cnt = 0;
      System.out.println(tgt);
      for (int i = 0; i < N; i++) {
        if (check[i])
          continue;
        cnt++;
        bfs(i, tgt[i]);
      }

      if (cnt == 2) {
        answer = Math.min(answer, peopleTotal-sum);
      }

      return;
    }
   

    tgt[tgtIdx] = 1;
    comb(tgtIdx + 1, sum+people[tgtIdx]);
    tgt[tgtIdx] = 0;
    comb(tgtIdx + 1, sum);

  }

  static void bfs(int idx, int zoneNumber) {
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(idx);
    check[idx] = true;

    while (!queue.isEmpty()) {
      int now = queue.poll();

      for (int next : edgesList.get(now)) {
        if (tgt[next] == zoneNumber && check[next] == false) {
          queue.offer(next);
          check[next] = true;
        }
      }
    }
  }
}
