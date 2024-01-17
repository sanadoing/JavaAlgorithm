package bronze;
import java.util.*;
import java.io.*;

class Main{
  public static void main(String[] args)throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int cnt = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i <cnt; i++){
      String s = br.readLine();
      String[] sa = s.split(" ");

      for (int j = 2; j < sa.length; j++){
        sb.append(sa[j]+" ");
      }
      sb.append(sa[0]+" ");
      sb.append(sa[1]+'\n');
      
    }

    System.out.println(sb);
  }
}