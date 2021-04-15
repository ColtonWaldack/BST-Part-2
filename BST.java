class BST {
	private Node root; 
    //Basic Node definition. Each Node contains a Value, a left child, and a right child
    class Node { 
        int val; 
        Node left, right; 
  
        public Node(int value) { 
        	val = value; 
            left =null;
            right = null; 
        } 
    } 
  
  
    public BST(int rootValue) {  
        root = new Node(rootValue);  
    } 
  
    //insert Value into the appropriate spot in the tree
    private Node insert(Node root,int value) { 
  

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
  
 
    //finish code to print all values with an inorder traversal
    void inorderTraversal(Node root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
        }

    void preorderTraversal(Node root)
    {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
    void postorderTraversal(Node root)
    {
        if (root == null)
            return;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.val + " ");
    }

  
    public static void main(String[] args) { 
    	//create tree with a root of 5
        BST tree = new BST(5);   
      
        tree.insert(tree.root,2); 
        tree.insert(tree.root,7); 
        tree.insert(tree.root,10);
        tree.insert(tree.root,4); 
        tree.insert(tree.root,1);

        //start traversal at root
       System.out.println("Inorder Traversal: " ); tree.inorderTraversal(tree.root);
       System.out.println("");
       System.out.println("Preorder Traversal: " ); tree.preorderTraversal(tree.root);
       System.out.println("");
       System.out.println("Postorder Traversal: " ); tree.postorderTraversal(tree.root);
    } 
}
