import java.util.ArrayList;
import java.util.List;

public class NQueens {

  public static void main(String[] args) {
    System.out.println(solveNQueens(4));
    List<int[]> list = new ArrayList<>();
    list.add(new int[]{1, 2});
    int[][] arr = list.toArray(new int[0][0]);
  }
  static List<List<String>> solveNQueens(int n) {
    List<List<String>> res = new ArrayList<>();
    int[] rows = new int[n];
    place(0, n, rows, res);
    return res;
  }

  static void place(int row, int n, int[] rows, List<List<String>> res){
    if(row==n){
      List<String> list = new ArrayList<>();
      for(int i=0;i<rows.length;i++){
        StringBuilder sb = new StringBuilder();
        for(int j=0;j<n;j++){
          if(rows[i] == j){
            sb.append('Q');
          }else{
            sb.append('.');
          }
        }
        list.add(sb.toString());
      }
      res.add(list);
      return;
    }
    for(int i=0;i<n;i++){
      int j;
      for(j=0;j<row;j++){
        if(rows[j] == i || Math.abs(i-rows[j]) == row - j) {
          break;
        }
      }
      if(j==row){
        rows[row] = i;
        place(row+1, n, rows, res);
      }
    }
  }
}
