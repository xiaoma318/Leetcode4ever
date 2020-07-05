import java.util.Arrays;

public class TransformSortedArray {

  public static void main(String[] args) {
    int[] nums = {-4, -2, 2, 4};
    int[] output = sortTransformedArray(nums, 1, 3, 5);
    System.out.println(Arrays.toString(output));
  }

  public static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
    // Write your code here
    int n = nums.length;
    int[] arr = new int[n];
    if (a == 0) {
      if (b >= 0) {
        for (int i = 0; i < n; i++) {
          arr[i] = b * nums[i] + c;
        }
      } else {
        for (int i = 0; i < n; i++) {
          arr[n - 1 - i] = b * nums[i] + c;
        }
      }
      return arr;
    }
    if (a > 0) {
      int left = 0, right = n - 1;
      for (int i = n - 1; i >= 0; i--) {
        int transLeft = cal(a, b, c, nums[left]);
        int transRight = cal(a, b, c, nums[right]);
        if (transLeft >= transRight) {
          arr[i] = transLeft;
          left++;
        } else {
          arr[i] = transRight;
          right--;
        }
      }
    } else {
      int left = 0, right = n - 1;
      for (int i = 0; i < n; i++) {
        int transLeft = cal(a, b, c, nums[left]);
        int transRight = cal(a, b, c, nums[right]);
        if (transLeft <= transRight) {
          arr[i] = transLeft;
          left++;
        } else {
          arr[i] = transRight;
          right--;
        }
      }
    }
    return arr;
  }

  static int cal(int a, int b, int c, int x) {
    return a * x * x + b * x + c;
  }
}
