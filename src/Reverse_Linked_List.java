class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Reverse_Linked_List {
    public static void main(String[] args) {
        ListNode node = new ListNode(10);
        node.next = new ListNode(20);
        node.next.next = new ListNode(30);
        node.next.next.next = new ListNode(40);
        node.next.next.next.next = new ListNode(50);
        elements(node);
        elements(reverseList(node));
    }
    //In-place method
    //TC - O(N)
    //SC - O(1)
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode nextTemp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTemp;
        }
        return prev;
    }
    //Extra LinkedList method
    //TC - O(N)
    //SC - O(N)
    public static ListNode reverseList1(ListNode head) {
        ListNode newList = null;
        ListNode ptr = head;
        while(ptr!=null){
            newList = insertAtBeginning(newList,ptr.val);
            ptr = ptr.next;
        }
        return newList;
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
