package bronze;
import java.util.*;
import java.io.*;

public class B_3003 {
  
// class Main{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    int king = 1 - scan.nextInt();
    int queen = 1 - scan.nextInt();
    int luk = 2 - scan.nextInt();
    int vi = 2 - scan.nextInt();
    int nit = 2 - scan.nextInt();
    int pho = 8 - scan.nextInt();

    System.out.printf("%d %d %d %d %d %d", king, queen, luk, vi, nit, pho);
  }
}