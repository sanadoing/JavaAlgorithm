package dijkstra;
import java.util.*;
import java.io.*;


class Main {
  static int N,M,S,E,INF;
  static ArrayList<ArrayList<Node>> graph;
  static int[] min_dis;
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    while (true) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      S = Integer.parseInt(st.nextToken());
      E = Integer.parseInt(st.nextToken());
      if (N == 0 && M == 0 && S == 0 && E == 0) break;
      else {

        graph = new ArrayList<ArrayList<Node>>();
        min_dis = new int[N+1];
        INF = Integer.MAX_VALUE;

        for (int i=0;i<=N; i++) {
          graph.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
          st = new StringTokenizer(br.readLine());

          int V = Integer.parseInt(st.nextToken());
          int E = Integer.parseInt(st.nextToken());
          int C = Integer.parseInt(st.nextToken());

          graph.get(V).add( new Node(E,C));

        }

        int[] ans = dijkstra(S);
        sb.append(ans[E]).append("\n");
      }
    }
    System.out.println(sb);
  }

  public static int[] dijkstra(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<Node>((o1,o2)-> o1.cost-o2.cost);
    for (int i=0; i<=N; i++) {
      min_dis[i] = INF;
    }
    min_dis[start] = 0;
    pq.offer(new Node(start,0));

    while (!pq.isEmpty()){
      Node cur = pq.poll();

      if (min_dis[cur.idx] < cur.cost) continue;

      for (int i=0; i<graph.get(cur.idx).size(); i++) {
        Node next = graph.get(cur.idx).get(i);

        if (min_dis[next.idx] > cur.cost + next.cost) {
          min_dis[next.idx] = cur.cost + next.cost;
          pq.offer(new Node(next.idx, cur.cost+next.cost));
        }
      }

    }
    return min_dis;
    
  }
}

class Node{
  int idx;
  int cost;
  public Node(int idx, int cost) {
    this.idx = idx;
    this.cost = cost;
  }
}
