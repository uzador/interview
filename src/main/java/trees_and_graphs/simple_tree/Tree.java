package trees_and_graphs.simple_tree;

public class Tree {
    public TreeNode root;

    public void inOrderTraversal(final TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            visit(node);
            inOrderTraversal(node.right);
        }
    }

    public void preOrderTraversal(final TreeNode node) {
        if (node != null) {
            visit(node);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void postOrderTraversal(final TreeNode node) {
        if (node != null) {
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
            visit(node);
        }
    }

    public void visit(final TreeNode node) {
        System.out.print(node.name + " ");
    }

    public void inOrderTraversal() {
        this.inOrderTraversal(root);
    }

    public void preOrderTraversal() {
        this.preOrderTraversal(root);
    }

    public void postOrderTraversal() {
        this.postOrderTraversal(root);
    }
}
