import java.util.Arrays;

public class SetZeros {

  public static void main(String[] args) {
    int[][] matrix = {{1,0,3}};
    setZeroes(matrix);

    for(int[] m:matrix){
      System.out.println(Arrays.toString(m));
    }
  }
  static void setZeroes(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    boolean row=false, col=false;
    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
        if(matrix[i][j] == 0){
          matrix[i][0] = 0;
          matrix[0][j] = 0;
          if(i==0) row=true;
          if(j==0) col=true;
        }
      }
    }

    for(int i=1;i<m;i++){
      for(int j=1;j<n;j++){
        if(matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    if(col){
      for(int i=0;i<m;i++){
        matrix[i][0]=0;
      }
    }
    if(row){
      for(int j=0;j<n;j++){
        matrix[0][j]=0;
      }
    }
  }
}
