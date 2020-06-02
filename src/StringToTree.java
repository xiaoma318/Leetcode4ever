public class StringToTree {

  public static void main(String[] args) {
    String s = "-4(2(3)(1))(6(5)(7))";
    str2tree(s);
  }

  public static TreeNode str2tree(String s) {
    if (s == null || s.isEmpty()) {
      return null;
    }
    int i = 0;
    int count = 0;
    while (i < s.length() && s.charAt(i) != '(') {
      i++;
    }
    int left = i;
    TreeNode root = new TreeNode(Integer.parseInt(s.substring(0, i)));
    while (i < s.length()) {
      char c = s.charAt(i);
      if (c == '(') {
        count++;
      } else if (c == ')') {
        count--;
      }
      if (count == 0) {
        break;
      }
      i++;
    }
    int right = i;
    if (left + 1 < right) {
      root.left = str2tree(s.substring(left + 1, right));
    }
    if (right + 2 < s.length() - 1) {
      root.right = str2tree(s.substring(right + 2, s.length() - 1));
    }
    return root;
  }
}
