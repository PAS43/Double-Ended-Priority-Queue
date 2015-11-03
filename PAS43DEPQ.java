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
        TreeNode a = new TreeNode();
        a.setValue((int)c);
        if(tree[0] != null)
        {
            //if less than add to left
            if (tree[index - 1].compareTo(a) < 0)
            {
                tree[index - 1].setLeftChild(new TreeNode(a));
            }
            //if == add to right
            else if (tree[index - 1].compareTo(a) == 0)
            {
                tree[index - 1].setRightChild(new TreeNode(a));
            }
            //if more than add to right
            else if (tree[index - 1].compareTo(a) > 0)
            {
                tree[index - 1].setRightChild(new TreeNode(c));
            }
        } else {
            //creates root node
            tree[0] = new TreeNode(c);
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

