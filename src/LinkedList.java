class Node{
    int data; //data of a node
    Node next; //reference/link to the next node
    Node(int x){
        data = x;
        next = null;
    }
}
public class LinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head = insertBeginning(head,0);
        insertEnd(head,40);
        elements(head);
    }
    //Insert at the beginning
    public static Node insertBeginning(Node head, int x){
        Node newNode = new Node(x);
        newNode.next = head;
        return newNode;
    }
    //Insert at the end
    public static void insertEnd(Node head, int x){
        Node ptr = head;
        while(ptr.next!=null){
            ptr = ptr.next;
        }
        Node newNode = new Node(x);
        newNode.next = null;
        ptr.next = newNode;
    }
    public static void elements(Node head){
        Node ptr = head;
        while(ptr!=null){
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }
}
