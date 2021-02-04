import java.util.HashMap;
import java.util.LinkedList;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
//
//
// 示例 1：
//
//
//输入：s = "()"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "()[]{}"
//输出：true
//
//
// 示例 3：
//
//
//输入：s = "(]"
//输出：false
//
//
// 示例 4：
//
//
//输入：s = "([)]"
//输出：false
//
//
// 示例 5：
//
//
//输入：s = "{[]}"
//输出：true
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 仅由括号 '()[]{}' 组成
//
// Related Topics 栈 字符串
// 👍 2135 👎 0


import java.util.HashMap;
    import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class 有效的括号 {
  public boolean isValid(String s) {
    Map map = new HashMap<>();
    map.put(')', '(');
    map.put('}', '{');
    map.put(']', '[');
    LinkedList<Character> stack = new LinkedList<>();
    if(s.length() == 1) {
      return false;
    }
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(!map.containsKey(c)) {
        stack.addLast(c);
      } else if (stack.isEmpty() || map.get(c) != stack.removeLast()) {
        return false;
      }

    }
    return stack.isEmpty();


  }
}
//leetcode submit region end(Prohibit modification and deletion)

