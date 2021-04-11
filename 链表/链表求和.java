
//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
//
//
//
// 进阶：
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
//
//
//
// 示例：
//
// 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 8 -> 0 -> 7
//
// Related Topics 链表
// 👍 368 👎 0


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
class 链表求和 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Deque<ListNode> stack1 = new LinkedList();
    Deque<ListNode> stack2 = new LinkedList();
    ListNode newnode = new ListNode(-1);
    build(l1, stack1);
    build(l2, stack2);
    int carry = 0;
    while(!stack1.isEmpty() || !stack2.isEmpty() || carry!= 0) {
      int num1 = stack1.isEmpty() ? 0 : stack1.pop().val;
      int num2 = stack2.isEmpty() ? 0 : stack2.pop().val;

      int sum = num1 + num2 + carry;
      ListNode node = new ListNode(sum % 10);
      carry = sum / 10;
      //头插法
      node.next = newnode.next;
      newnode.next = node;
    }
    return newnode.next;

  }

  void build(ListNode node, Deque stack) {
    while(node != null) {
      stack.push(node);
      node = node.next;
    }

  }
}
//leetcode submit region end(Prohibit modification and deletion)

