import java.util.ArrayList;

//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//给定如下二叉树，以及目标和 sum = 22，
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//
//
// 返回:
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
//
// Related Topics 树 深度优先搜索
// 👍 408 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class 路径总和2 {
  List<List<Integer>> res = new ArrayList<>();
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    pathSum(root, sum, new ArrayList<>(), 0);
    return res;
  }


  public void pathSum(TreeNode root, int sum, List<Integer> temp, int sumtmp) {
    if(root == null) return;
    temp.add(root.val);
    int total = sumtmp + root.val;
    if(root.left == null && root.right == null) {
      if(total == sum ) {
        res.add(new ArrayList<>(temp));
        temp.remove(temp.size() - 1);
        return;
      }
    }

    pathSum(root.left, sum, temp, root.val + sumtmp);
//        temp.remove(temp.size() - 1);
    pathSum(root.right, sum, temp, root.val + sumtmp);
    temp.remove(temp.size() - 1);
  }


}
//leetcode submit region end(Prohibit modification and deletion)

