class Node {
    int data;
    Node Left;
    Node Right;

    Node(int value) {
        this.data = value;
        this.Left = null;
        this.Right = null;
    }
}

class BinarySearchTree {
    Node root = null;

    void Insert(int value) {
        root = InsertValue(this.root, value);
    }

    Node InsertValue(Node root, int value) {
        if (root == null) {
            root = new Node(value);
        } else if (value < root.data) {
            root.Left = InsertValue(root.Left, value);
        } else {
            root.Right = InsertValue(root.Right, value);
        }
        return root;
    }

    void InOrder(Node root) {
        if (root == null) {
            return;
        }
        InOrder(root.Left);
        System.out.print(root.data + "\t");
        InOrder(root.Right);
    }

    void Delete(int value) {
        root = DeleteNode(root, value);
    }

    Node DeleteNode(Node root, int value) {
        if (root == null) {
            return root;
        }
        if (value < root.data) {
            root.Left = DeleteNode(root.Left, value);
        } else if (value > root.data) {
            root.Right = DeleteNode(root.Right, value);
        } else {
            if (root.Left == null) {
                return root.Right;
            } else {
                return root.Left;
            }
        }
        return root;
    }

}

public class test9 {

    public static void main(String[] args) {
        BinarySearchTree bt = new BinarySearchTree();
        bt.Insert(23);
        bt.Insert(56);
        bt.Insert(32);
        bt.Insert(12);
        bt.Insert(22);
        bt.Insert(10);

        bt.InOrder(bt.root);
        bt.Delete(56);
        System.out.println();
        bt.InOrder(bt.root);

    }

}
