package BST;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Ling
 * Created on 2019/10/19
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 向二叉搜索树中添加新的元素
    public void add(E e) {
//        if (root == null) {
//            root = new Node(e);
//            size++;
//        } else {
//            add(root, e);
//        }
        root = add(root, e);
    }

    // 返回插入新节点后二叉搜索树的根
    private Node add(Node node, E e) {
//        // 终止条件
//        if (e.equals(root.e)) {
//            return;
//        } else if (e.compareTo(root.e) < 0 && root.left == null) {
//            root.left = new Node(e);
//            size++;
//            return;
//        } else if (e.compareTo(root.e) > 0 && root.right == null) {
//            root.right = new Node(e);
//            size++;
//            return;
//        }
//        // 递归调用
//        if (e.compareTo(root.e) < 0)
//            add(root.left, e);
//        else       // e.compareTo(root.e) > 0;
//            add(root.right,e);

        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null)
            return false;

        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) > 0)
            return contains(node.right, e);
        else
            return contains(node.left, e);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node==null)
            return;

        // 访问该节点
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }


    // 前序遍历的非递归写法
    public void preOrderNR() {
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.empty()) {
            Node cur = s.pop();
            System.out.println(cur.e);
            if (cur.right != null)
                s.push(cur.right);
            if (cur.left != null)
                s.push(cur.left);
        }
    }

    // 中序遍历，BST中序遍历的结果是排好了序
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node==null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node cur  = q.remove();
            System.out.println(cur.e);
            if (cur.left != null)
                q.add(cur.left);
            if (cur.right != null)
                q.add(cur.right);
        }
    }
}
