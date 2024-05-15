/* CS 240
 * Isaiah King
 * Node for int binary trees
 */

package TreeNodes;


public class IntTreeNode {
    public int data;
    public IntTreeNode left;
    public IntTreeNode right;
    

    public IntTreeNode(int data){
        this(data, null, null);
    }

    public IntTreeNode(int data, IntTreeNode left, IntTreeNode right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
