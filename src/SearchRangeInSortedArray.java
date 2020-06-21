import java.util.Arrays;

public class SearchRangeInSortedArray {

  public static void main(String[] args) {
    // int[] nums = {5,7,7,8,8,10};
    int[] nums = {2, 2};
   System.out.println(Arrays.toString(searchRange(nums, 2)));
  }
  public static int[] searchRange(int[] nums, int target) {
    int[] ans = {-1, -1};
    int left = firstGreaterOrEqual(nums, target, 0, nums.length);
    if(left >= nums.length || nums[left] != target) {
      return ans;
    }

    int right = firstGreaterOrEqual(nums, target+1, left, nums.length);
    ans[0] = left;
    ans[1] = right -1 ;
    return ans;
  }

  static int firstGreaterOrEqual(int[] nums, int target, int left, int right) {
    while (left < right) {
      int mid = (left + right) / 2;
      if (nums[mid] >= target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    System.out.println("left: " + left);
    return left;
  }
}
