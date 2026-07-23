public class Validate_Binary_Search_Tree {
    public static void main(String[] args) {
        TreeNode root = null;

        //       22
        //      /  \
        //     12   30
        //     / \
        //    8  20
        //       / \
        //      15  30

        root = insert(root, 5);
        root = insert(root, 1);
        root = insert(root, 4);
        root = insert(root, 3);
        root = insert(root, 6);

        System.out.println(isValidBST(root));
    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        return false;
    }


    //Incorrect logic !!
    //returns true for [5,4,6,null,null,3,7] -> checks only children!
    public static boolean isValidBST1(TreeNode root) {
        if(root.left==null && root.right==null) return true;
        if(root.left.val>root.val || root.right.val<root.val) return false;

        boolean l = isValidBST1(root.left);
        boolean r = isValidBST1(root.right);

        return (l && r);
    }


    static TreeNode insert(TreeNode node, int key){
        //Base condition
        if(node==null){
            return new TreeNode(key);
        }

        if(key<node.val){
            node.left = insert(node.left,key);
        } else if(key>node.val){
            node.right =  insert(node.right,key);
        }
        return node;
    }
}
