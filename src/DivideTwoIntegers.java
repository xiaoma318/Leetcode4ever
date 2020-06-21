public class DivideTwoIntegers {

  public static void main(String[] args) {
    //System.out.println(divide(-2147483648 ,-1));
    System.out.println((1 & 1));
  }
  public static int divide(int dividend, int divisor) {
    long dividendAbs = dividend;
    long divisorAbs = divisor;
    dividendAbs = Math.abs(dividendAbs);
    divisorAbs = Math.abs(divisorAbs);
    long res=0;
    while(dividendAbs - divisorAbs >= 0){
      long d = divisorAbs;
      int r = 1;
      while(dividendAbs - d >= 0){
        res += r;
        dividendAbs -= d;
        d+=d;
        r+=r;
      }
    }
    boolean isPositive = (dividend ^ divisor) >= 0;

    if(isPositive) {
      if(res > Integer.MAX_VALUE) res = Integer.MAX_VALUE;
    }else {
      if(res < Integer.MIN_VALUE) res = Integer.MIN_VALUE;
      else res = -res;
    }
    return (int) res;
  }
}
