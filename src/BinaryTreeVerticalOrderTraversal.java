import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BinaryTreeVerticalOrderTraversal {

  public static void main(String[] args) {
    TreeNode n1 = new TreeNode(1);
    n1.left = new TreeNode(2);
    n1.right = new TreeNode(3);
    n1.left.right = new TreeNode(4);
    long d1 = System.currentTimeMillis();
    for(int i=0;i<100;i++)
    verticalOrder2(n1);
    long d2 = System.currentTimeMillis();
    for(int i=0;i<100;i++)
    verticalOrder(n1);
    long d4 = System.currentTimeMillis();

    System.out.println(d2-d1);
    System.out.println(d4-d2);

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

  public static List<List<Integer>> verticalOrder2(TreeNode root) {
    Queue<TreeNode> queue = new ArrayDeque<>();
    Queue<Integer> index = new ArrayDeque<>();
    Map<Integer, List<Integer>> map = new TreeMap<>();
    queue.offer(root);
    index.offer(0);
    while (!queue.isEmpty()) {
      TreeNode curr = queue.poll();
      int currIndex = index.poll();
      map.putIfAbsent(currIndex, new ArrayList<>());
      map.get(currIndex).add(curr.val);
      if (curr.left != null) {
        queue.offer(curr.left);
        index.offer(currIndex - 1);
      }
      if (curr.right != null) {
        queue.offer(curr.right);
        index.offer((currIndex + 1));
      }

    }
    return new ArrayList<>(map.values());
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

  static Collection<Integer> getList() {
    return new LinkedList<>();
  }
}
