import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_24042 {

  static int N, M;
  static int[][][] crossIntervals;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 지역 수
    M = Integer.parseInt(st.nextToken()); // 횡단보도 주기

    crossIntervals = new int[M][2][2];
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());

      crossIntervals[i][0] = new int[] { s, e };
      crossIntervals[i][1] = new int[] { e, s };
    }

    // for (int index = 0; index < M; index++) {
    //   System.out.println(Arrays.toString(crossIntervals[index][0]));
    //   System.out.println(Arrays.toString(crossIntervals[index][1]));
    // }
    int time = 0;

    ArrayList<ArrayList<int[]>> check = new ArrayList<>();
    check.add(new ArrayList<int[]>());
    check.get(0).add(new int[] { 1, 0 }); // 위치, Cnt
System.out.println(check.get(time).size());
System.out.println(check.get(time).get(0)[0]+" "+crossIntervals[time % M][0][0]+" "+crossIntervals[time % M][0][1]);

    while (time != 3) {
      int listSize = check.get(time).size();
     
      check.add(new ArrayList<int[]>());
      for (int i = 0; i < listSize; i++) {
        int nowN = check.get(time).get(i)[0];
        int nowCnt = check.get(time).get(i)[1];
System.out.println(nowN+" "+nowCnt);
        if(nowN==N){
          System.out.println(nowCnt);
          return;
        }
        if (crossIntervals[time % M][0][0] == nowN) {
          check.get(time+1).add(new int[] { crossIntervals[(time) % M][0][1], nowCnt+1 });
        }

        if (crossIntervals[time % M][1][0] == nowN) {
          check.get(time+1).add(new int[] { crossIntervals[(time) % M][1][1], nowCnt+1 });
        }
      
      }
     
      time += 1;
      for (int i = 0; i < check.size(); i++) {
        System.out.println(i+" ====");
        for (int j = 0; j < check.get(i).size(); j++) {
          System.out.print(Arrays.toString(check.get(i).get(j)) +" ");
        }
        System.out.println();
      }
      
    }
  }
}