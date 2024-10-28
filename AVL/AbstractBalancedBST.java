package AVL;

import BST_Rec.AbstractBST;
import BST_Rec.Node;

public interface AbstractBalancedBST  extends AbstractBST {

    public void update(Node node);
    public Node balance(Node node);
}
