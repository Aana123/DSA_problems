public class Delete_Node_in_a_Linked_List {
    public static void main(String[] args) {
        //head = [4,5,1,9], node = 5
        //O/p - [4,1,9]
    }
    //most optimal approach
    //simply delete the element after the node after shifting its value and next in node
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    //my approach - shift all the node vals and delete the last node
    //TC - O(N)
    //SC - O(1)
    public void deleteNode1(ListNode node) {
        ListNode temp = node.next;
        while(temp.next!=null){
            node.val = temp.val;
            node = node.next;
            temp = node.next;
        }
        node.val = temp.val;
        node.next = null;
    }
}