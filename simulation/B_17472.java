import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_17472 {

  static int N, M, islandCnt, answer = 0;
  static int[][] sea; // 처음 입력받는 바다의 입력 값들을 담은 배열
  static List<List<POS>> islands = new ArrayList<>(); // 섬의 수(인덱스 별로) 좌표들을 저장할 리스트 변수
  static boolean[][] visited;
  static boolean[] visited2;
  static int[][] bridges;
  static int[] connection;

  static List<List<NODE>> edges = new ArrayList<>();

  static int[] dy = { -1, 0, 1, 0 };
  static int[] dx = { 0, 1, 0, -1 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 입력
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    sea = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        sea[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 섬 찾기 & 좌표 저장
    visited = new boolean[N][M];
    int idx = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {

        if (visited[i][j] == false && sea[i][j] == 1) {
          islands.add(new ArrayList<>());
          islands.get(idx).add(new POS(i, j));
          sea[i][j] = idx + 1;
          find_island(i, j, idx);
          idx += 1;

        }
      }
    }

    // 섬 별로 놓을 다리 선정
    bridges = new int[N][M];
    islandCnt = islands.size();
    connection = new int[islandCnt + 1]; // 0 은 dummy

    for (int i = 0; i < islandCnt + 1; i++) {
      edges.add(new ArrayList<>());
    }

    for (int i = 1; i < islandCnt + 1; i++) {

      if (connection[i] == 1)
        continue;
      make_bridge(i);
    }

    prim();
    System.out.println(answer);

  }

  static void prim() {
    PriorityQueue<NODE> pqueue = new PriorityQueue<>((n1, n2) -> n1.c - n2.c);

    visited2 = new boolean[islandCnt + 1];

    pqueue.offer(new NODE(1, 0));

    while (!pqueue.isEmpty()) {
      NODE nowNode = pqueue.poll();

      if (visited2[nowNode.e])
        continue;
      visited2[nowNode.e] = true;
      answer += nowNode.c;

      for (NODE nextNode : edges.get(nowNode.e)) {

        if (visited2[nextNode.e])
          continue;
        pqueue.offer(nextNode);
      }

    }

    for (int i = 1; i < islandCnt + 1; i++) {
      if (visited2[i])
        continue;
      answer = -1;
    }
  }

  static void make_bridge(int idx) {

    int islandSize = islands.get(idx - 1).size();
    Queue<BPOS> queue = new ArrayDeque<>();

    for (int i = 0; i < islandSize; i++) {
      POS now = islands.get(idx - 1).get(i);
      for (int d = 0; d < 4; d++) {
        int yy = now.y + dy[d];
        int xx = now.x + dx[d];

        // 섬의 일부분 중, 바다와 맞닿아 있지 않은 부분 pass !
        if (yy < 0 || yy >= N || xx < 0 || xx >= M || sea[yy][xx] == 1)
          continue;
        queue.offer(new BPOS(now.y, now.x, d, 0));
      }
    }

    while (!queue.isEmpty()) {
      BPOS now = queue.poll();
      int dd = now.d;
      int yy = now.y + dy[dd];
      int xx = now.x + dx[dd];
      int cnt = now.cnt;

      if (yy < 0 || yy >= N || xx < 0 || xx >= M)
        continue;

      if (sea[yy][xx] == 0)
        queue.offer(new BPOS(yy, xx, dd, cnt + 1));
      if (sea[yy][xx] > 0 && cnt > 1) {

        edges.get(idx).add(new NODE(sea[yy][xx], cnt));

      }
    }

  }

  static void find_island(int y, int x, int idx) {
    Queue<POS> queue = new ArrayDeque<>();
    queue.offer(new POS(y, x));
    visited[y][x] = true;

    while (!queue.isEmpty()) {
      POS now = queue.poll();
      for (int i = 0; i < 4; i++) {
        int yy = now.y + dy[i];
        int xx = now.x + dx[i];

        if (yy < 0 || yy >= N || xx < 0 || xx >= M || visited[yy][xx] || sea[yy][xx] == 0)
          continue;
        queue.offer(new POS(yy, xx));
        visited[yy][xx] = true;
        sea[yy][xx] = idx + 1;
        islands.get(idx).add(new POS(yy, xx));
      }
    }

  }

  static class POS {
    int y;
    int x;

    POS(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

  // 섬과 바다가 맞닿아 있는 위치와 다리를 놓을 섬을 찾기 위한 방향을 저장하기 위한 class
  static class BPOS {
    // 다리를 놓을 시작 위치 y, x
    int y;
    int x;
    int d; // 다리를 놓을 방향
    int cnt; // 다리 길이

    BPOS(int y, int x, int d, int cnt) {
      this.y = y;
      this.x = x;
      this.d = d;
      this.cnt = cnt;
    }

  }

  static class NODE {
    int e;
    int c;

    NODE(int e, int c) {
      this.e = e;
      this.c = c;
    }

  }
}
