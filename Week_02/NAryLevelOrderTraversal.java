//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其层序遍历:
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
//
//
//
//
// 说明:
//
//
// 树的深度不会超过 1000。
// 树的节点总数不会超过 5000。
// Related Topics 树 广度优先搜索
// 👍 109 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class NAryLevelOrderTraversal {

  //时间复杂度 o(n)
  //空间复杂度 o(n)
  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> res = new ArrayList();
    if (root == null) {
      return res;
    }
    LinkedList<Node> queue = new LinkedList();
    queue.addLast(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> list = new ArrayList();
      for (int i = 0; i < size; i++) {
        Node cur = queue.removeFirst();
        list.add(cur.val);
        for (Node node : cur.children) {
          queue.addLast(node);
        }
      }
      res.add(list);
    }
    return res;
  }
}
//leetcode submit region end(Prohibit modification and deletion)
