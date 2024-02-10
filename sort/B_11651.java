package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B_11651 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    List<Node> array = new ArrayList<>();
    int y, x;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());
      array.add(new Node(x, y));
    }
    Collections.sort(array,(n1, n2)->
      n1.y == n2.y ? n1.x-n2.x : n1.y-n2.y
    );
    for (int i = 0; i < N; i++) {
      System.out.println(array.get(i).x+" "+array.get(i).y);
    }
  }

  static class Node {
    int x;
    int y;

    Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
