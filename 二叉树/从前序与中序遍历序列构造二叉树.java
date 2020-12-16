import java.util.HashMap;
//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics 树 深度优先搜索 数组
// 👍 791 👎 0


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
class 从前序与中序遍历序列构造二叉树 {
  Map<Integer, Integer> dic = new HashMap<>();
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    for (int i = 0; i < inorder.length; i++) {
      dic.put(inorder[i], i);
    }
    return buildTree(preorder, inorder, 0,
        preorder.length - 1, 0, preorder.length - 1);


  }
  public TreeNode buildTree(int[] preorder, int[] inorder, int pleft, int pright, int ileft, int iright) {
    if (pleft > pright || ileft > iright) return null;
    int val = preorder[pleft];
    int index = dic.get(val);
    TreeNode root = new TreeNode(val);
    int leftSubTreeSize = index - 1 - ileft + 1;
    //pright = (pleft + 1) + leftSubTreeSize - 1 = pleft + leftSubTreeSize
    root.left = buildTree(preorder, inorder, pleft + 1, pleft + leftSubTreeSize,
        ileft, index - 1);
    root.right =  buildTree(preorder, inorder, pleft  + leftSubTreeSize + 1, pright, index + 1, iright);

    return root;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

