package bronze;



import java.util.*;
import java.io.*;

class B_17256 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a_x = Integer.parseInt(st.nextToken());
        int a_y = Integer.parseInt(st.nextToken());
        int a_z = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int c_x = Integer.parseInt(st.nextToken());
        int c_y = Integer.parseInt(st.nextToken());
        int c_z = Integer.parseInt(st.nextToken());

        sb.append(c_x - a_z).append(" ");
        sb.append(c_y / a_y).append(" ");
        sb.append(c_z - a_x);
        System.out.println(sb);
    }
    
}
}
