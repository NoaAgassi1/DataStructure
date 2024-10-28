package BST_Rec;

import java.util.LinkedList;
import java.util.Queue;

public class print extends Node {
    public static void main(String[] args) {
        print print = new print(9);
        print.addNode(6);
        print.addNode(2);
        print.addNode(10);
        print.addNode(4);
        print.addNode(7);
        print.addNode(8);
        print.addNode(5);
        print.addNode(3);
        print.addNode(1);
        print.addNode(0);
        print.printPreorder(print);

    }
    private print root;
    private print left,right;

    public print(int data) {
        super(data);
    }
    public  void addNode(int value) {
        print newNode = new print(value);
        this.left = null;
        this.right = null;

        if (root == null) {
            root = newNode;
            return;
        }

        // נשתמש ב-Queue כדי לעבור על העץ לפי רמות
        Queue<print> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            print current = queue.poll();

            // הוספה לצומת השמאלי אם הוא פנוי
            if (current.left == null) {
                current.left = newNode;
                return;
            } else {
                queue.add(current.left);
            }

            // הוספה לצומת הימני אם הוא פנוי
            if (current.right == null) {
                current.right = newNode;
                return;
            } else {
                queue.add(current.right);
            }
        }
    }

    // פונקציה להדפסה ב-Preorder Traversal לצורך בדיקה
    public void printPreorder(print node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    public void preOrder() {
        preOrder(this.root);
    }

    private void preOrder(print current) {
        if (current != null) {
            System.out.println(current.data+ " ");
            preOrder(current.left);
            preOrder(current.right);
        }
    }

    public void inOrder() {
        inOrder(this.root);
    }

    private void inOrder(print current) {
        if (current != null) {
            inOrder(current.left);
            System.out.println(current.data+ " ");
            inOrder(current.right);
        }
    }


    public void postOrder() {
        postOrder(this.root);

    }
    private void postOrder(print current) {
        if (current != null) {
            postOrder(current.left);
            postOrder(current.right);
            System.out.println(current.data+ " ");
        }
    }
    private String toString(Node n) {
        if(n == null) return "";
        else return n.data + "," + toString(n.right) + toString(n.left);
    }
}
