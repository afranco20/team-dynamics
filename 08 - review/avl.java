import java.util.Scanner;

public class avl {
  static boolean flag;

  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    int t = stdin.nextInt();

    Node root; int n;
    for (int i = 1; i <= t; i++) {
      n = stdin.nextInt();

      root = null;
      for (int j = 0; j < n; j++) {
        root = insert(root, stdin.nextInt());
      }

      if (flag) {
        System.out.printf("Tree #%d: REMOVE%n", i);
      } else {
        System.out.printf("Tree #%d: KEEP%n", i);
      }

      flag = false;
    }
  }

  static int getHeight(Node root) {
    return (root == null) ? -1 : root.height;
  }

  static Node insert(Node root, int data) {
    if (root == null) {
      return new Node(data);
    } else if (data < root.val) {
      root.left = insert(root.left, data);
    } else if (data > root.val) {
      root.right = insert(root.right, data);
    } else {
      return root;
    }

    root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
    balance(root);
    return root;
  }

  static void balance(Node root) {
    int bf = getHeight(root.left) - getHeight(root.right);
    if (bf > 1 || bf < -1) flag = true;
  }

  static class Node {
    final int val;
    int height;
    Node left;
    Node right;

    Node(int val) {
      this.val = val;
    }
  }
}
