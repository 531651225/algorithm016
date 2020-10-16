import java.util.Arrays;


//一条包含字母 A-Z 的消息通过以下方式进行了编码：
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。
//
// 题目数据保证答案肯定是一个 32 位的整数。
//
//
//
// 示例 1：
//
// 输入："12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
//
//
// 示例 2：
//
// 输入："226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
//
//
// 示例 3：
//
// 输入：s = "0"
//输出：0
//
//
// 示例 4：
//
// 输入：s = "1"
//输出：1
//
//
// 示例 5：
//
// 输入：s = "2"
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 100
// s 只包含数字，并且可以包含前导零。
//
// Related Topics 字符串 动态规划
// 👍 529 👎 0

//131323 第一位有两种解码方式 1| 31323   or 13| 1323

//226
//    2|26   22|6
//
//   2 | 2| 6

//leetcode submit region begin(Prohibit modification and deletion)
class 解码方法 {

  //时间复杂度 O(N)使用备忘录，降低空间复杂度 要不是2^n
  //空间复杂度 O(N)
  public int numDecodings(String s) {
    int[] memo = new int[s.length()];
    Arrays.fill(memo, -1);
    return recur(s, 0, memo);
  }

//    private int getAns(String s, int start) {
//        //划分到了最后返回 1
//        if (start == s.length()) {
//            System.out.println(start);
//            return 1;
//        }
//        //开头是 0,0 不对应任何字母，直接返回 0
//        if (s.charAt(start) == '0') {
//            return 0;
//        }
//        //得到第一种的划分的解码方式
//        int ans1 = getAns(s, start + 1);
//        int ans2 = 0;
//        //判断前两个数字是不是小于等于 26 的
//        if (start < s.length() - 1) {
//            int ten = (s.charAt(start) - '0') * 10;
//            int one = s.charAt(start + 1) - '0';
//            if (ten + one <= 26) {
//                ans2 = getAns(s, start + 2);
//            }
//        }
//        return ans1 + ans2;
//    }

  //解法一的递归中，走完左子树，再走右子树会把一些已经算过的结果重新算，
  // 所以我们可以用 备忘录 技术，就是算出一个结果很就保存，第二次算这个的时候直接拿出来就可以了。
  private int recur(String s, int start, int[] memo) {

    //划分到了最后返回 1
    if (s.length() == start) {
      return 1;
    }
    //开头是 0,0 不对应任何字母，直接返回 0
    if (s.charAt(start) == '0') {
      return 0;
    }
    if (memo[start] != -1) {
      System.out.println(start + ":" + memo[start]);
      return memo[start];
    }
    int res1 = recur(s, start + 1, memo);
    int res2 = 0;
    //只有最后一个一个元素,不能进行第二种情况划分
    if (start < s.length() - 1) {
      int ten = s.charAt(start) - '0';
      int one = s.charAt(start + 1) - '0';
      int num = ten * 10 + one;
      if (num <= 26) {
        res2 = recur(s, start + 2, memo);
      }
    }
    memo[start] = res1 + res2;
    return res1 + res2;

  }


//    public int numDecodings(String s) {
//        HashMap<Integer, Integer> memoization = new HashMap<>();
//        return getAns(s, 0, memoization);
//    }
//
//    private int getAns(String s, int start, HashMap<Integer, Integer> memoization) {
//
//        if (start == s.length()) {
//            System.out.println(start);
//            return 1;
//        }
//        if (s.charAt(start) == '0') {
//            return 0;
//        }
//        //判断之前是否计算过
//        int m = memoization.getOrDefault(start, -1);
//        if (m != -1) {
//            return m;
//        }
//        int ans1 = getAns(s, start + 1, memoization);
//        int ans2 = 0;
//        if (start < s.length() - 1) {
//            int ten = (s.charAt(start) - '0') * 10;
//            int one = s.charAt(start + 1) - '0';
//            if (ten + one <= 26) {
//                ans2 = getAns(s, start + 2, memoization);
//            }
//        }
//        //将结果保存
//        memoization.put(start, ans1 + ans2);
//        return ans1 + ans2;
//    }
//
//
//}

  //动态规矩
  public int numDecodings(String s) {

    int len = s.length();
    int[] dp = new int[len + 1];
    if (s == null || len == 0) {
      return 0;
    }
    dp[len] = 1;
    if (s.charAt(len - 1) != '0') {
      dp[len - 1] = 1;
    }
    for (int i = len - 2; i >= 0; i--) {
      if (s.charAt(i) == '0') {
        continue;
      }
      int res1 = dp[i + 1];
      int res2 = 0;
      int ten = (s.charAt(i) - '0') * 10;
      int one = (s.charAt(i + 1) - '0');
      if (ten + one <= 26) {
        res2 = dp[i + 2];
      }
      dp[i] = res1 + res2;
    }
    return dp[0];
  }

}

//leetcode submit region end(Prohibit modification and deletion)
