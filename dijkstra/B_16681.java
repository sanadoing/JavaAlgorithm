package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_16681 {

  static int N, M, D, E;
  static long[] height;
  static List<List<Node>> routes;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken()); // 지점 수
    M = Integer.parseInt(st.nextToken()); // 경로 수
    D = Integer.parseInt(st.nextToken()); // 거리 비례 소모량
    E = Integer.parseInt(st.nextToken()); // 높이 비례 성취 획득량

    height = new long[N + 1]; // 지점마다의 높이 저장
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i < N + 1; i++) {
      height[i] = Long.parseLong(st.nextToken());
    }

    routes = new ArrayList<>();

    for (int i = 0; i < N + 1; i++) { // 0 dummy
      routes.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      long c = Long.parseLong(st.nextToken());

      routes.get(s).add(new Node(e, c));
      routes.get(e).add(new Node(s, c));
    }

    long result = Long.MIN_VALUE;
    for (int i = 2; i < N; i++) {
      System.out.println("==================");
      System.out.println("target " + i);
      long sumDistance = 0;
      // 1 -> i
      long[] d1 = dijkstra(i);
      if (d1[0] == 0)
        continue;
      sumDistance += d1[1];
      System.out.println();
      // i -> N
      long[] d2 = dijkstra2(i);
      if (d2[0] == 0)
        continue;
      sumDistance += d2[1];
      result = Math.max(height[i] - sumDistance, result);
      System.out.println("\n==================");
    }
    System.out.println(result);

  }

  static long[] dijkstra(int target) {
    PriorityQueue<Node> pqueue = new PriorityQueue<>((n1, n2) -> (n1.cost - n2.cost) < 0 ? -1 : 1);

    pqueue.offer(new Node(1, 0));
    long flag = 0;
    // long distance = 0;
    long[] distance = new long[N + 1];
    Arrays.fill(distance, Long.MAX_VALUE);

    while (!pqueue.isEmpty()) {
      Node current = pqueue.poll();

      distance += current.cost;
      System.out.print(current.end + " ");
      if (current.end == target) {
        flag = 1;
        break;
      }

      for (Node next : routes.get(current.end)) {
        if (height[current.end] < height[next.end]) {
          pqueue.offer(next);
        }
      }
    }
    if (flag == 1) {
      return new long[] { 1, distance };
    }
    return new long[] { 0, distance };
  }

  static long[] dijkstra2(int target) {
    PriorityQueue<Node> pqueue = new PriorityQueue<>((n1, n2) -> (n1.cost - n2.cost) < 0 ? -1 : 1);

    pqueue.offer(new Node(target, 0));

    long distance = 0;
    long flag = 0;
    while (!pqueue.isEmpty()) {
      Node current = pqueue.poll();

      distance += current.cost;
      System.out.print(current.end + " ");
      if (current.end == N) {
        flag = 1;
        break;
      }

      for (Node next : routes.get(current.end)) {
        if (height[current.end] > height[next.end]) {
          pqueue.offer(next);
        }
      }
    }
    if (flag == 1) {
      return new long[] { 1, distance };
    }
    return new long[] { 0, distance };
  }

  static class Node {
    int end;
    long cost;

    Node(int end, long cost) {
      this.end = end;
      this.cost = cost;
    }

    @Override
    public String toString() {
      return "Node [end=" + end + ", cost=" + cost + "]";
    }

  }
}