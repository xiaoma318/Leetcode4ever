import java.util.Arrays;
import java.util.List;

public class SplitArray {

  public static void main(String[] args) {
    List<Integer> nums = Arrays
        .asList(1,2,3,1,2,3,1,2,3,1,2);
    //3, 2, 2, 3,
    // 2,
    // 1, 3, 3, 3,
    // -2,
    // 0, 3, 2, 1, 0, 3,1,
    // 0,
    // 1, 3, 0, 3, 3
    System.out.println(splitArray(nums));
   // System.out.println(split(nums, 3, 5, 10));
  }

  public static boolean splitArray(List<Integer> nums) {
    if (nums.size() < 6) {
      return false;
    }
    int sum = 0;
    dp=new Boolean[4][nums.size()+1];
    for (int i = 0; i < nums.size(); i++) {
      sum += nums.get(i);
      if (split(nums, 3, i + 2, sum)) {
        return true;
      }
    }
    return false;
  }

  static Boolean[][]dp ;

  static boolean split(List<Integer> nums, int k, int start, int sum) {
    if (k == 0) {
      return start==nums.size()+1;
    }
    if(start >= nums.size()) return false;
    if(dp[k][start] != null){
      return dp[k][start];
    }

    int s = 0;
    for (int i = start; i < nums.size(); i++) {
      s += nums.get(i);
      if (s == sum) {
        if (split(nums, k - 1, i + 2, sum)) {
          dp[k][start]=true;
          return true;
        }
      }
    }
    dp[k][start]=false;
    return false;
  }
}
