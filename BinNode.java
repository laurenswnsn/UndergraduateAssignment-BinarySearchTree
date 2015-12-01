
/**
 * A node for a binary tree
 * @author CS261
 * @version 2011.10.27
 */
public class BinNode<E>
{
    private E data;
    private BinNode<E> left;
    private BinNode<E> right;
    /**
     * Constructor for objects of class BinNode
     */
    public BinNode (E data)
    {
       this.data = data;
       left = null;
       right = null;
    }
    /** 
     * set new data value
     */
    public void setData(E data)
    {
        this.data = data;
    }
    
    /** 
     * get the data from this node
     * @return the data stored in this node
     */
    public E getData()
    {
        return data;
    }

    /**
     * Set left pointer
     * @param l pointer to a BinNode
     */
    public void setLeft(BinNode<E> l)
    {
        left = l;
    }
    
     /**
     * Set right pointer
     * @param r pointer to a BinNode
     */
    public void setRight(BinNode<E> r)
    {
        right = r;
    }
    
     /**
     * Get left pointer
     * @return pointer to left BinNode
     */
    public BinNode<E> getLeft()
    {
        return left;
    }
    
     /**
     * Get right pointer
     * @return pointer to a BinNode
     */
    public BinNode<E> getRight()
    {
        return right;
    }
}
