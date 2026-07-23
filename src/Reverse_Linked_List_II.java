public class Reverse_Linked_List_II {
    public static void main(String[] args) {
        ListNode node = new ListNode(10);
        node.next = new ListNode(20);
        node.next.next = new ListNode(30);
        node.next.next.next = new ListNode(40);
        node.next.next.next.next = new ListNode(50);
        elements(node);
        elements(reverseBetween(node,20,40));
    }
    //Extra LinkedList method
    //TC - O(N)
    //SC - O(N)
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newList = null;
        ListNode ptr = head;
        ListNode leftptr = null;
        while(ptr.next.val!=right){
            if(ptr.val==left){
                leftptr = ptr;
            }
            newList = insertAtBeginning(newList,ptr.val);
            ptr = ptr.next;
        }
        leftptr.next = newList;
        newList.next = ptr.next;
        return leftptr;
    }
    public static ListNode insertAtBeginning(ListNode head,int val){
        if(head==null){
            return new ListNode(val,null);
        } else{
            return new ListNode(val,head);
        }
    }
    public static void elements(ListNode head){
        ListNode ptr = head;
        while(ptr!=null){
            System.out.print(ptr.val+"->");
            ptr = ptr.next;
        }
        System.out.println(" ");
    }
}
