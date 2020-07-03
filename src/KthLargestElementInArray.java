import java.util.Random;

public class KthLargestElementInArray {

  public static void main(String[] args) {
    int[] a = {3,2,1,5,6,4,2};
    int x = findKthLargest(a, 1);
    System.out.println(x);
  }
  public static int findKthLargest(int[] nums, int k) {
    shuffle(nums);
    return Sort.quickSelect(nums, nums.length - k);
  }

  static void shuffle(int[] nums){
    Random random = new Random();
    for(int i=nums.length-1;i>0;i--){
      int j = random.nextInt(i+1);
      Sort.swap(nums, i, j);
    }
  }
}
