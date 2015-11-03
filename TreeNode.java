package cs21120;

/**
 * Created by def on 29/10/15.
 */
class TreeNode implements Comparable<TreeNode>
{
    private Integer value;
    private TreeNode leftChild;
    private TreeNode rightChild;
    private TreeNode parent;

    //constructors
    public TreeNode(){}
    public TreeNode(Integer v){this.value  = v;}
    public TreeNode(TreeNode t){
        this.value = t.value;
        this.parent = t.parent;
        this.leftChild = t.leftChild;
        this.rightChild = t.rightChild;
    }
    public TreeNode (Comparable c){this.value = (int) c;}

    //set parent
    public void setParent(TreeNode t)
    {
        this.parent = t.parent;
    }
    //get parent
    public TreeNode getParent()
    {
        return  this.parent;
    }
    //get value
    public int getValue(){return value;}
    //set value
    public void setValue(Integer i){ this.value = i;}
    //get left node
    public TreeNode getLeftChild(){return leftChild;}
    //get right node
    public TreeNode getRightChild(){return rightChild;}
    //set left child
    public void setLeftChild(TreeNode t) {this.leftChild = t;}
    //set right child
    public void setRightChild(TreeNode t) {this.rightChild = t;}

    public TreeNode find(int n)
    {
        //this statement runs if the current node is == the value being searched.
        if(this.value == n)
            return this;
        //this returns values left of the root then performs a recursive call if not found
        if(value < this.value && leftChild != null)
            return leftChild.find(n);
        //this does the same as above except looks on the right side of the root
        if(rightChild != null)
            return rightChild.find(n);

        //this returns if value is not found
        return null;
    }

    @Override
    public int compareTo(TreeNode o)
    {

        if (this.value == o.value)
        {
            return 0;// if value equal
        }
        if (this.value > o.value) //if value greater
        {
             return 1;
        }
        if (this.value < o.value)
        {
            return -1;   //if value less
        }
        //this should not run
        return 99;
    }

    public void insert(TreeNode t)
    {

        //This if statement runs if the number is less than
        if(this.compareTo(t) < 0)
        {
            if(this.leftChild != null)
                this.leftChild.insert(t);
            else
                this.leftChild = new TreeNode(t);
        }
        //This if statement runs if equal to
        if (this.compareTo(t) == 0)
        {
            if(this.rightChild != null)
                this.rightChild.insert(t);
            else
                this.rightChild = new TreeNode(t);

        }
        //This one runs if it is greater than
        if (this.compareTo(t) > 0)
        {
            if(this.rightChild != null)
                this.rightChild.insert(t);
            else
                this.rightChild = new TreeNode(t);
        }
    }

}