package tv.dzj.java.leetcode;

/**
 * 判断链表是否存在环
 * 141. Linked List Cycle (Easy)
 * 使用双指针，一个指针每次移动一个节点，一个指针每次移动两个节点，如果存在环，那么这两个指针一定会相遇。
 * @Author: <a href="daizengjie@gmail.com">dzj</a>
 */
public class HasCycle {
    public boolean hasCycle(ListNode head){
        if(head == null){
            return false;
        }
        ListNode l1 = head;
        ListNode l2 = head.next;

        while(l1 != null && l2 != null && l2.next != null){
            if(l1 == l2){
                return false;
            }
            l1 = l1.next;
            l2 = l2.next.next;
        }
        return false;
    }

    class ListNode<T>{
        T value;
        ListNode next;
    }
}
