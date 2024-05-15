package BinaryTree;
import TreeNodes.IntTreeNode;


public class IntSearchTree {
    private IntTreeNode overallRoot;

    // constructs an empty tree
    public IntSearchTree() {
        overallRoot = null;
    }

    // value is added to overall tree so as to preserve the
    // binary search tree property
    public void add(int value) {
        overallRoot = add(overallRoot, value);
    }

    // value is added to given tree so as to preserve the
    // binary search tree property
    private IntTreeNode add(IntTreeNode root, int value) {
        if (root == null) {
            root = new IntTreeNode(value);
        } else if (value <= root.data) {
            root.left = add(root.left, value);
        } else {
            root.right = add(root.right, value);
        }
        return root;
    }

    public IntTreeNode search(int value) {
        return search(overallRoot, value);
    }   

    // returns true if given tree contains value
    private IntTreeNode search(IntTreeNode root, int value) {
        if (root == null) {
            return null;
        } else if (value == root.data) {
            return root;
        } else if (value < root.data) {
            return search(root.left, value);
        } else {  // value > root.data
            return search(root.right, value);
        }
    }

    // returns true if overall tree contains value
    public boolean contains(int value) {
        return contains(overallRoot, value);
    }   

    // returns true if given tree contains value
    private boolean contains(IntTreeNode root, int value) {
        if (root == null) {
            return false;
        } else if (value == root.data) {
            return true;
        } else if (value < root.data) {
            return contains(root.left, value);
        } else {  // value > root.data
            return contains(root.right, value);
        }
    }


    // prints the tree contents using an inorder traversal
    public void printInOrder() {
        printInOrder(overallRoot);
        System.out.println();
    }

    // prints contents of the tree with given root using an
    // inorder traversal
    private void printInOrder(IntTreeNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.data + " " );
            printInOrder(root.right);
        }
    }

    // root left right
    public void printPreOrder()  {
        printPreOrder(overallRoot);
        System.out.println();
    }

    private void printPreOrder(IntTreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            printPreOrder(root.left);
            printPreOrder(root.right);
        }
    }

    // left right root
    public void printPostOrder()  {
        printPostOrder(overallRoot);
        System.out.println();
    }

    private void printPostOrder(IntTreeNode root) {
        if (root != null) {
            printPreOrder(root.left);
            printPreOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    // prints tree in a tree form
    public void printSideways() {
        printSideways(overallRoot, 0);
    }

    // prints in reversed preorder the tree with given
    // root, indenting each line to the given level
    private void printSideways(IntTreeNode root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.data);
            printSideways(root.left, level + 1);
        }
    }
}
