public class ValidNumber {

  public static void main(String[] args) {
    System.out.println(isNumber(".1"));
  }
  public static boolean isNumber(String s) {
    String regex = "[-+]?((\\d*\\.?\\d+)|(\\d+\\.?\\d*))(e[-+]?\\d+)?";

    return s.matches(regex);
  }
}
