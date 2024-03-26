package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class B_24448 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    Deque<String> stack = new ArrayDeque<>();
    for (int i = 0; i < N; i++) {
      String now = br.readLine();
      if (now.equals("READ")) {
        System.out.println(stack.pop());
      } else {
        stack.push(now);
      }

    }
  }

}
