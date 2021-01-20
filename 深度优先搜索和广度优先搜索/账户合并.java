import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其
//余元素是 emails 表示该账户的邮箱地址。
//
// 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为
//人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
//
// 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。账户本身可以以任意顺序返回。
//
//
//
// 示例 1：
//
//
//输入：
//accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnn
//ybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Ma
//ry", "mary@mail.com"]]
//输出：
//[["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],
//["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
//解释：
//第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
//第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
//可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
//['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的
//。
//
//
//
//
// 提示：
//
//
// accounts的长度将在[1，1000]的范围内。
// accounts[i]的长度将在[1，10]的范围内。
// accounts[i][j]的长度将在[1，30]的范围内。
//
// Related Topics 深度优先搜索 并查集
// 👍 149 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class 账户合并 {

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    List<List<String>> res = new ArrayList<>();
    HashMap<String, Integer> emailToIndex = new HashMap<>();
    HashMap<String, String> emailToName = new HashMap<>();
    int emailsCount = 0;
    for (List<String> account : accounts) {
      String name = account.get(0);
      for (int i = 1; i < account.size(); i++) {
        if (!emailToIndex.containsKey(account.get(i))) {
          emailToIndex.put(account.get(i), emailsCount++);
          emailToName.put(account.get(i), name);
        }
      }
    }
    UnionFind u = new UnionFind(emailToIndex.size());
    HashMap<Integer, List<String>> unionMap = new HashMap<>();
    for (List<String> account : accounts) {
      String firstname = account.get(1);
      int firstIndex = emailToIndex.get(firstname);
      for (int i = 2; i < account.size(); i++) {
        String curEmail = account.get(i);
        int curEmailIndex = emailToIndex.get(curEmail);
        u.union(curEmailIndex, firstIndex);
      }
    }

    for(String email : emailToIndex.keySet()) {
      int curindex = emailToIndex.get(email);
      int root = u.find(curindex);
      List<String> emails = unionMap.getOrDefault(root, new ArrayList<>());
      emails.add(email);
      unionMap.put(root, emails);
    }

    for(List<String> emails : unionMap.values()) {
      Collections.sort(emails);
      String name = emailToName.get(emails.get(0));
      List<String> account = new ArrayList<>();
      account.add(name);
      account.addAll(emails);
      res.add(account);
    }
    return res;




  }
  class UnionFind {
    int count;
    int[] parent;
    public UnionFind(int n) {
      count = n;
      parent = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
    }

    void union(int p, int q) {
      int proot = find(p);
      int qroot = find(q);
      if(proot == qroot) return;
      parent[proot] = parent[qroot];
    }



    int find(int p) {
      while(p != parent[p]) {
        parent[p] = parent[parent[p]];
        p = parent[p];
      }
      return p;
    }



  }


}





//leetcode submit region end(Prohibit modification and deletion)

