import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ValidIpAddress {

  public static void main(String[] args) {
    System.out.println(validIPAddress("172.16.254.1"));
    System.out.println("1".matches("(0|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])"));

    Map<Integer, Integer> map = new HashMap<>();
  }

  public static String validIPAddress(String IP) {
    if (isV4Regex(IP)) {
      return "IPv4";
    }
    if (isV6(IP)) {
      return "IPv6";
    }
    return "Neither";
  }

  static boolean isV4(String ip) {
    if (ip.charAt(ip.length() - 1) == '.') {
      return false;
    }
    String[] arr = ip.split("\\.");
    if (arr.length != 4) {
      return false;
    }
    for (String s : arr) {
      if (s.length() > 1 && s.charAt(0) == '0') {
        return false;
      }
      if (!s.matches("\\d+")) {
        return false;
      }
      int value = Integer.parseInt(s);
      if (value > 255) {
        return false;
      }
    }
    return true;
  }

  static boolean isV4Regex(String ip) {
    return ip.matches(
        "(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])");
  }


  static boolean isV6(String ip) {
    return ip.matches("([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}");
  }
}
