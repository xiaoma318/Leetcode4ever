import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BinaryTreeVerticalOrderTraversal {

  public static void main(String[] args) {
    TreeNode n1 = new TreeNode(1);
    n1.left = new TreeNode(2);
    n1.right = new TreeNode(3);
    n1.left.right = new TreeNode(4);
    System.out.println(verticalOrder(n1));
  }

  //Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
  public static List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int[] bound = new int[2];
    helper(root, map, 0, bound);
    for (int i = bound[0]; i <= bound[1]; i++) {
      res.add(map.get(i));
    }
    return res;
  }

  static void helper(TreeNode root, HashMap<Integer, List<Integer>> map, int index, int[] bound) {
    if (root == null) {
      return;
    }
    if (!map.containsKey(index)) {
      List<Integer> list = new ArrayList<>();
      list.add(root.val);
      map.put(index, list);
    } else {
      map.get(index).add(root.val);
    }
    bound[0] = Math.min(index, bound[0]);
    bound[1] = Math.max(index, bound[1]);
    helper(root.left, map, index - 1, bound);
    helper(root.right, map, index + 1, bound);
  }
}
