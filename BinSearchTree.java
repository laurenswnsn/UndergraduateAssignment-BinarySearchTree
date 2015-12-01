
/**
 * The interface for a binary search tree.
 * 
 * @author Chuck Hommel
 * @version 2011.10.30
 */
public interface BinSearchTree<E> 
{
    /**
     * Add an element to the tree 
     * @param item item to insert
     * @return true if item inserted, false if not (duplicate)
     * 
     */
    boolean add(E item);

    /**
     * Look for an element in the tree
     * @param target item to look for
     * @return true if found, false if not
     */
    boolean contains(E target);

    /**
     * Find an element in the tree
     * @param target item to find
     * @return reference to the data in the node that is the target. null if not found
     */
    E find(E target);

    /**
     * remove an element in the tree
     * @param target item to remove
     * @return true if removed, false if not
     */
    boolean remove(E target);

    /**
     * Delete an element in the tree and return it
     * @param target item to delete
     * @return item deleted, null if not found
     */
    E delete(E target);

}
