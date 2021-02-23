
//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
// 进阶：
//
//
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
//
//
//
//
// 示例 1：
//
//
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
//
//
// 示例 2：
//
//
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
//
//
// 示例 3：
//
//
//输入：head = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 5 * 104] 内
// -105 <= Node.val <= 105
//
// Related Topics 排序 链表
// 👍 991 👎 0


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
class 排序链表 {
  public ListNode sortList(ListNode head) {
    return mergeSort(head);
  }

  ListNode mergeSort(ListNode head) {
    if(head == null || head.next == null) {
      return head;
    }
    ListNode fast = head, slow = head, prev = head;
    while(fast != null && fast.next != null) {
      prev = slow;
      fast = fast.next.next;
      slow = slow.next;
    }
    prev.next = null;
    ListNode h1 = mergeSort(head);
    ListNode h2 = mergeSort(slow);
    return merge(h1, h2);


  }

  ListNode merge(ListNode head1, ListNode head2) {
    ListNode newnode = new ListNode(-1);
    ListNode temp = newnode;

    while(head1 != null && head2 != null) {
      if(head1.val > head2.val) {
        temp.next = head2;
        head2 = head2.next;
      } else {
        temp.next = head1;
        head1 = head1.next;
      }
      temp = temp.next;
    }

    if(head1 != null) {
      temp.next = head1;
    } else {
      temp.next = head2;
    }

    return newnode.next;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

