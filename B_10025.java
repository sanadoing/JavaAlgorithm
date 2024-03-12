import java.io.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B_10025 {

  static int N, K, pos_min = Integer.MAX_VALUE, pos_max = Integer.MIN_VALUE;
  static List<Ice> iceList = new ArrayList<>();
  static int lIdx = 0, rIdx = 0, listSize = 0, answer = 0, sum = 0;
  static boolean[] visit;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int p = Integer.parseInt(st.nextToken());
      iceList.add(new Ice(p, s));
      pos_max = Math.max(pos_max, p);
      pos_min = Math.min(pos_min, p);
    }
    Collections.sort(iceList);
    // System.out.println(iceList);
    listSize = iceList.size();
    visit = new boolean[listSize];
    for (int i = 1; i <= pos_max + K; i++) {
      cal(i);
    }
    System.out.println(answer);
  }

  // 2(2) 4(7) 5(1) 10(15)
  static void cal(int nowPos) {
    System.out.println("========cal========= nowPos "+nowPos);
    System.out.println("left");
    // 왼쪽 값 설정
    while (true) {

      if ((lIdx > listSize - 1) || (iceList.get(lIdx).pos <= nowPos - K) || (nowPos - K) < 0)
        break;
        System.out.println("lIdx "+lIdx+" lIdx.pos "+ iceList.get(lIdx).pos+" nowPos- K "+(nowPos - K) + " sum "+sum);

      // if (visit[lIdx])
      //   continue;
      lIdx += 1;
      sum -= iceList.get(lIdx).size;
      // visit[lIdx] = false;
    }

    System.out.println("right");
    // 오른쪽 값 설정
    while (true) {
      // System.out.println("rIdx "+rIdx+" rIdx.pos "+ iceList.get(rIdx).pos+" nowPos+ K "+(nowPos + K));
      //  System.out.println((rIdx > (listSize-1)) );
      if ((rIdx > (listSize - 1)) || ((nowPos + K) < iceList.get(rIdx).pos))
        break;

      sum += iceList.get(rIdx).size;
      System.out.println(" sum "+sum);
      rIdx += 1;
    }
    answer = Math.max(answer, sum);
    System.out.println("sum "+sum);

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

    // @Override
    // public String toString() {
    // return "Ice [pos=" + pos + ", size=" + size + "]";
    // }

  }
}
