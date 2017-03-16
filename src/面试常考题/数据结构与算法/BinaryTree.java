package 面试常考题.数据结构与算法;

import algorithms.section_1.Stack;

/**
 * @author Administrator
 * @date 2017/3/13
 */
public class BinaryTree {

    private TreeNode root = null;

    public BinaryTree() {
        root = new TreeNode(1, "rootNode(A)");
    }

    /**
     * 创建一课二叉树
     *              A
     *           B      C
     *       D       E      F
     * @param root
     */
    public void createBinTree(TreeNode root) {
        TreeNode newNodeB = new TreeNode(2,"B");
        TreeNode newNodeC = new TreeNode(3,"C");
        TreeNode newNodeD = new TreeNode(4,"D");
        TreeNode newNodeE = new TreeNode(5,"E");
        TreeNode newNodeF = new TreeNode(6,"F");
        root.leftChild = newNodeB;
        root.rightChild = newNodeC;
        root.leftChild.leftChild = newNodeD;
        root.leftChild.rightChild = newNodeE;
        root.rightChild.rightChild = newNodeF;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private int height(TreeNode subTree) {
        if (subTree == null) {
            return 0;
        }else {
            int i = height(subTree.leftChild);
            int j = height(subTree.rightChild);
            return (i<j)?(j+1):(i+1);
        }
    }
    //树的高度
    public int height() {
        return height(root);
    }

    private int size(TreeNode subTree) {
        if (subTree == null) {
            return 0;
        } else {
            return 1 + size(subTree.leftChild)
                    + size(subTree.rightChild);
        }
    }

    //树的节点数
    public int size() {
        return size(root);
    }

    private TreeNode parent(TreeNode subTree, TreeNode element) {
        if (subTree == null) {
            return null;
        }
        if (subTree.leftChild == element || subTree.rightChild == element) {
            //返回父节点
            return subTree;
        }
        TreeNode p;
        //现在在左子树中找，如果在左子树中没找到才去右子树找
        if ((p = parent(subTree.leftChild, element)) != null) {
            //递归在左子树中搜索
            return p;
        } else {
            ////递归在右子树中搜索
            return parent(subTree.rightChild, element);
        }
    }

    //返回双亲节点
    public TreeNode parent(TreeNode element) {
        return (root == null || root == element) ? null : parent(root, element);
    }

    public TreeNode getLeftChildNode(TreeNode element) {
        return (element != null) ? element.leftChild : null;
    }

    public TreeNode getRrightChildNode(TreeNode element) {
        return (element != null) ? element.rightChild : null;
    }

    public TreeNode getRoot() {
        return root;
    }

    //释放某个结点时，该节点的左右子树已经释放
    //所以应该采用后续遍历，当访问某个结点时将该结点的访问空间释放
    public void destroy(TreeNode subTree) {
        //删除根为subTree的子树
        if (subTree != null) {
            //删除左子树
            destroy(subTree.leftChild);
            //删除右子树
            destroy(subTree.rightChild);
            //删除根结点
            subTree = null;
        }
    }

    public void traverse(TreeNode subTree) {
        System.out.println("Key:" + subTree.key + "--name:" + subTree.data);
        traverse(subTree.leftChild);
        traverse(subTree.rightChild);
    }

    public void viseted(TreeNode subTree) {
        subTree.isVisted = true;
        System.out.println("key:" + subTree.key + "--name:" + subTree.data);
    }

    //前序遍历
    public void preOrder(TreeNode subTree) {
        if (subTree != null) {
            viseted(subTree);
            preOrder(subTree.leftChild);
            preOrder(subTree.rightChild);
        }
    }

    //前序遍历的非递归实现
    public void nonRecPreOrder(TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = p;
        while (node != null || stack.size() >0) {
            while (node != null){
                viseted(node);
                stack.push(node);
                node = node.leftChild;
            }
            while(stack.size()>0){
                node=stack.pop();
                node=node.rightChild;
                while(node!=null){
                     viseted(node);
                    stack.push(node);
                    node=node.leftChild;
                }
            }
        }
    }
    //中序遍历
    public void inOrder(TreeNode subTree) {
        if (subTree != null) {
            inOrder(subTree.leftChild);
            viseted(subTree);
            inOrder(subTree.rightChild);
        }
    }

    //中序遍历的非递归实现
    public void nonRecInOrder(TreeNode p){
        Stack<TreeNode> stack =new Stack<BinaryTree.TreeNode>();
        TreeNode node =p;
        while(node!=null||stack.size()>0){
            //存在左子树
            while(node!=null){
                stack.push(node);
                node=node.leftChild;
            }
            //栈非空
            if(stack.size()>0){
                node=stack.pop();
                viseted(node);
                node=node.rightChild;
            }
        }
    }

    //后续遍历
    public void postOrder(TreeNode subTree) {
        if (subTree != null) {
            postOrder(subTree.leftChild);
            postOrder(subTree.rightChild);
            viseted(subTree);
        }
    }

    //后序遍历的非递归实现
    public void noRecPostOrder(TreeNode p){
        Stack<TreeNode> stack=new Stack<BinaryTree.TreeNode>();
        TreeNode node =p;
        while(p!=null){
            //左子树入栈
            for(;p.leftChild!=null;p=p.leftChild){
                stack.push(p);
            }
            //当前结点无右子树或右子树已经输出
            while(p!=null&&(p.rightChild==null||p.rightChild==node)){
                viseted(p);
                //纪录上一个已输出结点
                node =p;
                if(stack.isEmpty())
                    return;
                p=stack.pop();
            }
            //处理右子树
            stack.push(p);
            p=p.rightChild;
        }
    }

    /**
     * 二叉树的节点数据结构
     */
    private class TreeNode {
        private int key = 0;
        private String data = null;
        private boolean isVisted = false;
        private TreeNode leftChild = null;
        private TreeNode rightChild = null;

        public TreeNode() {
        }

        /**
         *
         * @param key   层序编码
         * @param data  数据域
         */
        public TreeNode(int key, String data) {
            this.key = key;
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinTree(bt.root);
        System.out.println("the size of the tree is " + bt.size());
        System.out.println("the height of the tree is " + bt.height());
        System.out.println("*******(前序遍历)[ABDECF]遍历*****************");
        bt.preOrder(bt.root);

        System.out.println("*******(中序遍历)[DBEACF]遍历*****************");
        bt.inOrder(bt.root);

        System.out.println("*******(后序遍历)[DEBFCA]遍历*****************");
        bt.postOrder(bt.root);

        System.out.println("***非递归实现****(前序遍历)[ABDECF]遍历*****************");
        bt.nonRecPreOrder(bt.root);

        System.out.println("***非递归实现****(中序遍历)[DBEACF]遍历*****************");
        bt.nonRecInOrder(bt.root);

        System.out.println("***非递归实现****(后序遍历)[DEBFCA]遍历*****************");
        bt.noRecPostOrder(bt.root);
    }
}
