import java.util.ArrayDeque;
import java.util.Queue;

public class WallsAndGates {

  public static void main(String[] args) {
    int x = 1;
    int y = -x * 3;
  }

  /**
   * You are given a m x n 2D grid initialized with these three possible values.
   *
   * -1 - A wall or an obstacle. 0 - A gate. INF - Infinity means an empty room. We use the value
   * 2^31 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less
   * than 2147483647. Fill each empty room with the distance to its nearest gate. If it is
   * impossible to reach a Gate, that room should remain filled with INF
   *
   * e.g:
   * INF  -1  0  INF
   * INF INF INF  -1
   * INF  -1 INF  -1
   *   0  -1 INF INF
   * the answer is:
   *   3  -1   0   1
   *   2   2   1  -1
   *   1  -1   2  -1
   *   0  -1   3   4
   */
  public static void wallsAndGates(int[][] rooms) {
    for (int i = 0; i < rooms.length; i++) {
      for (int j = 0; j < rooms[0].length; j++) {
        if (rooms[i][j] == 0) {
          dfs(rooms, i - 1, j, 1);
          dfs(rooms, i + 1, j, 1);
          dfs(rooms, i, j - 1, 1);
          dfs(rooms, i, j + 1, 1);
        }
      }
    }
  }

  static void dfs(int[][] rooms, int row, int col, int distance) {
    if (row < 0 || row >= rooms.length || col < 0 || col >= rooms[0].length) {
      return;
    }
    if (rooms[row][col] == -1 || rooms[row][col] <= distance) {
      return;
    }
    rooms[row][col] = distance;
    dfs(rooms, row + 1, col, distance + 1);
    dfs(rooms, row - 1, col, distance + 1);
    dfs(rooms, row, col + 1, distance + 1);
    dfs(rooms, row, col - 1, distance + 1);
  }

  public static void wallsAndGatesBFS(int[][] rooms) {
    if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
      return;
    }

    int m = rooms.length;
    int n = rooms[0].length;

    Queue<Integer> queue = new ArrayDeque<>();

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (rooms[i][j] == 0) {
          queue.add(i * n + j);
        }
      }
    }

    while (!queue.isEmpty()) {
      int head = queue.poll();
      int x = head / n;
      int y = head % n;

      if (x > 0 && rooms[x - 1][y] == Integer.MAX_VALUE) {
        rooms[x - 1][y] = rooms[x][y] + 1;
        queue.add((x - 1) * n + y);
      }

      if (x < m - 1 && rooms[x + 1][y] == Integer.MAX_VALUE) {
        rooms[x + 1][y] = rooms[x][y] + 1;
        queue.add((x + 1) * n + y);
      }

      if (y > 0 && rooms[x][y - 1] == Integer.MAX_VALUE) {
        rooms[x][y - 1] = rooms[x][y] + 1;
        queue.add(x * n + y - 1);
      }

      if (y < n - 1 && rooms[x][y + 1] == Integer.MAX_VALUE) {
        rooms[x][y + 1] = rooms[x][y] + 1;
        queue.add(x * n + y + 1);
      }
    }
  }
}
