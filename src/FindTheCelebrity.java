import java.util.Arrays;

public class FindTheCelebrity {

  public static void main(String[] args) {
    System.out.println(add("23","89"));
    int[] nums = {1,2,3};
    nextPermutation(nums);
    System.out.println(Arrays.toString(nums));
  }

  /**
   * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may
   * exist one celebrity. The definition of a celebrity is that all the other n - 1 people know
   * him/her but he/she does not know any of them.
   *
   * Now you want to find out who the celebrity is or verify that there is not one. The only thing
   * you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of
   * whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as
   * few questions as possible (in the asymptotic sense).
   *
   * You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a
   * function int findCelebrity(n), your function should minimize the number of calls to knows.
   */
  public int findCelebrity(int n) {
    int celebrity = 0;
    for (int i = 1; i < n; i++) {
      if (knows(celebrity, i)) {
        celebrity = i;
      }
    }

    for (int i = 0; i < n; i++) {
      if (i == celebrity) {
        continue;
      }
      if (knows(celebrity, i) || !knows(i, celebrity)) {
        return -1;
      }
    }

    return celebrity;
  }

  boolean knows(int a, int b) {
    return true;
  }

  /*
Add two positive integers presented in string format

Input: a="23", b="89" Output: result="112"
*/

  public static String add(String a, String b){
    StringBuilder sb = new StringBuilder();
    int carry = 0;
    int i = a.length()-1; // 1, 0
    int j = b.length()-1; // 1, 0
    while(i >= 0 || j>= 0 || carry > 0){
      int sum = carry; // 1
      if(i>=0){
        sum += a.charAt(i) -'0'; // 3
        i--; // 0 -1
      }
      if(j>=0){
        sum += b.charAt(j) -'0'; // 11
        j--; // -1
      }
      sb.append(sum%10);
      carry = sum / 10;
    }
    return sb.reverse().toString();
  }


/*
Given a number you can create many permutations. Return the smallest permutation that is larger than the input value (that is, the next number re-using the same digits)
3152 =>3251=>3215
next_permutation(12) = 21
next_permutation(315) = 351
next_permutation(583) = 835 => 853=>835
next_permutation(12389) = 12398
next_permutation(34722641) = 34724126
*/

  public static void nextPermutation(int[] nums){
    int i = nums.length-2; //2 , 1
    while(i>=0){
      if(nums[i] < nums[i+1]){ // nums[i]:5,1    nums[i+1]:2,5
        break;
      }
      i--;
    }

    if(i == -1) {
      return;
    }

    int j = i+2; //3,4
    while(j < nums.length){
      if(nums[j] <= nums[i]){
        break;
      }
      j++;
    }

    int temp = nums[i];
    nums[i] = nums[j-1];
    nums[j-1] = temp;

    Arrays.sort(nums, i+1, nums.length);
  }
}
