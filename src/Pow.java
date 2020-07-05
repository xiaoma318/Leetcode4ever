public class Pow {

  public static void main(String[] args) {
    System.out.println(myPow(34.00515, -3));
  }
  public static double myPow(double x, int n) {
    if(n==0) return 1;
    if(n==1) return x;
    if(n==-1) return 1/x;
    double res = myPow(x*x, n/2);
    if(n % 2 != 0){
      res = n > 0 ? res * x : res/x;
    }

    return res;
  }
}
