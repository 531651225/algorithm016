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
// 👍 690 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class ConstructBinaryTree {

  Map<Integer, Integer> dic = new HashMap();

  // 时间复杂度 o(n),n 是树中的节点个数

  // 空间复杂度 o(n),n 除去返回的答案需要的 O(n) 空间之外，
  // 我们还需要使用 O(n) 的空间存储哈希映射，
  // 以及 O(h)（其中 h 是树的高度）的空间表示递归时栈空间。
  // 这里 h<n ，所以总空间复杂度为 O(n)
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    for (int i = 0; i < inorder.length; i++) {
      dic.put(inorder[i], i);
    }
    return recur(preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1);

  }

  TreeNode recur(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft,
      int inRight) {
    if (preLeft > preRight || inLeft > inRight) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[preLeft]);
    int index = dic.get(root.val);
    int leftsubTreeSize = index - inLeft;

    // preLeft  + (index -inLeft) = preLeft- index-inLeft;
    root.left = recur(preorder, inorder, preLeft + 1, preLeft + leftsubTreeSize, inLeft, index - 1);
    root.right = recur(preorder, inorder, preLeft + leftsubTreeSize + 1, preRight, index + 1,
        inRight);
    return root;
  }
}
//leetcode submit region end(Prohibit modification and deletion)
