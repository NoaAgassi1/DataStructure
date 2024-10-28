package BST_Rec;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public Node right;
    public Node left;
    public int data;
    public Node size;
    public int balanceFactor;

   public Node(int data){
       this.data = data;
       this.left = null;
       this.right = null;
       this.balanceFactor = 0;
   }

}
