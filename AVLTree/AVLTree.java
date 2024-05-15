package AVLTree;

import TreeNodes.AVLTreeNode;
import java.io.*;
import java.util.*;

public class AVLTree {
    private static AVLTreeNode root;

    // Utility method to insert a node
    public void insert(int data) {
        root = insertNode(root, data);
    }

    // passed txt file, loads into AVL tree
    public void loadFromFile(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        while (scan.hasNextInt()) {
            insert(scan.nextInt());
        }
        scan.close();
    }

    public AVLTreeNode search(int data) {
        return search(data, root);
    }

    private static AVLTreeNode search(int data, AVLTreeNode root) {
        if (root == null) {
            return null;
        } else if (root.data == data) {
            return root;
        } else if (root.data < data) {
            return search(data, root.right);
        } else {
            return search(data, root.left);
        }
    }

    // left right root
    public void postTraverse() {
        postTraverse(root);
        System.out.println();
    }

    private static void postTraverse(AVLTreeNode root) {
        if (root == null) {

        } else {
            postTraverse(root.left);
            postTraverse(root.right);
            System.out.print(root.data);
        }
    }

    // root left right
    public void preTraverse() {
        preTraverse(root);
        System.out.println();
    }

    private static void preTraverse(AVLTreeNode root) {
        if (root == null) {

        } else {
            System.out.print(root.data);
            preTraverse(root.left);
            preTraverse(root.right);
        }

    }

    // left root right
    public void inTraverse() {
        inTraverse(root);
        System.out.println();
    }

    private static void inTraverse(AVLTreeNode root) {
        if (root == null) {

        } else {
            inTraverse(root.left);
            System.out.print(root.data);
            inTraverse(root.right);
        }

    }

    // Calculate height of a node
    private static int height(AVLTreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // Update height of a node
    private static void updateHeight(AVLTreeNode node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    // Perform a left rotation
    private static AVLTreeNode leftRotate(AVLTreeNode x) {
        AVLTreeNode y = x.right;
        AVLTreeNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        updateHeight(x);
        updateHeight(y);

        // Return new root
        return y;
    }

    // Perform a right rotation
    private static AVLTreeNode rightRotate(AVLTreeNode y) {
        AVLTreeNode x = y.left;
        AVLTreeNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        updateHeight(y);
        updateHeight(x);

        // Return new root
        return x;
    }

    // Perform left then right rotations to balance the tree
    private static AVLTreeNode leftRightRotate(AVLTreeNode z) {
        z.left = leftRotate(z.left); // Left rotation on the left child
        return rightRotate(z); // Right rotation on the unbalanced node
    }

    // Perform right then left rotations to balance the tree
    private static AVLTreeNode rightLeftRotate(AVLTreeNode z) {
        z.right = rightRotate(z.right); // Right rotation on the right child
        return leftRotate(z); // Left rotation on the unbalanced node
    }

    // Insert a node into the AVL tree
    private static AVLTreeNode insertNode(AVLTreeNode node, int data) {
        if (node == null) {
            return new AVLTreeNode(data);
        }

        if (data < node.data) {
            node.left = insertNode(node.left, data);
        } else if (data > node.data) {
            node.right = insertNode(node.right, data);
        } else {
            // Duplicate data not allowed
            return node;
        }

        // Update height of this ancestor node
        updateHeight(node);

        // Get the balance factor
        int balance = height(node.left) - height(node.right);

        // Left Left Case: Single right rotation
        if (balance > 1 && data < node.left.data) {
            return rightRotate(node);
        }

        // Right Right Case: Single left rotation
        if (balance < -1 && data > node.right.data) {
            return leftRotate(node);
        }

        // Left Right Case: Left then right rotations
        if (balance > 1 && data > node.left.data) {
            return leftRightRotate(node);
        }

        // Right Left Case: Right then left rotations
        if (balance < -1 && data < node.right.data) {
            return rightLeftRotate(node);
        }

        return node;
    }

}
