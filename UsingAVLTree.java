import java.io.*;

import AVLTree.AVLTree;
public class UsingAVLTree {
    
    static AVLTree tree = new AVLTree();
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("numbers.txt");
        tree.loadFromFile(file);
        tree.inTraverse();
        tree.preTraverse();
        tree.postTraverse();
        System.out.println(tree.search(7));

    }
}
