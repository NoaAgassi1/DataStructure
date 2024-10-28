package BST_Rec;

import static BST_Rec.BST_AfterQuestions.isEquals;
import static BST_Rec.BST_AfterQuestions.printTreeByLevels;

public class Main {
    public static void main(String[] args) {
        BST_AfterQuestions tree = new BST_AfterQuestions();
        BST_AfterQuestions tree2 = new BST_AfterQuestions();
        int[] keys = {2,3,1,5,7,6,4,8};

        for(int i : keys) {
            tree.add(i);
            tree2.add(i);
        }
        //tree.InOrder();
        tree.PostOrder();

       // tree.PostOrder();
        System.out.println("\n"+ "num of children : " +tree.numOfChilds(6));
        //System.out.println(tree.returnMax());
        System.out.println(isEquals(tree.root,tree2.root));
       // System.out.println(tree2.size(tree2.root));
        printTreeByLevels(tree);
        System.out.println(tree.isBST());
        tree2.delete((3));
        printTreeByLevels(tree2);
        Node lca = BST_AfterQuestions.qLCA(tree.root, 7, 5);
        if (lca != null) {
            System.out.println("LCA(7, 5) = " + lca.data);
        } else {
            System.out.println("LCA(7, 5) does not exist");
        }

    }
}
