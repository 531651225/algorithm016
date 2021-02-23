
//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
// 说明:
//1 ≤ m ≤ n ≤ 链表长度。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL
// Related Topics 链表
// 👍 669 👎 0


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
class 反转链表2 {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    if(head == null) {
      return null;
    }

    ListNode cur = head, prev = null;
    for (int i = 0; i < m - 1 ; i++) {
      prev = cur;
      cur = cur.next;

    }
    int count = n - m + 1;
    ListNode con = prev, tail = cur;

    while(count > 0) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
      count--;
    }
    if (con != null) {
      con.next = prev;
    } else {
      head = prev;
    }

    tail.next = cur;
    return head;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

