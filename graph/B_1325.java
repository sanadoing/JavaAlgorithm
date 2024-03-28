import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
// BFS -> DFS -> 백트래킹(ArrayList) -> 백트래킹(LinkedList) 
// 싸이클 발생시 -> 무한루프(시간 초과)

// 결국 BFS, visited 이차원 배열 
public class B_1325  {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
      for (int i = 0; i <= N; i++)
         graph.add(new ArrayList<Integer>());
      for (int i = 0; i < M; i++) {
         st = new StringTokenizer(br.readLine());
         int A = Integer.parseInt(st.nextToken());
         int B = Integer.parseInt(st.nextToken());
         graph.get(B).add(A);
      }

      int[] hacking = new int[N + 1];
      int max = 0;
      Queue<Integer> que = new ArrayDeque<Integer>();
      boolean[][] visited = new boolean[N + 1][N + 1];

      for (int i = 1; i <= N; i++) {
         que.offer(i);

         while (!que.isEmpty()) {
            int cur = que.poll();
            if (visited[i][cur]) continue;
            visited[i][cur] = true;
            hacking[i]++;

            int size = graph.get(cur).size();
            for (int j = 0; j < size; j++) {
               if (visited[i][graph.get(cur).get(j)])
                  continue;
               if (graph.get(cur).get(j) < i) { 
                  for (int k = 1; k <= N; k++) {
                     if (visited[i][k])
                        continue;
                     if (visited[graph.get(cur).get(j)][k]) {
                        visited[i][k] = true;
                        hacking[i]++;
                     }
                  }
               } else { 
                  que.offer(graph.get(cur).get(j));
               }
            }
         }
         max = hacking[i] > max ? hacking[i] : max;
      }

      for (int i = 1; i <= N; i++) {
         if (max == hacking[i])
            sb.append(i).append(" ");
      }
      System.out.println(sb);
   }

}
