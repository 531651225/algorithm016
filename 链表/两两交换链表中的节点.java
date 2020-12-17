//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
//
//
// 示例 2：
//
//
//输入：head = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 100] 内
// 0 <= Node.val <= 100
//
// Related Topics 链表
// 👍 760 👎 0


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
class 两两交换链表中的节点 {
  public ListNode swapPairs(ListNode head) {
    ListNode start = head, end = head;
    for (int i = 0; i < 2; i++) {
      if (end == null) {
        return start;
      }
      end = end.next;
    }
    ListNode node = reverse(start, end);
    start.next = swapPairs(end);
    return node;

  }

  ListNode reverse(ListNode start, ListNode end) {
    ListNode prev = null, cur = start;
    while(cur != end) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }




}
//leetcode submit region end(Prohibit modification and deletion)
