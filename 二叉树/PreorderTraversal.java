//给定一个二叉树，返回它的 前序 遍历。
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
//输出: [1,2,3]
//
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树
// 👍 367 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 时间复杂度 o(n)
// 空间复杂度 o(n)
class PreorderTraversal {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList();
    if (root == null) {
      return res;
    }
    LinkedList<TreeNode> stack = new LinkedList();
    stack.addLast(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.removeLast();
      res.add(node.val);
      if (node.right != null) {
        stack.addLast(node.right);
      }
      if (node.left != null) {
        stack.addLast(node.left);
      }
    }
    return res;
  }
}
//leetcode submit region end(Prohibit modification and deletion)
