package cs21120;

class TreeNode{
    private Integer value;
    private TreeNode left;
    private TreeNode right;
    private TreeNode root;

    //constructors
    public TreeNode() {}

    public TreeNode(TreeNode t) {
        this.value = t.value;
        this.left = t.left;
        this.right = t.right;
        this.root = t.root;
    }

    public TreeNode(Comparable c) {
        this.value = (int) c;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void add(Integer input){
        if(root == null){
            root = new TreeNode(input);
            return;
        } else {
            insert(root, input);
        }
    }

    public TreeNode insert(TreeNode n, Integer input){
        if(input.compareTo(n.value) >= 0){
            if (n.right == null) {
                n.right = new TreeNode(input);
                n.right.root = n;
                return null;
            }
            else {
                insert(n.right, input);
            }
        }

        if(input.compareTo(n.value) < 0){
            if(n.left == null) {
                n.left = new TreeNode(input);
                n.left.root = root;
                return null;
            }
            else {
                insert(n.left, input);
            }
        }
        return null;
    }
}
