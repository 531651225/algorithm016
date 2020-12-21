//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
//
//
// 示例 2:
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释:
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100]
//
// 说明:
//
//
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
// 要求使用空间复杂度为 O(1) 的 原地 算法。
//
// Related Topics 数组
// 👍 753 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 旋转数组 {
  import java.util.Arrays;


  /**
   * 双重循环 时间复杂度：O(kn) 空间复杂度：O(1)
   */
  public void rotate_1(int[] nums, int k) {
    int n=nums.length;
    k%=n;
    for (int i=0; i < k; i++) {
      int temp=nums[n - 1];
      for (int j=n - 1; j > 0; j--) {
        nums[j]=nums[j - 1];
      }
      nums[0]=temp;
    }
  }

  /**
   * 翻转 时间复杂度：O(n) 空间复杂度：O(1)
   */
  public void rotate_2(int[] nums, int k) {
    int n=nums.length;
    k%=n;
    reverse(nums, 0, n - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, n - 1);
  }


  private void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp=nums[start];
      nums[start++]=nums[end];
      nums[end--]=temp;
    }
  }

  /**
   * 循环交换 时间复杂度：O(n) 空间复杂度：O(1)
   */
  public void rotate_3(int[] nums, int k) {
    int n=nums.length;
    k%=n;
    // 第一次交换完毕后，前 k 位数字位置正确，后 n-k 位数字中最后 k 位数字顺序错误，继续交换
    for (int start=0; start < nums.length && k != 0; n-=k, start+=k, k%=n) {
      for (int i=0; i < k; i++) {
        swap(nums, start + i, nums.length - k + i);
      }
    }
  }

  /**
   * 递归交换 时间复杂度：O(n) 空间复杂度：O(n/k)
   */
  public void rotate(int[] nums, int k) {
    // 原理同上
    recursiveSwap(nums, k, 0, nums.length);
  }

  private void recursiveSwap(int[] nums, int k, int start, int length) {
    k%=length;
    if (k != 0) {
      for (int i=0; i < k; i++) {
        swap(nums, start + i, nums.length - k + i);
      }
      recursiveSwap(nums, k, start + k, length - k);
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp=nums[i];
    nums[i]=nums[j];
    nums[j]=temp;
  }

//  我们假设现在有 A 、B 、C、 D、 E 五名同学，今天考试完，老师要求换座位，每个同学向后移动3个座位
//  于是就从 A 同学开始换座位了... （下图左边）
//
//  A同学 非常自觉，看了看自己座位号（0），根据老师要求，他走到了3 号位置，即 D 同学的位置，同时他把D 同学赶到了角落，自己坐在了 3 号位置，第一个完成任务真爽！
//  D同学 一看，不行啊，我咋能呆在角落，于是D同学也按要求理直气壮来到了1号位置，同样把B同学赶到了角落，猛男落泪...
//  B同学 当然也不干，气汹汹走到了4号位置，"E同学，麻烦起来一下，角落给你收拾好了：)",于是 E同学来到角落..
//  E同学 一想：不行呀，我这么帅，必须有座位！站起来跑到了2号位置，二话不说，赶走了C，坐上上去，一下子舒服了...
//  C同学 此时来了角落，想：不是每个人都有座位吗？？还需要抢？于是C从容的来到了0号位置，至此，所有同学都坐好了。
//  以上是 下图中左边 的情况，这个算法还会遇到另外一种情况，就是今天E同学请假，老师说那就每个人往后移动 2个座位。于是大家开始行动，和上面发生的一样，不过，当第二轮C同学坐好了以后，角落没人了，大家都有位子，就没人闹意见了...
//  老师一看，我精心布置的局，咋就停了呢，于是吼了一嗓子："咳咳！还有谁没换？第二组打头的那个！B同学！是不是你！你们第二组学学第一组，第一组早早的换完了，你们组还一个没动！"
//  B同学一听到喊自己的名字，秒怂...本来想偷懒，无奈换起来座位..就这样，随着第二组的同学换完座位，最终大家完成了换座位
//      (上面老师喊的那一嗓子，就是我们内循环退出，即C回到了起始位置0位置，这时候我们就将起始位置 Start + 1)
//
//  最后的版本比较好理解环状替代

//（补充）关于上述两种情况何时出现：
//  其实是这样的，对于一个长度为 n的数组，整体移动 k个位置
//
//  当 n 和 k 的最大公约数 等于 1 的时候：1 次遍历就可以完成交换；比如 n = 5, k = 3n=5,k=3
//  当 n 和 k 的最大公约数 不等于 1 的时候：1 次遍历是无法完成的所有元素归位，需要 m (最大公约数) 次
//  所以在最大公约数不为 1 的时候
//  比如 [A,B,C,D,E,F][A,B,C,D,E,F] 此时 n = 6 \ , k = 4，其最大公约数为 2 ,因此需要 2 轮循环
//  我们就可以把这个数组分成两部分来看：
//  第 1轮循环（分组1） A E C [A]
//  第 2 轮循环（分组2   B F D [B]
//
//  即：每一轮循环只会在自己的那一组上不停的遍历。所以
//  数组的前 m个元素，其实就是每一个分组的第一个元素，我们控制流程在每次发现一轮循环走到原点时+1
//
//  那么如何判断所有的分组都执行归位了呢？ 可以有两种方法来控制
//
//  第一种：我们就用最大公约数 m 来控制外循环，代表总共有 m 轮循环
//  第二种：由于n个元素归位需要n次交换，所以我们定义一个count代表交换次数，当 count = n 时完成(用这种好理解)


  public void rotate(int[] nums, int k) {
    int len=nums.length;
    //处理当k 大于等于 len的时候
    k=k % len;
    int count=0;
    //i 是交换的组数,在len与k的公约是不为1的时候,组数等于最大公约数
    for (int i=0; count < len; i++) {
      System.out.println(i);
      //cur 是每组交换的开始元素
      int cur=i;
      //用prev 保存被交换的元素
      int prev=nums[cur];
      do {
        //即将站位的位置
        int next=(cur + k) % len;
        //原来的位置放到外面,先保存在临时变量里,后面赋值给prev
        //不能用prev 直接赋值num[next],在用num[next]给prev,
        // 因为num【next】已经变了,所以放到temp里
        int temp=nums[next];
        //占位置
        nums[next]=prev;
        prev=temp;
        cur=next;
        count++;
        System.out.println(cur);

      } while (cur != i);
      //   每组交换的终止条件 回到了开始
    }

  }

}
//leetcode submit region end(Prohibit modification and deletion)

