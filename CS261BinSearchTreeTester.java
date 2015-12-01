import java.util.Random;
/**
 *Test BinTree and BinNode classes
 *
 * @author CS261 
 * @version 2011.10.28
 */
public class CS261BinSearchTreeTester 
{
    BinNode<String>[] nodeArray;
    CS261BinSearchTree<String>[] treeArray;

    String[] testStrings = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

    CS261BinSearchTree<String>  t1;
    CS261BinSearchTree<String>  t2;
    CS261BinSearchTree<String>  t3;
    Random randGen;
    
    /**
     * mainline
     */
    public static void main(String args[])
    {
        CS261BinSearchTreeTester bst = new CS261BinSearchTreeTester();
    }
    /**
     * Constructor for objects of class Test
     */
    public CS261BinSearchTreeTester()
    {

        nodeArray = new BinNode[10];
        //make a bunch of nodes
        for (int i = 0; i < nodeArray.length; i ++)
        {
            nodeArray[i] = new BinNode(testStrings[i]);
        }

        System.out.println("=================================================");

        ///////////////////////////////////////////////////////////////////////
        //
        //       Test 1: sequential add
        //
        //////////////////////////////////////////////////////////////////////
        System.out.println("\n\nTesting add in order...\n\n");
        // Test: always add on left
        t1 = new CS261BinSearchTree<String>();
        for (int i =  0; i < nodeArray.length; i++)
        {
            System.out.println("Adding: " + testStrings[i]);
            t1.add(testStrings[i]);
        }
        System.out.println("Done. \nSize of t1: " + t1.size());
        System.out.println("inorder traversal: ");
        t1.inOrderTraversal();
        System.out.println("\n Done.");

        System.out.println("=================================================");

        ///////////////////////////////////////////////////////////////////////
        //
        //       Test 2: random add
        //
        //////////////////////////////////////////////////////////////////////
        System.out.println("\n\nTesting add in random order...\n\n");
        // Test: random add
        randGen = new Random();
        t2 = new CS261BinSearchTree<String>();
        for (int i =  0; i < nodeArray.length; i++)
        {
            int toAdd = randGen.nextInt(testStrings.length);
            boolean added = t2.add(testStrings[toAdd]);
            System.out.println("Adding " + testStrings[toAdd] + " returns " + added);

        }
        System.out.println("Size of t2: " + t2.size());
        System.out.println("inorder traversal: ");
        t2.inOrderTraversal();
        System.out.println("\n Done.");
        System.out.println("=================================================");

        ///////////////////////////////////////////////////////////////////////
        //
        //       Test 3: contains() test
        //
        //////////////////////////////////////////////////////////////////////
        System.out.println("\n\nTesting contains...\n\n");
        System.out.println("inorder traversal: ");
        t2.inOrderTraversal();
        System.out.println("\n");
        //Test contains
        for (int i = 0; i < testStrings.length; i = i + 1)
        {
            System.out.println("Search for (contains): " + testStrings[i] + " returns " + t2.contains(testStrings[i]));
        }
        System.out.println("\n Done.");

        System.out.println("=================================================");

        ///////////////////////////////////////////////////////////////////////
        //
        //       Test 4: find() test
        //
        //////////////////////////////////////////////////////////////////////
        System.out.println("\n\nTesting find...\n\n");
        System.out.println("inorder traversal: ");
        t2.inOrderTraversal();
        System.out.println("\n");

        //Test find
        for (int i = 0; i < testStrings.length; i = i + 1)
        {
            System.out.println("Search for (find): " + testStrings[i] + " returns " + t2.find(testStrings[i]));
        }
        System.out.println("\n Done.");

        System.out.println("=================================================");

        ///////////////////////////////////////////////////////////////////////
        //
        //       Test 6: simple remove test
        //
        //////////////////////////////////////////////////////////////////////

        // make a simple tree with two nodes
        System.out.println("\n\nRemoval Test. Initial build of tree. Add nodes...\n\n");
        // Test: always add on left
        t3 = new CS261BinSearchTree<String>();
        for (int i =  0; i < testStrings.length; i++)
        {
            t3.add(testStrings[randGen.nextInt(testStrings.length)]);
        }
        System.out.println("Size of t3: " + t3.size());
        System.out.println("inorder traversal: ");
        t3.inOrderTraversal();
        System.out.println("\n Done.");

        System.out.println("=================================================");
        System.out.println("\n\nTesting remove...\n\n");
        System.out.println("inorder traversal: ");
        t3.inOrderTraversal();
        System.out.println("\n");
        System.out.println("preorder traversal: ");
        t3.preOrderTraversal();
        System.out.println("\n");
        System.out.println("postorder traversal: ");
        t3.postOrderTraversal();
        System.out.println("\n");

        //Test remove
        for (int i = 0; i < testStrings.length; i = i + 1)
        {
            System.out.println("Test " + i + " ==========================\nSize of t3: " + t3.size()); 
            System.out.println("Before remove inorder traversal: ");

            t3.inOrderTraversal();
            System.out.println("\n");
            System.out.println("Removing: " + testStrings[i] + " returns " + t3.remove(testStrings[i]));
             System.out.println("Size of t3: " + t3.size());
            System.out.println("After removal inorder traversal: ");

            t3.inOrderTraversal();
            System.out.println("\n");
        }

        System.out.println("\n Done.");
    }
}
