package trees_and_graphs.simple_tree;

public class TreeApp {
    public static void main(String[] args) {
        final Tree tree = new Tree();
        final TreeNode root = new TreeNode();
        final TreeNode n1 = new TreeNode();
        final TreeNode n2 = new TreeNode();
        final TreeNode n3 = new TreeNode();
        final TreeNode n4 = new TreeNode();
        final TreeNode n5 = new TreeNode();
        final TreeNode n6 = new TreeNode();

        root.name = "A";
        n1.name = "1";
        n2.name = "2";
        n3.name = "3";
        n4.name = "4";
        n5.name = "5";
        n6.name = "6";
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;

        tree.root = root;
        tree.inOrderTraversal();
        System.out.println();
        tree.preOrderTraversal();
        System.out.println();
        tree.postOrderTraversal();
    }
}
