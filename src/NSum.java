import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NSum {

  public static void main(String[] args) {
  }
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    for(int i=0;i<nums.length-2;i++){
      if(i>0 && nums[i] == nums[i-1]) continue;
      int left = i+1, right = nums.length-1;
      while(left < right){
        int sum = nums[i] + nums[left] + nums[right];
        if(sum == 0){
          List<Integer> list = Arrays.asList(nums[i], nums[left++], nums[right--]);
          res.add(list);
          while(left < right && nums[left] == nums[left-1]) left++;
          while(left < right && nums[right] == nums[right+1]) right--;
        }else if(sum > 0){
          right--;
        }else{
          left++;
        }
      }
    }
    return res;
  }
}
