package algorithms.section_3;

import java.util.Queue;

/**
 * @author Administrator
 * @date 2017/3/17
 */
public class BST<Key extends Comparable<Key>, Value> {

    private Node root;  //二叉树的根结点
    private class Node {
        private Key key;    //键
        private Value val;  //值
        private Node left, right;   //指向子树的链接
        private int N;  //以该结点为根的子树中的结点总数

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            N = n;
        }
    }

    public int size() {
        return size(root);
    }
    public int size(Node x) {
        if (x == null)  return 0;
        else return x.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }
    private Value get(Node x, Key key) {
        //如果找不到就返回null
        if (x ==null)   return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)    return get(x.left, key);
        else if (cmp > 0)   return get(x.right, key);
        else return x.val;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }
    public Node put(Node x, Key key, Value val) {
        if (x == null)  return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)    x.left = put(x.left, key, val);
        if (cmp > 0)    x.right = put(x.right, key, val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min() {
        return min(root).key;
    }
    public Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null)  return null;
        return x.key;
    }
    public Node floor(Node x, Key key) {
        if (x == null)  return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)   return x;
        if (cmp < 0)    return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null)  return t;
        else    return x;
    }

    public Key select(int k) {
        return select(root, k).key;
    }
    public Node select(Node x, int k) {
        //返回排名为k的节点
        if (x == null)  return null;
        int t = size(x.left);
        if (t > k)  return select(x.left, k);
        else if (t < k) return select(x.right, k-t-1);
        else return x;
    }

    public int rank(Key key) {
        return rank(key, root);
    }
    public int rank(Key key, Node x) {
        //返回以x为根结点的子树中小于x.key的键的数量
        if (x == null)  return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)    return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }
    private Node deleteMin(Node x) {
        //删除最小节点
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }
    private Node delete(Node x, Key key) {
        //删除指定节点
        if (x == null)  return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)    x.left = delete(x.left, key);
        else if (cmp > 0)    x.right = delete(x.right, key);
        else {
            if (x.right == null)    return x.left;
            if (x.left == null)    return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

//    public Iterable<Key> keys() {
//
//    }
//    public Iterable<Key> kyes(Key lo, Key hi) {
//        Queue<Key> queue = new Queue<Key>();
//
//    }
//    public void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
//        if (x == null)  return;
//        int cmplo = lo.compareTo(x.key);
//        int cmphi = hi.compareTo(x.key);
//        if (cmplo < 0)  keys(x.left, queue, lo, hi);
//        if (cmplo <=0 && cmphi >=0) queue.add(x.key);
//        if (cmphi > 0)  keys(x.right, queue, lo, hi);
//    }
public static void main(String[] args) {
    BST b = new BST();
   b.put("S", "S");
   b.put("X", "X");
   b.put("E", "E");
   b.put("A", "A");
   b.put("C", "C");
   b.put("R", "R");
   b.put("H", "H");
   b.put("M", "M");
   b.delete("E");
   System.out.println(b.size());
}
}
