package a_samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_21609_상어중학교 {
  static int N, M;
  static int[][] board;
  static int[] dy = { -1, 0, 1, 0 };
  static int[] dx = { 0, 1, 0, -1 };
  static List<List<int[]>> blockList;
  static int result = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    board = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    auto_play();
    System.out.print(result);

  }

  static void auto_play() {
    while (true) {
      // 블록 그룹 탐색
      find_block_group();
      if (blockList.size() == 0) {
        return;
      }
      find_block();

      // 선정된 블록 제거
      remove_block();
      // 중력 작용
      gravity_effect();
      // 반시계 방향 회전
      rotate_board();
      // 중력 작용
      gravity_effect();

    }
  }

  static void rotate_board() {
    int[][] newBoard = new int[N][N];
    for (int y = 0; y < N; y++) {
      for (int x = 0; x < N; x++) {
        newBoard[N - 1 - x][y] = board[y][x];
      }
    }
    for (int y = 0; y < N; y++) {
      board[y] = newBoard[y].clone();
    }

  }

  static void gravity_effect() {

    for (int x = 0; N > x; x++) {
      int emptySpace = -3;
      for (int y = N - 1; y >= 0; y--) {
        if (board[y][x] == -2 && emptySpace == -3) {
          emptySpace = y;
          continue;
        }
        if (board[y][x] == -1) {
          emptySpace = -3;
          continue;
        }

        if (board[y][x] >= 0 && emptySpace != -3 && board[emptySpace][x] == -2) {
          board[emptySpace][x] = board[y][x];
          board[y][x] = -2;
          emptySpace -= 1;
        }
      }
    }

  }

  static void remove_block() {
    int cnt = 0;

    for (int[] b : blockList.get(0)) {
      if (b[0] != -1) {
        board[b[0]][b[1]] = -2;
        cnt += 1;
      }
    }
    result += Math.pow(cnt, 2);
  }

  static void find_block() {

    // 블록 그룹 정렬
    // 1. 크기가 가장 큰 블록 (크기가 2보다 커야함)
    // 2. 무지개 블록이 많은 블록
    // 3. 기준 행이 큰 블록 그룹
    // 4. 기준 열이 큰 블록 그룹
    Collections.sort(blockList,
        (b1, b2) -> (b1.size() == b2.size()) ? (b1.get(0)[1] == b2.get(0)[1]
            ? ((b1.get(1)[0] == b2.get(1)[0]) ? (b2.get(1)[1] - b1.get(1)[1]) : b2.get(1)[0] - b1.get(1)[0])
            : b2.get(0)[1] - b1.get(0)[1]) : b2.size() - b1.size());
    int maxBlockSize = blockList.get(0).size();

  }

  static void find_block_group() {
    boolean[][] visit = new boolean[N][N];
    blockList = new ArrayList<>(); // block들을 담을 arraylist
    List<int[]> tmpList;
    int idx = 0;
    boolean[][] zero_visit = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visit[i][j] && board[i][j] > 0) {
          for (int k = 0; k < N; k++) {
            Arrays.fill(zero_visit[k], false);
          }

          tmpList = new ArrayList<>();
          Queue<int[]> queue = new ArrayDeque<>();
          queue.offer(new int[] { i, j });
          tmpList.add(new int[] { i, j });
          visit[i][j] = true;

          int zeroCnt = 0;
          int color = board[i][j];

          while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cy = current[0];
            int cx = current[1];

            for (int k = 0; k < 4; k++) {
              int yy = cy + dy[k];
              int xx = cx + dx[k];

              if (yy < 0 || xx < 0 || yy >= N || xx >= N)
                continue;

              if (board[yy][xx] == -2) // 제거한 블
                continue;
              if (board[yy][xx] == -1) // 검은색 블록
                continue;
              else if (board[yy][xx] == 0 && !zero_visit[yy][xx]) { // 무지개 블록, visit한 무지개 블록이여도 됨.
                queue.offer(new int[] { yy, xx });
                zero_visit[yy][xx] = true;
                tmpList.add(new int[] { yy, xx });
                zeroCnt += 1;
                continue;
              }

              if (board[yy][xx] == color && !visit[yy][xx]) { // 같은 색의 일반블록이면서 방문하지 않은 것
                queue.offer(new int[] { yy, xx });
                visit[yy][xx] = true;
                tmpList.add(new int[] { yy, xx });

                continue;
              }

            }

          }
          int cnt = 0;
          if (tmpList.size() > 1) {
            // zero 갯수 (cnt, -1)
            tmpList.add(new int[] { -1, zeroCnt });
            // 가장 앞에 있는 것이 기준 블록 (작은 행 -> 작은 열)
            Collections.sort(tmpList, (item1,
                item2) -> (item1[0] - item2[0] == 0 ? (item1[1] - item2[1]) : item1[0] - item2[0]));
            for (int w = tmpList.size() - 1; w > 0; w--) { // idx =0 에 기준블록을 둘건데, 무지개 블록은 맨 뒤로 빼기 위한 반복문
              if (board[tmpList.get(w)[0]][tmpList.get(w)[1]] == 0) {
                tmpList.add(tmpList.remove(w));
              }
            }

            blockList.add(tmpList);
            idx += 1;
          }

        }
      }
    }

  }
}
