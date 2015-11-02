package cs21120;

public class PAS43DEPQ implements DEPQ
{
    private TreeNode[] tree = new TreeNode[100];
    int index = 0;

    @Override
    public Comparable inspectLeast() {
        return null;
    }

    @Override
    public Comparable inspectMost() {
        return null;
    }

    @Override
    public void add(Comparable c)
    {
        tree[index] = new TreeNode(c);
        if(index > 0)
        {
            //if less than add to left
            if (tree[index].compareTo(this.tree[index-1]) < 0)
            {
                tree[index].setLeftChild(new TreeNode(c));
            }
            //if == add to right
            if (tree[index].compareTo(this.tree[index-1]) == 0)
            {
                tree[index].setRightChild(new TreeNode(c));
            }
            //if more than add to right
            if (tree[index].compareTo(this.tree[index-1]) > 0)
                {
                tree[index].setRightChild(new TreeNode(c));
            }
        }
        index += 1;
    }

    @Override
    public Comparable getLeast() {
        return null;
    }

    @Override
    public Comparable getMost() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }


}

