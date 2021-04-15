import javax.swing.*;

class BST {
    private Node root;
    private boolean check;
    class Node {
        int val;
        Node left, right;

        public Node(int value) {
            val = value;
            left = null;
            right = null;
        }
    }


    public BST(int rootValue) {
        root = new Node(rootValue);
    }
    
    private Node insert(Node root, int value) {


        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.val)
            root.left = insert(root.left, value);
        else if (value > root.val)
            root.right = insert(root.right, value);

        return root;
    }

    void inorderTraversal(Node root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    void preorderTraversal(Node root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    void postorderTraversal(Node root) {
        if (root == null)
            return;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    private boolean search(Node root, int n) {

    if (root == null) return false;
    if (root.val == n) return true;
    if (root.val > n) return search(root.left, n);
    return search(root.right, n);
}

    public static void main(String[] args) {
        //create tree with a root of 5
        BST tree = new BST(5);
        boolean check = false;

        tree.insert(tree.root, 2);
        tree.insert(tree.root, 7);
        tree.insert(tree.root, 10);
        tree.insert(tree.root, 4);
        tree.insert(tree.root, 1);

        //start traversal at root
        System.out.println("Inorder Traversal: ");
        tree.inorderTraversal(tree.root);
        System.out.println("");
        System.out.println("Preorder Traversal: ");
        tree.preorderTraversal(tree.root);
        System.out.println("");
        System.out.println("Postorder Traversal: ");
        tree.postorderTraversal(tree.root);

        int reply = JOptionPane.showConfirmDialog(null, "Would you like to Search for a specific number?", "Number Search?", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            String n = JOptionPane.showInputDialog("Please enter a number");
             if (tree.search(tree.root, Integer.parseInt(n))){

                  check = true;


                 JOptionPane.showMessageDialog(null,( Integer.parseInt(n) + " Was found in the tree."));
             }
            if (!check){

                 JOptionPane.showMessageDialog(null,( Integer.parseInt(n) + " Was not found in the tree."));
            }

             }


         else {
            JOptionPane.showMessageDialog(null, "Thanks for using my program.");
            System.exit(0);
        }


    }

}
