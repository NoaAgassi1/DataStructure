package BST_Rec;

import java.util.*;

public class BST_AfterQuestions {
    Node root;

    // Constructor
    public BST_AfterQuestions() {  root = null; }

    // Returns minimum value in a given
    // Binary Tree
    public int returnMin(){
        Node current = root;
        while (current != null){
            current = current.left;
        }
        return current.data;
    }

    // Returns maximum value in a given Binary Tree
    // Returns maximum value in a given Binary Tree
    public int returnMax() {
        Node current = root;
        if (current == null) {
            throw new NoSuchElementException("The tree is empty");
        }
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }

    // Returns true iff Node(key) in the  Tree
    public boolean search(int key){
        Node current = root;
        while (current != null){
            if (current.data == key) return true;

            if(current.data > key){
                current = current.left;
            }

            else current = current.right;
        }
        return false;
    }

    public int getHeight(){
        return getHeight(root);
    }

    private int getHeight(Node current) {
        if (current == null) return -1;
        return Integer.max(getHeight(current.left), getHeight(current.right))+1 ;
    }

    public void PreOrder() // (V,L,R)
    {
        PreOrder(root);
    }
    public void PreOrder(Node current)
    {
        if(current != null)
        {
            System.out.print(current.data + " " );
            PreOrder(current.left);
            PreOrder(current.right);
        }
    }
    /* Given a binary tree, print its nodes according to the InOrder */
    public void InOrder() // (L,V,R)
    {
        InOrder(root);
    }
    public void InOrder(Node current) {
        if(current != null) {
            InOrder(current.left);
            System.out.print(current.data + " " );
            InOrder(current.right);
        }
    }
    /* Given a binary tree, print its nodes according to the PostOrder */
    public void PostOrder(){ // (L,R,V)
        PostOrder(root);
    }
    public void PostOrder(Node current) {
        if(current != null) {
            PostOrder(current.left);
            PostOrder(current.right);
            System.out.print(current.data + " " );
        }
    }

    public void add(int key)
    {
        Node NewNode = new Node(key); // Make New Node
        Node current = root;
        if(current == null)
            root = NewNode;
        else
        {
            boolean exit = false;
            while(!exit)
            {
                if(key < current.data)
                {
                    if(current.left == null)
                    {
                        // put here
                        current.left = NewNode;
                        exit = true;
                    }
                    else
                        current = current.left;
                }
                else if(key > current.data)
                {
                    if(current.right == null)
                    {
                        // put here
                        current.right = NewNode;
                        exit = true;
                    }
                    else
                        current = current.right;
                }
            }
        }
    }
    public int size(Node current){
        if (current == null)return 0;
        return size(current.left) + size(current.right) + 1;
    }

    public int numOfChilds(int data){
        Node current = root;
        while (current.data != data){
            if (current.data == data) break;
            else if (data > current.data) {
                current = current.right;
            }
            else {
                current = current.left;
            }
        }
        return size(current)-1;

    }
    private String toString(Node n) {
        if(n == null) return "";
        else return n.data + "," + toString(n.right) + toString(n.left);
    }
    public static boolean isEquals(Node a , Node b){
        // if both root are null,the trees are identical
        if (a == null && b == null) return true;

        // if just one of the roots are null,the trees are not identical
        if (a == null || b == null) return false;

        if (a != null && b != null) {
            return (a.data == b.data
                    && isEquals(a.left, b.left)
                    && isEquals(a.right, b.right));
        }
        return false;
    }

    public boolean isBST() {
        return isBST(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node current, int minValue, int maxValue) {
        if (current == null) return true;
        if (current.data < minValue || current.data > maxValue){
            return false;
        }
        else {
            return isBST(current.left,minValue,current.data-1) && isBST(current.right,current.data+1,maxValue);
        }
    }

    // Utility function to swap left subtree with right subtree
    public static void swap(Node root) {
        if (root == null)return;
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    // Function to convert given binary Tree to its mirror
    public static void convertToMirror(Node root){
        if (root == null)return;

        // convert left subtree
        convertToMirror(root.left);
        // convert right subtree
        convertToMirror(root.right);

        swap(root);
    }


    public int findLCA(int n1, int n2){

        return findLCA(root, n1, n2).data;
    }

    // This function returns pointer to Lowest common Ancestor of two given
    // values n1 and n2. This function assumes that n1 and
    // n2 are present in Binary Tree
    public Node findLCA(Node node, int n1, int n2) {
        if (node == null) return null;
        if (node.data < n1 && node.data < n2){
            return findLCA(node.right,n1,n2);
        }
        if (node.data > n1 && node.data > n2){
            return findLCA(node.left,n1,n2);
        }
        return node;
    }

    public int kthSmallest(Node root, int k) {
        if ( k > size(root)){
            return Integer.MAX_VALUE;
        }
        List<Integer> list = new ArrayList<>();
        InOrder(root,list);
        return list.get(k-1);
    }

    private void InOrder(Node root, List<Integer> list) {
        if(root != null) {
            InOrder(root.left,list);
            list.add(root.data);
            InOrder(root.right,list);
        }
    }


    public static void printTreeByLevels(BST_AfterQuestions tree) {
        if (tree == null)return;
        Queue<Node> q = new LinkedList<>();
        q.add(tree.root);
        while (!q.isEmpty()) {
            int numofnodecurrllevel = q.size();
            while (numofnodecurrllevel > 0) {
                Node top = q.poll();
                System.out.print(top.data + " ");
                if(top.left != null)
                    q.add(top.left);
                if(top.right != null)
                    q.add(top.right);
                numofnodecurrllevel--;
            }
            System.out.println(" ");
        }

    }
    public void delete(int key) {
        deleteRec(root, key);
    }

    /* A recursive function to insert a new key in BST */
    private Node deleteRec(Node root, int key) {

        /* Base Case: If the tree is empty */
        if(root == null) return root;

        /* Otherwise, recur down the tree */
        if(key  < root.data)
            root.left = deleteRec(root.left, key);
        else if (key > root.data)
            root.right = deleteRec(root.right, key);

            // if key is same as root's key, then This is the node
            // to be deleted
        else {

            // node with no child
            if( root.left == null && root.right == null) return null;

            // node with only one child
            if (root.left == null)  // No Left Child
                return root.right;
            else if (root.right == null) // No Right Child
                return root.left;

            // nodes with two children

            // Find Minimum Value
            Node current = root.left;
            while(current.right != null ) current = current.right;
            int minValue = current.data;

            // Set root data to minimum value
            root.data = minValue;

            // Delete the node
            root.left = deleteRec(root.left, minValue);
        }
        return root;
    }
    public static Node qLCA(Node root,int n1,int n2){
        if (root == null) {
            return null;
        }
        // אם אחד מהערכים n1 או n2 נמצא בשורש
        if (root.data == n1 || root.data == n2) {
            return root;
        }
        // חיפוש בנתיבי המשנה
        Node leftLCA = qLCA(root.left, n1, n2);
        Node rightLCA = qLCA(root.right, n1, n2);

        // אם שני הצדדים החזירו תוצאה, השורש הנוכחי הוא ה-LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }
        // אחרת, חזר על התוצאה שנמצאה שאינה null
        if (leftLCA != null){
            return leftLCA;
        }
        else return rightLCA;
    }

    public static boolean contain(Node root, int node1, int node2) {
        if (root == null ) {
            return false;
        }
        return (findNode(root, node1) && findNode(root, node2));
    }

    private static boolean findNode(Node root, int node) {
        if (root == null) {
            return false;
        }
        if (root.data == node) {
            return true;
        }
        return findNode(root.left, node) || findNode(root.right, node);
    }


}
