package now;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


public class test {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine());
    String [] now;
    int num = 0;
    Deque<Integer> deque1 = new ArrayDeque<>();
    for(int i = 0 ; i < n ; i++){
      
      now = bf.readLine().split(" ");
      if (Integer.parseInt(now[0]) == 1){
        num = Integer.parseInt(now[1]);
        deque1.addFirst(num);
      }else if(Integer.parseInt(now[0]) == 2){
        num = Integer.parseInt(now[1]);
        deque1.addLast(num);
      }else if(Integer.parseInt(now[0]) == 3){
        if(deque1.size() == 0){
          System.out.println(-1);
        }else{
          System.out.println(deque1.removeFirst());
        }
      }else if(Integer.parseInt(now[0]) == 4){ 
        if(deque1.size() == 0){
          System.out.println(-1);
        }else{
          System.out.println(deque1.pollLast());
        }
      }else if(Integer.parseInt(now[0]) == 5){
        System.out.println(deque1.size());
      }else if(Integer.parseInt(now[0]) == 6){
        if(deque1.size() == 0){
          System.out.println(1);
        }else{
          System.out.println(0);
        }
      }else if(Integer.parseInt(now[0]) == 7){
        if(deque1.size() == 0){
          System.out.println(-1);
        }else{
          System.out.println(deque1.getFirst());
        }
      }else{
        if(deque1.size() == 0){
          System.out.println(-1);
        }else{
          System.out.println(deque1.getLast());
        }
      }
    }
  }
}
