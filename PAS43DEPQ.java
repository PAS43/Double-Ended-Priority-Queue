package cs21120;

public class PAS43DEPQ implements DEPQ
{
    private TreeNode[] tree = new TreeNode[1001];
    int index = 0;
    int size = 0;

    @Override
    public Comparable inspectLeast() {
        int i = 0;
        while (tree[i] != null)
        {
            i += left() - i;
            if(tree[i].getLeftChild() == null)
            {
                return (Comparable) tree[i];
            }
        }
        return null;
    }

    @Override
    public Comparable inspectMost() {
        int i = 0;
        while (tree[i] != null)
        {
            i += right() - i;
            if(tree[i].getRightChild() == null)
            {
                return (Comparable) tree[i];
            }
        }
        return null;
    }

    /*
    right: (2 * n) + 2
    left: (2 * n) + 1
    parent: (1 - n) / 2
     */

    public int right()
    {
        return (2 * index) + 2;
    }

    public int left()
    {
        return (2 * index) + 1;
    }

    public int parent()
    {
        return Math.round((index  - 1) / 2);
    }

    @Override
    public void add(Comparable c)
    {

        // Checks for Root node if not there it places one
        if (tree[0] == null) {
            tree[0] = new TreeNode(c);
            return;
        }

        //this while loop is for tree traversal
        while(tree[index] != null) {
            if( c.compareTo(tree[index].getValue()) == 0) {
                index += right() - index;
                continue;
            }

            if( c.compareTo(tree[index].getValue()) > 0) {
                index += right() - index;
                continue;
            }

            if( c.compareTo(tree[index].getValue()) < 0) {
                index += left() - index;
                continue;
            }
        }

        //this part is for place the new node
        if(tree[index] == null) {
            tree[index] = new TreeNode(c);

            if( c.compareTo(tree[index].getValue()) == 0) {
                tree[parent()].setRightChild(tree[index]);
                tree[index].setParent(tree[parent()]);
            }

            if( c.compareTo(tree[index].getValue()) > 0) {
                tree[parent()].setRightChild(tree[index]);
                tree[index].setParent(tree[parent()]);
            }

            if( c.compareTo(tree[index].getValue()) < 0) {
                tree[parent()].setLeftChild(tree[index]);
                tree[index].setParent(tree[parent()]);
            }
            //this is equal to 0 so every time add is called it starts from tree index ie, tree[0] - root node
            index = 0;
        }
        //gets the size of the array
        size++;
        return;
    }

    @Override
    public Comparable getLeast() {
        int i = 0;
        while (tree[i] != null) {
            i += left() - i;
            if (tree[i].getLeftChild() == null) {
                Comparable least = (Comparable) tree[i];
                tree[i] = null;
                return least;
            }
        }
        return null;
    }

    @Override
    public Comparable getMost() {
        int i = 0;
        while (tree[i] != null)
        {
            i += right() - i;
            if(tree[i].getRightChild() == null)
            {
                Comparable most = (Comparable) tree[i];
                tree[i] = null;
                return most;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return (tree[0] == null) ? true : false;
    }

    @Override
    public int size() {
        return this.size;
    }


}

