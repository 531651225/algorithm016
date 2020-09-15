//给定一个二叉树，返回它的中序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 哈希表
// 👍 700 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//时间复杂度 o(n) 每个节点会被访问一次且仅会被遍历一次
//空间复杂度 o(n) 空间复杂度取决于栈深度，而栈深度在二叉树为一条链的情况下会达到 O(n) 的级别
class InorderTraversal {
  public List<Integer> inorderTraversal(TreeNode root) {
    LinkedList<TreeNode> stack = new LinkedList();
    TreeNode cur = root;
    List<Integer> res = new ArrayList();
    while (!stack.isEmpty() || cur != null) {
      while (cur != null) {
        stack.addLast(cur);
        cur = cur.left;
      }

      TreeNode node = stack.getLast();
      res.add(node.val);

      if (node.right != null) {
        cur = node.right;
      }
    }
    return res;
  }
}
//leetcode submit region end(Prohibit modification and deletion)
