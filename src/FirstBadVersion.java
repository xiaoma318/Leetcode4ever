public class FirstBadVersion {

  public static void main(String[] args) {
    System.out.println(Integer.MAX_VALUE);
  }

  public int firstBadVersion(int n) {
    int left = 1, right = n;
    while(left < right){
      int mid = left + (right - left) / 2;
      if(isBadVersion(mid)){
        right = mid;
      }else{
        left = mid+1;
      }
    }
    return right;
  }

  boolean isBadVersion(int version) {
    return true;
  }
}
