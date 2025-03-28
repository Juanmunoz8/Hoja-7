public class BinarySearchTree<E extends Comparable<E>> {
    private class Node {
        E data;
        Node left, right;

        Node(E data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root;

    public void insert(E data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, E data) {
        if (root == null) return new Node(data);
        if (data.compareTo(root.data) < 0) root.left = insertRec(root.left, data);
        else if (data.compareTo(root.data) > 0) root.right = insertRec(root.right, data);
        return root;
    }

    public E search(E key) {
        return searchRec(root, key);
    }

    private E searchRec(Node root, E key) {
        if (root == null) return null;
        int cmp = key.compareTo(root.data);
        if (cmp == 0) return root.data;  // Encontrado
        return (cmp < 0) ? searchRec(root.left, key) : searchRec(root.right, key);
    }

    public void inOrderTraversal() {
        inOrderTraversalRec(root);
    }
    
    private void inOrderTraversalRec(Node root) {
        if (root != null) {
            inOrderTraversalRec(root.left);
            System.out.println(root.data);  // Imprime el producto en orden
            inOrderTraversalRec(root.right);
        }
    }
}

