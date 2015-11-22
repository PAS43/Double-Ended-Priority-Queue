package cs21120;

public class PAS43DEPQ implements DEPQ
{
    TreeNode tree = new TreeNode();
    int index = 0;
    int size = 0;

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
        tree.add((int) c);
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
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }


}