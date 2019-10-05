package testlist;

import java.util.List;

public class TestIsExistCircle {

    /**
     * 求解链表是否有环
     * 使用快慢指针的方法，如果是有环的话，那么就一定会碰撞，并且慢指针行走不会超过一圈
     *
     * @param head 链表头
     * @return 是否有环
     */
    public boolean hasCycle(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (slowNode != null && fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                return true;
            }
        }
        return false;
    }

    /**
     * 找到入环的第一个节点
     * 当快慢指针相遇之后。一个指针从相遇的位置继续走，一个指针从head 继续走，最后相遇的
     * 地点就是链表环的入口。这个过程中，在环内可能会走几圈。
     *
     * @param head 链表头
     * @return 环的入口节点
     */
    public ListNode cycleNode(ListNode head) {
        // 首先判断是否有环
        ListNode fastNode = head;
        ListNode slowNode = head;
        boolean hasCircle = false;
        while (slowNode != null && fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                hasCircle = true;
                break;
            }
        }

        // 如果没有环
        if(!hasCircle){
            return null;
        }

        // 如果有环，找到入口。
        // 这里已经没有快慢的含义，避免声明过多的变量
        fastNode = head;

        while(fastNode != slowNode){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return fastNode;
    }
}
