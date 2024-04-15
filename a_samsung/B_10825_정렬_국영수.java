package a_samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_10825_정렬_국영수 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st;

    ArrayList<student> students = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      int ko = Integer.parseInt(st.nextToken());
      int en = Integer.parseInt(st.nextToken());
      int math = Integer.parseInt(st.nextToken());

      students.add(new student(name, ko, en, math));
    }
    Collections.sort(students);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      sb.append(students.get(i).name).append("\n");
    }
    System.out.println(sb);
  }

  static class student implements Comparable<student> {

    String name;
    int ko;
    int en;
    int math;

    student(String name, int ko, int en, int math) {
      this.name = name;
      this.ko = ko;
      this.en = en;
      this.math = math;
    }

    @Override
    public int compareTo(student o) {
      if (this.ko == o.ko) {
        if (this.en == o.en) {
          if (this.math == o.math) {
            return this.name.compareTo(o.name);
          } else {
            return o.math - this.math;
          }
        } else {
          return this.en - o.en;
        }
      } else {
        return o.ko - this.ko;
      }
    }

    @Override
    public String toString() {
      return "student [name=" + name + ", ko=" + ko + ", en=" + en + ", math=" + math + "]";
    }

  }
}
