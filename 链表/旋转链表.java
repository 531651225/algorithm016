//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
//
//
// 示例 2:
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL
// Related Topics 链表 双指针
// 👍 410 👎 0


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
class 旋转链表 {


  //这题k是非负数，但k有可能比链表的长度还要大，所以先要计算链表的长度len，需要旋转的步数就是（k%len）。一种比较简单的方式就是先把链表连接成一个环，然后再把链表在某个合适的位置断开。
  //
  //我们可以使用两个指针，一个快指针fast从头开始遍历直到走到链表的末尾，然后再把链表串成一个环形。还一个指针slow也是从头开始，走（len-k%len）步就是我们要返回的链表头，这里可能有点疑问，为什么不是走（k%len）步，这是因为我们需要把链表后面的（k%len）个移到前面，因为单向链表我们没法从后往前遍历，所以我们只能从前往后移动（len-k%len）步。但实际上操作的时候会少走一步，具体来举个例子看一下，这里就以示例1为例画个图来看一下
  //
  //作者：sdwwld
  //链接：https://leetcode-cn.com/problems/rotate-list/solution/61-xuan-zhuan-lian-biao-tu-wen-xiang-jie-by-sdwwld/
  //来源：力扣（LeetCode）
  //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
  public ListNode rotateRight(ListNode head, int k) {
    if(head == null || head.next == null) {
      return head;
    }
    ListNode fast = head, slow = head;
    int len = 1;
    while(fast.next != null) {
      fast = fast.next;
      len++;
    }
    //首尾相连，先构成环
    fast.next = head;
    //慢指针移动的步数
    int step = len - k % len;
    //移动步数，这里大于1实际上是少移了一步
    for (int i = 0; i < step - 1 ; i++) {
      slow = slow.next;
    }
    //temp就是需要返回的结点
    ListNode temp = slow.next;
    //因为链表是环形的，slow就相当于尾结点了，
    //直接让他的next等于空
    slow.next = null;
    return temp;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

