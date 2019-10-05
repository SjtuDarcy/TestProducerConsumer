package testlist;

public class ListNode {
    public ListNode next;
    public int data;

    public ListNode(int data) {
        this.data = data;
        next = null;
    }
}

//public class ListNode<T> {
//    public ListNode<T> next;
//    public T data;
//
//    public ListNode(T data) {
//        this.data = data;
//        next = null;
//    }
//}