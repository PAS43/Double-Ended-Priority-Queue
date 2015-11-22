package cs21120;

class TreeNode{
    private Integer value;
    private TreeNode left, right, root;

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
                return null;
            }
            else
                insert(n.right, input);
        }

        if(input.compareTo(n.value) < 0){
            if(n.left == null) {
                n.left = new TreeNode(input);
                return null;
            }
            else
                insert(n.left, input);
        }
        return null;
    }
}
