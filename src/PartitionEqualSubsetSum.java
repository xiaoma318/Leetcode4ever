import java.util.Arrays;

public class PartitionEqualSubsetSum {

  public static void main(String[] args) {
    int[] nums ={10, 1, 9};
    System.out.println(canPartition(nums));
  }
  public static boolean canPartition(int[] nums) {
    int sum = 0;

    for (int num : nums) {
      sum += num;
    }

    if ((sum & 1) == 1) {
      return false;
    }
    sum /= 2;

    int n = nums.length;
    boolean[][] dp = new boolean[n+1][sum+1];
    for (int i = 0; i <= n; i++) {
      dp[i][0] = true;
    }

    for (int i = 1; i < n+1; i++) {
      for (int j = nums[i-1]; j < sum+1; j++) {
        dp[i][j] = dp[i-1][j];
        //if (j >= nums[i-1]) {
          dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
        //}
      }
    }
    for(int i=0;i<=n;i++){
      System.out.println(Arrays.toString(dp[i]));
    }


    return dp[n][sum];
  }
}
