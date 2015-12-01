/**

Grade    20/20

Good, straightforward program.                   
                                    
On time        OK                     
Compiles        OK               
Documentation      OK  (Good to give credit to our authors)                                          
                                             
BinTree traversals           OK                    

Constructor          OK   
 
add()            OK            
                                 
contains()       OK              
                               
delete()      OK           
                          
find()         OK                       
                            
remove()        OK                  

Passes tests?    OK                            
                                                        
Comments: See comments in the code. Look for //CH                                 

*/




/**
 * A binary search tree.
 * 
 * Data Structures (2nd Edition)
 * Abstraction and Design Using Java
 * Elliot Koffman & Paul Wolfgang
 * 2010 John Wiley & Sons, Inc.
 * 
 * @author Lauren Swanson & E. Koffman & P. Wolfgang
 *
 * @param <E> Holds nodes of type E that extend the 
 *            Comparable class.
 */
public class CS261BinSearchTree<E extends Comparable<E>> extends BinTree<E> implements BinSearchTree<E>
{
    //Used for the add(E) method.
    private boolean isAdded;
    //Used for the remove(E) method.
    E deleted;          //CH Make this private?
    
    public CS261BinSearchTree()
    {
        //extending  the BinTree<E> class.
        super();    //CH good
        //nothing has been added yet.
        isAdded = false;
        //nothing has been deleted yet.
        deleted = null;
    }

      /**
     * Add an element to the tree 
     * 
     * @param item item to insert
     * @return true if item inserted, false if not (duplicate)
     * 
     */
    public boolean add(E item)
    {
        //the tree is reordered to include the added item.
        root = addHelper(root, item);
        //has item been inserted?
        return isAdded;
    }
    
    /**
     * Recursive helper for the add method.
     * 
     * @param localRoot The local root of the subtree.
     * @param item The object to be inserted.
     * @return The new local root that now contains the inserted item.
     */
    public BinNode<E> addHelper(BinNode<E> localRoot, E item)
    {
        //item isn't in the tree and can be added here,
        //at this empty node.
        if(localRoot == null)
        {
            isAdded = true;
            //adding the new item.
            return new BinNode<E>(item);
        }
        //item is already in the tree.
        if(localRoot.getData().equals(item))
        {
            //don't add. there is a duplicate.
            isAdded = false;
            //just return the local root eventhough there is a duplicate.
            return localRoot;
        }
        //item is less than the data in the localRoot so
        //it needs to be added on the left of the tree.
        if(item.compareTo(localRoot.getData()) < 0)
        {
            //holds the localRoot's left subtree.
            BinNode<E> left = addHelper(localRoot.getLeft(), item);
            //the localRoot now points to the new left subtree with
            //the added item.
            localRoot.setLeft(left);
            //The item has been added.
            return localRoot;
        }
        //item is greater than the data in the localRoot
        //so add it on the right of the tree.
        
            BinNode<E> right = addHelper(localRoot.getRight(), item);
            localRoot.setRight(right);
            return localRoot;
        
    }

    /**
     * Look for an element in the tree
     * @param target item to look for
     * @return true if found, false if not
     */
    public boolean contains(E target)
    {
        //The element can be found.
        return find(target) != null;
    }

    /**
     * Find an element in the tree
     * @param target item to find
     * @return reference to the data in the node that is the target. null if not found
     */
    public E find(E target)
    {
        return findHelper(root, target);
    }
    
    /**
     * A recursive helper for the find method.
     * @param localRoot The local root from which to begin
     *                  the search.
     * @param target The data that is being searched for.
     * @return The data that was found or null if
     *         the data wasn't found.
     */
    private E findHelper(BinNode<E> localRoot, E target)
    {
        //No more leaves so target isn't a child of the localRoot.
        if(localRoot == null)
        {
            return null;
        }
        //The target has been found.
        if(localRoot.getData().equals(target))
        {
            return localRoot.getData();
        }
        //Keep searching through the left side of the tree for the target.
        if(localRoot.getData().compareTo(target) > 0)
        {
            return findHelper(localRoot.getLeft(), target);
        }
        //Wasn't in left side so look in right side.
        return findHelper(localRoot.getRight(), target);
    }

    /**
     * remove an element in the tree
     * @param target item to remove
     * @return true if removed, false if not
     */
   public boolean remove(E target)
    {
       root = deleteHelper(root, target);
       return deleted != null;
    }
    
    /**
     * Delete an element in the tree and return it
     * @param target item to delete
     * @return item deleted, null if not found
     */
    public E delete(E target)
    {
        //reorganizes the tree.
        root = deleteHelper(root, target);
        //returns the data that was deleted
        return deleted;
    }
    
    /**
     * A recursive helper for the delete and remove methods.
     * 
     * @param localRoot The local root to begin searching for
     *                  the item to delete.
     * @param item      The item that should be deleted.
     * @return          The node with the new subtree without the 
     *                  item that was removed.
     */
    private BinNode<E> deleteHelper(BinNode<E> localRoot, E item)
    {
        if(localRoot == null)
        {
            //item isn't in the tree.
            deleted = null;
            return localRoot;
        }
        
        //Search for the item.
        int comp = item.compareTo(localRoot.getData());
        if(comp < 0)
        {
            //item is smaller than the local root. go left.
            BinNode<E> left = deleteHelper(localRoot.getLeft(), item);
            localRoot.setLeft(left);
            return localRoot;
        }
        if(comp > 0)
        {
            //item is larger than the local root. go right.
            BinNode<E> right = deleteHelper(localRoot.getRight(), item);
            localRoot.setRight(right);
            return localRoot;
        }
        //item is at the localRoot.
        deleted = localRoot.getData();
        
        if(localRoot.getLeft() == null)
        {
            //no left child so return right child.
            return localRoot.getRight();
        }
        if(localRoot.getRight() == null)
        {
            //no right child so return left child.
            return localRoot.getLeft();
        }
        //node being deleted has 2 children, replace the data
        //with the inOrder predecessor.
        if(localRoot.getLeft().getRight() == null)
        {
            //left child has no right child. Replace data
            //with the data in the left child.
            localRoot.setData(localRoot.getLeft().getData());
            //Replace left child with its left child.
            localRoot.setLeft(localRoot.getLeft().getLeft());
            return localRoot;
        }
        //Search for inOrder predecessor and replace the
        //deleted node's data with the inOrder predecessor's.
        localRoot.setData(findLargestChild(localRoot.getLeft()));
        return localRoot;
    }
    
    /**
     * 
     * @param parent The node to begin the search for its 
     *               largest child.
     * @return The data held in the largest child.
     */
    private E findLargestChild(BinNode<E> parent)
    {
        //The right child has no right child, it is 
        //the in-order predecessor.
        if(parent.getRight().getRight() == null)
        {
            E returnValue = parent.getRight().getData();
            //Parent is now pointing to its left node, twice.
            //Right node has been deleted.
            parent.getRight().setData(parent.getRight().getLeft().getData());
            //Delete the left child of the parent.
            parent.getLeft().setData(null);
            //Return this right child.
            return returnValue;
        }
        //Still bigger nodes after the parent's right child.
        return findLargestChild(parent.getRight());
    }

}
