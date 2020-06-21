public class SerializeAndDeserializeBST {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    String s = serialize(root);
    System.out.println(s);
    TreeNode n = deserialize(s);
    TreeNode.print(n);
  }
  static String serialize(TreeNode root) {
    if(root==null) return "#,";
    return root.val+","+serialize(root.left)+serialize(root.right);
  }

  static String serialize2(TreeNode root) {
    if(root==null) return "#,";
    return root.val+","+serialize2(root.left)+serialize2(root.right);
  }

  // Decodes your encoded data to tree.
  static TreeNode deserialize(String data) {
    int[] start = {0};
    return deserialize(data, start);
  }

  static TreeNode deserialize(String data, int[] start) {
    if(data==null || start[0] == data.length()) return null;
    int idx = data.indexOf(",", start[0]);
    String str = data.substring(start[0], idx);
    start[0] = idx+1;
    if(str.equals("#")) return null;
    TreeNode node = new TreeNode(Integer.parseInt(str));

    node.left = deserialize(data, start);
    //start[0] = start[0] + 1;
    node.right = deserialize(data, start);
    return node;
  }
}
