
//给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
// 示例 1:
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
//
// 示例 2:
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
// Related Topics 链表
// 👍 546 👎 0


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
class 重排链表 {
  public void reorderList(ListNode head) {
    ListNode newnode = new ListNode(-1);
    List<ListNode> list = new ArrayList();
    ListNode temp = head;
    while(temp != null) {
      list.add(temp);
      temp = temp.next;
    }
    int i = 0, j = list.size() - 1;
    while(j > i) {
      list.get(i).next = list.get(j);
      i++;
      list.get(j).next = list.get(i);
      j--;

    }
    list.get(i).next = null;



  }


//  主要是三步，举个例子。
//
//
//      1 -> 2 -> 3 -> 4 -> 5 -> 6
//  第一步，将链表平均分成两半
//1 -> 2 -> 3
//    4 -> 5 -> 6
//
//  第二步，将第二个链表逆序
//1 -> 2 -> 3
//    6 -> 5 -> 4
//
//  第三步，依次连接两个链表
//1 -> 6 -> 2 -> 5 -> 3 -> 4
//  第一步找中点的话，可以应用 19 题 的方法，快慢指针。快指针一次走两步，慢指针一次走一步，当快指针走到终点的话，慢指针会刚好到中点。如果节点个数是偶数的话，slow 走到的是左端点，利用这一点，我们可以把奇数和偶数的情况合并，不需要分开考虑。
//
//  第二步链表逆序的话，在 第 2 题 讨论过了，有迭代和递归的两种方式，迭代的话主要利用两个指针，依次逆转。
//
//  第三步的话就很简单了，两个指针分别向后移动就可以
//
//  作者：windliang
//  链接：https://leetcode-cn.com/problems/reorder-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-34/
//  来源：力扣（LeetCode）
//  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
  public void reorderList(ListNode head) {
    ListNode slow = head, fast = head, prev = head;
    while(fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    ListNode newnode = slow.next;
    slow.next = null;
    newnode = reverser(newnode);
    while(newnode != null) {
      ListNode temp = newnode.next;
      newnode.next = head.next;
      head.next = newnode;
      head = newnode.next;
      newnode = temp;

    }




  }

  ListNode reverser(ListNode head) {
    ListNode prev = null, cur = head;
    while(cur != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

