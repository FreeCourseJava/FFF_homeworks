package fourteenth;


import java.util.HashMap;

public class TreeNode <KEY, VALUE> {

    KEY key;

    HashMap<KEY, VALUE> collisionSolution = new HashMap<>();

    TreeNode leftChild;
    TreeNode rightChild;


    public TreeNode() {
        this.key=null;
        this.rightChild=null;
        this.leftChild=null;
        }

    public TreeNode (KEY key, VALUE value)
    {
        this.key=key;
        this.collisionSolution.put(key, value);
        this.leftChild=null;
        this.rightChild=null;
        }

}
