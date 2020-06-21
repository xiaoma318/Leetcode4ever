import java.util.ArrayList;
import java.util.List;

class WordDictionary {

  static class Node {

    char c;
    List<Node> edges;
    boolean isWord;

    Node(char c) {
      this.c = c;
      edges = new ArrayList<>();
    }
  }

  public static void main(String[] args) {
    WordDictionary wordDictionary = new WordDictionary();
    wordDictionary.addWord("bad");
    wordDictionary.addWord("dad");
    wordDictionary.addWord("mad");
    System.out.println(wordDictionary.search(".ad"));
  }

  Node root;

  /**
   * Initialize your data structure here.
   */
  public WordDictionary() {
    root = new Node(' ');
  }

  /**
   * Adds a word into the data structure.
   */
  public void addWord(String word) {
    Node node = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      boolean existed = false;
      for (Node n : node.edges) {
        if (c == n.c) {
          node = n;
          existed = true;
          break;
        }
      }
      if (!existed) {
        Node newNode = new Node(c);
        node.edges.add(newNode);
        node = newNode;
      }
    }
    node.isWord=true;
  }

  /**
   * Returns if the word is in the data structure. A word could contain the dot character '.' to
   * represent any one letter.
   */
  public boolean search(String word) {
    return find(root, word, 0);

  }

  boolean find(Node root, String word, int index) {
    for (int i = index; i < word.length(); i++) {
      char c = word.charAt(i);
      if (c == '.') {
        for (Node n : root.edges) {
          if (find(n, word, i + 1)) {
            return true;
          }
        }
        return false;
      } else {
        boolean existed = false;
        for (Node n : root.edges) {
          if (c == n.c) {
            root = n;
            existed = true;
            break;
          }
        }
        if (!existed) {
          return false;
        }
      }
    }
    return root.isWord;
  }
}
