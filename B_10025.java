import java.io.*;
import java.util.*;

public class B_10025 {

  static int N, K, pos_min = Integer.MAX_VALUE, pos_max = Integer.MIN_VALUE;
  static List<Ice> iceList = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int p = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      iceList.add(new Ice(p, s));
      pos_max = Math.max(pos_max, p);
      pos_min = Math.min(pos_min, p);
    }
    Collections.sort(iceList);
    System.out.println(iceList);
    int left = 0;
    int right = 1;
    int sum = iceList.get(left).size;
    int answer = 0;
    System.out.println( pos_min );
    int i = (pos_min - K) < 0 ?0 : pos_min - K;
    for (; i < pos_max + K; i++) {
      while (true) {
        if (left >= iceList.size()) {
          break;
        }
        if (iceList.get(left).pos > i) {
          break;
        }
        sum -= iceList.get(left).size;
        left += 1;
      }
      while (true) {
        if (right >= iceList.size()) {
          break;
        }
        if (iceList.get(right).pos < i) {
          break;
        }
        sum += iceList.get(right).size;
        right += 1;

      }
      System.out.println(i+" "+sum);
      answer = Math.max(answer, sum);
    }
    System.out.println(answer);
  }

  static class Ice implements Comparable<Ice> {
    int pos;
    int size;

    Ice(int pos, int size) {
      this.pos = pos;
      this.size = size;
    }

    @Override
    public int compareTo(Ice o) {

      return this.pos - o.pos;
    }

    @Override
    public String toString() {
      return "Ice [pos=" + pos + ", size=" + size + "]";
    }

  }
}
