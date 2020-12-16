//给定一个二叉树，返回它的 后序 遍历。
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
//输出: [3,2,1]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树
// 👍 396 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Collections;
import java.util.LinkedList;
import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class PostorderTraversal {
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList();
//        if (root == null) {
//            return res;
//        }
//        LinkedList<TreeNode> stack = new LinkedList();
//        stack.addLast(root);
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.removeLast();
//            res.add(node.val);
//            if (node.left != null) {
//                stack.addLast(node.left);
//            }
//            if (node.right != null) {
//                stack.addLast(node.right);
//            }
//        }
//        Collections.reverse(res)
//        return res;
//    }

  // 时间复杂到o(n)
  // 空间复杂度o(n)
  public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<Integer> res = new LinkedList();
    if (root == null) {
      return res;
    }
    LinkedList<TreeNode> stack = new LinkedList();
    stack.addLast(root);
    while (!stack.isEmpty()) {
      TreeNode cur = stack.removeLast();
      //头插逆序 根右左
      res.addFirst(cur.val);
      if (cur.left != null) {
        stack.addLast(cur.left);
      }
      if (cur.right != null) {
        stack.addLast(cur.right);
      }
    }
    return res;
  }
}

}
//leetcode submit region end(Prohibit modification and deletion)
