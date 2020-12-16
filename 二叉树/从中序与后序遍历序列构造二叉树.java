import java.util.HashMap;

//根据一棵树的中序遍历与后序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// Related Topics 树 深度优先搜索 数组
// 👍 419 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class 从中序与后序遍历序列构造二叉树 {
  Map<Integer, Integer> dic = new HashMap<>();
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    for (int i = 0; i < inorder.length; i++) {
      dic.put(inorder[i], i);
    }
    return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
  }

  TreeNode buildTree(int[] inorder, int[] postorder, int pleft, int pright, int ileft, int iright) {
    if (ileft > iright || pleft > pright) {
      return null;
    }
    int val = postorder[pright];
    int index = dic.get(val);
    TreeNode root = new TreeNode(val);
    int leftSubTreeSize = index - ileft;
    root.left = buildTree(inorder, postorder, pleft, pleft + leftSubTreeSize - 1, ileft, index - 1);
    root.right = buildTree(inorder, postorder, pleft + leftSubTreeSize, pright - 1, index + 1, iright);
    return root;

  }


}
//leetcode submit region end(Prohibit modification and deletion)
