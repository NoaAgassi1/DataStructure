package BST_Rec;
public class BST implements AbstractBST {
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


    @Override
    public void add(int value) {
        add(value,this.root);
    }


    private static void add(int value, Node current) {
        if (current == null) current = new Node(value);
        if (current.data > value) add(value, current.left);
        else if (value > current.data) add(value, current.right);
        else throw new RuntimeException("Already exists");
    }

    @Override
    public void delete(int key) {
        root = delete(key,root);
    }

    private Node delete(int key, Node current) {
        if (current == null) return null;
        if (current.data > key) current.left = delete(key,current.left);
        else if (current.data < key) current.right = delete(key,current.right);
        // אחרת הוא שווה למפתח
        if (current.left == null) return current.right;
        else if (current.right == null) return current.left;
        else {
            int minVal = min(current.right);
            current.data = minVal;
            current.right = delete(key,current.right);

        }
        return current;
    }

    @Override
    public int size() {

        return size(root);
    }

    private int size(Node current) { //כמות האיברים בעץ
        if (current == null)return 0;
        return size(current.left)+size(current.right)+1;
    }

    public String toString(){
        return "<" + toString(root) + ">";
    }

    private String toString(Node n) {
        if(n == null) return "";
        else return n.data + "," + toString(n.right) + toString(n.left);
    }


    public static boolean isEqual(Node a , Node b){
        // if both root are null,the trees are identical
        if (a == null && b == null) return true;

        // if just one of the roots are null,the trees are not identical
        if (a == null || b == null) return false;

        return a.data == b.data && isEqual(a.left,b.left) && isEqual(a.right,b.right);

    }
    public boolean isBST() {
        return isBST(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isBST(Node curr, int min, int max) {
        /* an empty tree is BST */
        if (curr == null)
            return true;

        /* false if this node violates the min/max constraints */
        if (curr.data < min || curr.data > max)
            return false;

		/* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (isBST(curr.left, min, curr.data-1) &&
                isBST(curr.right, curr.data+1, max));
    }





}
