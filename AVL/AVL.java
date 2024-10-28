package AVL;

import BST_Rec.AbstractBST;
import BST_Rec.Node;

public class AVL implements AbstractBalancedBST {
    Node root;

    @Override
    public int max() {
        return max(root);
    }

    private int max(Node current) {
        if (current.right == null)return current.data;
        return min(current.right);
    }

    @Override
    public int min() {
        return min(root);
    }
    private int min(Node current) {
        if (current.left == null)return current.data;
        return min(current.left);
    }

    @Override
    public boolean contains(int key) {
        Node current = root;
        return contains(key,current);
    }

    private boolean contains(int key, Node current) {
        if (current.data== key)return true;
        else if (current.data > key) return contains(key,current.left);
        else return contains(key,current.right);
    }

    @Override
    public int height() {
        return height(root);
    }

    private int height(Node current) {
        if (current == null)return -1;
        return 1 + Integer.max(height(current.left), height(current.right) ) ;
    }

    @Override
    public void preOrder() {
        preOrder(this.root);
    }

    private void preOrder(Node current) {
        if (current != null) {
            System.out.println(current.data+ " ");
            preOrder(current.left);
            preOrder(current.right);
        }
    }
    @Override
    public void inOrder() {
        inOrder(this.root);
    }

    private void inOrder(Node current) {
        if (current != null) {
            inOrder(current.left);
            System.out.println(current.data+ " ");
            inOrder(current.right);
        }
    }

    @Override
    public void postOrder() {
        postOrder(this.root);

    }
    private void postOrder(Node current) {
        if (current != null) {
            postOrder(current.left);
            postOrder(current.right);
            System.out.println(current.data+ " ");
        }
    }

    public String toString(){
        return "<" + toString(root) + ">";
    }

    private String toString(Node n) {
        if(n == null) return "";
        else return n.data + "," + toString(n.right) + toString(n.left);
    }
    @Override
    public void delete(int key) {
        new RuntimeException("we don't need to know how to remove from AVL");
    }
    @Override
    public int size() {
        return size(root);
    }

    private int size(Node current) { //כמות האיברים בעץ
        if (current == null)return 0;
        return size(current.left)+size(current.right)+1;
    }

    //////////////////////////////for AVL//////////////////////////////////
    @Override
    public void add(int value) {
        if (!contains(value)){
          root = add(value,this.root);
        }
    }


    private Node add(int value, Node current) {
        if (current == null) return new Node(value);

        if (current.data > value) add(value, current.left);
        else add(value,current.right);
        update(current); //update the balance factor of the tree
        return balance(current);//return the balance of the tree
    }

    // Update a node's height and Balance factor
    @Override
    public void update(Node node) {
        int leftNodeHeight = height(node.left);
        int rightNodeHeight = height(node.right);
        node.balanceFactor = rightNodeHeight-leftNodeHeight;
    }

    @Override
    public Node balance(Node node) {
        if (node.balanceFactor == 2) {//R
            if (node.right.balanceFactor <=0 ){ //RL
                return rightLeftCase(node);
            }
            else return rightRightCase(node); //RR
        }
        else if (node.balanceFactor == -2) { //L
            if (node.left.balanceFactor <= 0){ //LL
                return laftLaftCase(node);
            }
            else return leftRightCase(node);//LR
        }
        else return node;
    }

    private Node leftRightCase(Node node) {
        node.left = leftRotation(node.left);
        return rightRotation(node);
    }

    private Node laftLaftCase(Node node) {
        return rightRotation(node);
    }

    private Node rightRightCase(Node node) {
        return leftRotation(node);
    }

   

    private Node rightLeftCase(Node node) {
        node.right = rightRotation(node.right);
        return leftRotation(node);
    }

    private Node rightRotation(Node z) {
        Node newParent = z.left;
        z.left = newParent.right;
        update(z);
        update(newParent);
        return newParent;
    }

    private Node leftRotation(Node node) {
        // node is z
        Node newParent = node.right;
        // newParent is y
        node.right = newParent.left;
        // z.right is now T2
        newParent.left = node;
        // y.left is now z

        update(node);
        update(newParent);
        // This order the important!

        return newParent;
    }
}


