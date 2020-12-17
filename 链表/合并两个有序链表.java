//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// Related Topics 链表
// 👍 1441 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class 合并两个有序链表 {
  //迭代
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode newnode = new ListNode(-1);
    ListNode cur = newnode;
    while (l1 != null && l2 != null) {
      if (l1.val > l2.val) {
        cur.next = new ListNode(l2.val);
        l2 = l2.next;
      } else {
        cur.next = new ListNode(l1.val);
        l1 = l1.next;
      }
      cur = cur.next;
    }
    cur.next = l1 != null ? l1 : l2;
    return newnode.next;
  }
  //递归
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    } else if (l2 == null) {
      return l1;
    }
    if (l1.val > l2.val) {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    } else {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;

    }
  }

}
//leetcode submit region end(Prohibit modification and deletion)
