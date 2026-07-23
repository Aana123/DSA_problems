import java.util.Scanner;

public class Trees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        insert(sc);
        display();
    }
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value){
            this.val = value;
        }
    }
    private static TreeNode root;

    //insert elements
    public static void insert(Scanner sc){
        System.out.println("Enter the root val: ");
        int val = sc.nextInt();
        root = new TreeNode(val);
        populate(sc,root);
    }
    private static void populate(Scanner sc, TreeNode node){
        System.out.println("Do you want to enter left of: " + node.val);
        boolean left = sc.nextBoolean();
        if(left){
            System.out.println("Enter the value of left of: "+ node.val);
            int value = sc.nextInt();
            node.left = new TreeNode(value);
            populate(sc,node.left);
        }

        System.out.println("Do you want to enter right of: " + node.val);
        boolean right = sc.nextBoolean();
        if(right){
            System.out.println("Enter the value of right of: "+ node.val);
            int value = sc.nextInt();
            node.right = new TreeNode(value);
            populate(sc,node.right);
        }
    }
    public static void display(){
        display(root,"");
    }
    private static void display(TreeNode node, String indent){
        if(node==null) return;
        System.out.println(indent+node.val);
        display(node.left,"\t"+indent);
        display(node.right,indent+"\t");
    }
}
