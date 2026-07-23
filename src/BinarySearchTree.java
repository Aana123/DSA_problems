public class BinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = null;

        // Create BST
        //       22
        //      /  \
        //     12   30
        //     / \
        //    8  20
        //       / \
        //      15  30

        root = insert(root, 22);
        root = insert(root, 12);
        root = insert(root, 30);
        root = insert(root, 8);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 15);

        System.out.println(isPresent(root,8));
    }
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value){
            this.val = value;
        }
    }

    //Recursive approach
    //TC - O(h)
    //h is the height of the bst
    //SC - O(1)
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

    private static boolean ans;
    static boolean isPresent(TreeNode treeNode, int key){
        if(treeNode == null) return false;
        if(treeNode.val == key) return true;

        if(key<treeNode.val){
            ans = isPresent(treeNode.left,key);
        } else{
            ans = isPresent(treeNode.right,key);
        }

        return ans;
    }
    //Iterative approach
    static TreeNode insert1(TreeNode node, int key){
        TreeNode temp = new TreeNode(key);
        if(node==null){
            return temp;
        }

        TreeNode ptr = node;
        while(ptr!=null){
            if(key<ptr.val && ptr.left!=null){
                ptr = ptr.left;
            } else if(key>ptr.val && ptr.right!=null){
                ptr = ptr.right;
            } else{
                break;
            }
        }

        if(ptr.val>key){
            ptr.left=temp;
        }else{
            ptr.right=temp;
        }

        return node;
    }
}
