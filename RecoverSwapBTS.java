package tree;

public class RecoverSwapBTS {

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // To store swapped nodes
    static Node first = null;
    static Node second = null;
    static Node prev = null;

    

    // Find swapped nodes
    static void recoverBST(Node root) {

        if (root == null) {
            return;
        }

        // Left
        recoverBST(root.left);

        // Current
        if (prev != null && prev.data > root.data) {

            if (first == null) {
                first = prev;
            }

            second = root;
        }

        prev = root;

        // Right
        recoverBST(root.right);
    }
 // Inorder traversal
    static void inorder(Node root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        System.out.print(root.data + " ");

        inorder(root.right);
    }

    public static void main(String[] args) {

        /*
                 40
                /  \
              60    20
             / \    / \
            10 30  50 70

            20 and 60 are swapped
        */

        Node root = new Node(40);

        root.left = new Node(60);
        root.right = new Node(20);

        root.left.left = new Node(10);
        root.left.right = new Node(30);

        root.right.left = new Node(50);
        root.right.right = new Node(70);

        System.out.println("Before Recovery:");

        inorder(root);

        System.out.println();

        // Find swapped nodes
        recoverBST(root);

        // Swap their values
        int temp = first.data;
        first.data = second.data;
        second.data = temp;

        System.out.println("After Recovery:");

        inorder(root);
    }
}