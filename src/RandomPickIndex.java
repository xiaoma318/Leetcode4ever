import java.util.Random;

public class RandomPickIndex {

  int[] nums;
  Random rnd;

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 3, 3};
    RandomPickIndex randomPickIndex = new RandomPickIndex(nums);
    System.out.println(randomPickIndex.pick(3));
  }

  public RandomPickIndex(int[] nums) {
    this.nums = nums;
    this.rnd = new Random();
  }

  public int pick(int target) {
    int res = -1;
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        if (rnd.nextInt(++count) == 0) {
          res = i;
        }
      }
    }
    return res;
  }
}
