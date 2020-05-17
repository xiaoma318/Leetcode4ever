import java.util.HashMap;

public class SubarraySumEqualsToK {

  /**
   * Leetcode 560: https://leetcode.com/problems/subarray-sum-equals-k/
   *
   * Given an array of integers and an integer k, you need to find the total number of continuous
   * subarrays whose sum equals to k.
   *
   * Example 1:
   * Input:nums = [1,1,1], k = 2 Output: 2
   */
  public int subarraySum(int[] nums, int k) {
    int count = 0;
    int sum = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    for (int x : nums) {
      sum += x;
      if (map.containsKey(sum - k)) {
        count += map.get(sum - k);
      }
      if (map.containsKey(sum)) {
        map.put(sum, map.get(sum) + 1);
      } else {
        map.put(sum, 1);
      }
    }
    return count;
  }
}
