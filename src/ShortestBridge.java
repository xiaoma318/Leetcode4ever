import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class ShortestBridge {

  public static void main(String[] args) {
    // int[][] A = {{0,1,0,0,0},{0,1,0,1,1},{0,0,0,0,1},{0,0,0,0,0},{0,0,0,0,0}};
    int[][] A = {{0, 1}, {1, 0}};
    System.out.println(shortestBridge(A));
    for (int[] a : A) {
      System.out.println(Arrays.toString(a));
    }
  }

  static int shortestBridge(int[][] A) {
    int m = A.length;
    int n = A[0].length;
    boolean found = false;
    int[][] neighbors = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    Queue<int[]> q = new ArrayDeque<>();

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (A[i][j] == 1 && !found) {
          dfs(A, i, j);
          found = true;
        } else if (A[i][j] == 1 && found) {
          q.offer(new int[]{i, j});
        }
      }
    }

    int dist = 0;

    while (!q.isEmpty()) {
      int size = q.size();
      while (size-- > 0) {
        int[] pos = q.poll();

        for (int[] i : neighbors) {
          int y = pos[0] + i[0];
          int x = pos[1] + i[1];
          if (y >= m || y < 0 || x >= n || x < 0) {
            continue;
          }
          if (A[y][x] == 2) {
            return dist;
          }
          if (A[y][x] == 3) {
            continue;
          }
          A[y][x] = 3;
          q.offer(new int[]{y, x});
        }

        A[pos[0]][pos[1]] = 3;
      }
      dist++;
    }

    return -1;
  }

  static void dfs(int[][] A, int i, int j) {
    if (i == -1 || i == A.length || j == -1 || j == A[0].length || A[i][j] == 0 || A[i][j] == 2) {
      return;
    }
    A[i][j] = 2;
    dfs(A, i - 1, j);
    dfs(A, i + 1, j);
    dfs(A, i, j - 1);
    dfs(A, i, j + 1);
  }
}
