
/**
 * A binary tree
 * 
 * Data Structures (2nd Edition)
 * Abstraction and Design Using Java
 * Elliot Koffman & Paul Wolfgang
 * 2010 John Wiley & Sons, Inc.
 * 
 * @author Lauren Swanson & E. Koffman & P. Wolfgang 
 * @version 4/3/2012
 */
public class BinTree<E> 
{
    protected BinNode<E> root;

    /**
     * Constructor for objects of class BinTree
     */
    public BinTree()
    {
        root = null;
    }

    /**
     * Constructor
     * @param root root for this binary tree
     */
    public BinTree(BinNode<E> root)
    {
        this.root = root;
    }

    /**
     * Constructor
     * @param data data for root node
     * 
     * @param leftTree root of tree to be put on left
     * @param rightTree root of tree to be put on right
     * 
     */
    public BinTree(E data, BinTree<E> leftTree, BinTree<E> rightTree)
    {
        root = new BinNode<E>(data);
        if (leftTree != null)
        {
            root.setLeft(leftTree.root);
        }
        if (rightTree != null)
        {
            root.setRight(rightTree.root);
        }
    }

    /**
     * checks whether this is a leaf
     * @return true if this is a leaf, false if not
     */ 
    public boolean isLeaf()
    {
        //CH Note changes to use getLeft(), etc.
        return (root == null ||(root.getLeft() == null && root.getRight() == null));
    }

    /**
     * returns the data in the root node
     * @return the data in the root node
     */
    public E getData()
    {
        if (root == null)
        {
            return null;
        }
        return root.getData();
    }

  
    /** 
     * returns a reference to the left subTree
     * @return left subTree
     */
    public BinTree<E> getLeftSubtree()
    {
        if (root != null)
        {
            return new BinTree<E>(root.getLeft()) ;
        }
        else
        {
            return new BinTree<E>();
        }
    }

     /** 
     * returns a reference to the right subTree
     * @return right subTree
     */
    public BinTree<E> getRightSubtree()
    {
        if (root != null)
        {
            return new BinTree<E>(root.getRight()) ;
        }
        else
        {
            return new BinTree<E>();
        }
    }

    
    /**
     * @return number of nodes in this tree
     */
    public int size()
    {
        return size(root);     //helper method
    }

    /**
     * @return number of nodes in this tree
     * @param root the root node of the tree
     */
    private int size(BinNode<E> root)
    {
        if ( root == null)
        {
            return 0;
        }
        return 1 + getRightSubtree().size() + getLeftSubtree().size();
    }

    /**
     * Performs a preOrder traversal and prints the results.
     * Recursively traverses the list starting with the root,
     * then the left, followed by the right.
     */
    public void preOrderTraversal()
    {
    	//call the helper.
       preOrderTraversalHelper(root);
    }
    
    /**
     * Recursive helper method for the preOrderTraversal method.
     * 
     * @param localRoot The node to begin the traverse.
     */
    private void preOrderTraversalHelper(BinNode<E> localRoot)
    {
    	if(localRoot == null)
    	{
    		return;
    	}
    	System.out.println(localRoot.getData().toString());
    	preOrderTraversalHelper(localRoot.getLeft());
    	preOrderTraversalHelper(localRoot.getRight());
    }


    /**
     * Prints on the terminal a postOrder traversal of the tree.
     * Recursively traverses the list beginning with the 
     * left side, then the right, and finally the root.
     */
    public void postOrderTraversal()
    {
    	postOrderTraversalHelper(root);
    }
    
    /**
     * Recursive helper method for the preOrderTraversal method.
     * 
     * 
     * @param localRoot The node to orient the traverse.
     */
    private void postOrderTraversalHelper(BinNode<E> localRoot)
    {
    	
    	if(localRoot == null)
    	{
    		return;
    	}
    	
    	postOrderTraversalHelper(localRoot.getLeft());
    	postOrderTraversalHelper(localRoot.getRight());
    	System.out.println(localRoot.getData().toString());
    }

    /**
     * Prints on the terminal an inOrder traversal of the tree.
     * Recursively traverses the list beginning with left-most nodes,
     * then the root, then the right-most nodes.
     */ 
    public void inOrderTraversal()
    {
        inOrderTraversalHelper(root);
    }
    
    /**
     * A recursive helper method for the inOrderTraversal method.
     * 
     * @param localRoot The node to begin the traversal.
     */
    private void inOrderTraversalHelper(BinNode<E> localRoot)
    {
    	if(localRoot == null)
    	{
    		return;
    	}
    	
    	inOrderTraversalHelper(localRoot.getLeft());
    	System.out.println(localRoot.getData().toString());
    	inOrderTraversalHelper(localRoot.getRight());
    }

}
