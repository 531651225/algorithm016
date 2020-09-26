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
// 👍 370 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class ConstructBinaryTree2 {

//    ileft     index          iright
//    [9,    3,15,20,    7]
//    [9,    15,7,20,    3]
//    pleft               pright

  Map<Integer, Integer> dic = new HashMap<>();

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    for (int i = 0; i < inorder.length; i++) {
      dic.put(inorder[i], i);
    }
    return recur(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
  }

  TreeNode recur(int[] inorder, int[] postorder, int ileft,
      int iright, int pleft, int pright) {
    if (ileft > iright || pleft > pright) {
      return null;
    }
    TreeNode root = new TreeNode(postorder[pright]);
    int index = dic.get(root.val);
    int iLeftSubSize = index - ileft;

    root.left = recur(inorder, postorder, ileft, index - 1,
        pleft, pleft + iLeftSubSize - 1);

    root.right = recur(inorder, postorder, index + 1, iright,
        pleft + iLeftSubSize, pright - 1);
    return root;
  }


}
//leetcode submit region end(Prohibit modification and deletion)
