package DSA_JAVA.java_files.DSA.trees;

public class Main {
    
    public static void main(String[] args) {
        // BinarySearchTree myBST=new BinarySearchTree();
        // System.out.println("Root: " + myBST.root);
        // System.out.println("**********************");

        // BinarySearchTree myBST=new BinarySearchTree();
        // myBST.insert(47);
        // myBST.insert(21);
        // myBST.insert(76);
        // myBST.insert(18);
        // myBST.insert(52);
        // myBST.insert(82);
        
        // myBST.insert(27);
        // System.out.println(myBST.root.left.right.value);
        // // System.out.println("Root: " + myBST.root);
        // System.out.println("**********************");

        // BinarySearchTree myBST=new BinarySearchTree();
        // myBST.insert(47);
        // myBST.insert(21);
        // myBST.insert(76);
        // myBST.insert(18);
        // myBST.insert(27);
        // myBST.insert(52);
        // myBST.insert(82);
        
        
        // System.out.println(myBST.contains(27));
        // System.out.println(myBST.contains(17));
        // // System.out.println("Root: " + myBST.root);
        // System.out.println("**********************");

        // BinarySearchTree myBST=new BinarySearchTree();
        // myBST.insert(47);
        // myBST.insert(21);
        // myBST.insert(76);
        // myBST.insert(18);
        // myBST.insert(27);
        // myBST.insert(52);
        // myBST.insert(82);
        
        // System.out.println("\nBST Contains 27:");
        // System.out.println(myBST.rContains(27));
        // System.out.println("\nBST Contains 17:");
        // System.out.println(myBST.rContains(17));
        // // System.out.println("Root: " + myBST.root);
        // System.out.println("**********************");

        // BinarySearchTree myBST=new BinarySearchTree();
        // myBST.rInsert(2);
        // myBST.rInsert(1);
        // myBST.rInsert(3);
        // /*
        //  * The LINE ABOVE CREATE THIS TREE:
        //  *              2
        //  *             / \
        //  *            1   3
        //  */
        // System.out.println("\nRoot: " + myBST.root.value);
        // System.out.println("\nRoot->Left: "+ myBST.root.left.value);
        // System.out.println("\nRoot->Right: " + myBST.root.right.value);
        // System.out.println("**********************");

        BinarySearchTree myBST=new BinarySearchTree();
        myBST.rInsert(2);
        myBST.rInsert(1);
        myBST.rInsert(3);
        /*
         * The LINE ABOVE CREATE THIS TREE:
         *              2
         *             / \
         *            1   3
         */
        System.out.println("\nRoot: " + myBST.root.value);
        System.out.println("\nRoot->Left: "+ myBST.root.left.value);
        System.out.println("\nRoot->Right: " + myBST.root.right.value);

        myBST.rDeleteNode(2);
        /*
         * The LINE ABOVE CREATE THIS TREE:
         *              3
         *             / \
         *            1   null
         */
        System.out.println("\nRoot: " + myBST.root.value);
        System.out.println("\nRoot->Left: "+ myBST.root.left.value);
        System.out.println("\nRoot->Right: " + myBST.root.right);
        System.out.println("**********************");

    } 
}
