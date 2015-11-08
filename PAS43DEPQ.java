package cs21120;

public class PAS43DEPQ implements DEPQ
{
    private TreeNode[] tree = new TreeNode[1001];
    int index = 0;

    @Override
    public Comparable inspectLeast() {
        return null;
    }

    @Override
    public Comparable inspectMost() {
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
        // Root node
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
            //this is equal to 0 so evrey time add is called it starts from tree index ie, tree[0] root node
            index = 0;
        }

        return;
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
        return (tree[0] == null) ? true : false;
    }

    @Override
    public int size() {
        return tree.length;
    }


}

