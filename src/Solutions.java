import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solutions {
    //    239.滑动窗口最大值
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] preMax = new int[n];
        int[] revMax = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % k == 0)
                preMax[i] = nums[i];
            else
                preMax[i] = Math.max(preMax[i - 1], nums[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            if ((i + 1) % k == 0 || i == n - 1)
                revMax[i] = nums[i];
            else
                revMax[i] = Math.max(revMax[i + 1], nums[i]);
        }
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Math.max(preMax[i + k - 1], revMax[i]);
        }
        return ans;
    }
//    53.最大字数组和

    public int maxSubArray1(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (dp[i - 1] > 0)
                dp[i] = dp[i - 1] + nums[i];
            else
                dp[i] = nums[i];
        }

        int ans = dp[0];
        for (int i : dp) {
            ans = Math.max(ans, i);
        }
        return ans;
    }

    //    不进行空间复杂度优化的代码
    public int maxSubArray2(int[] nums) {
        int pre = 0;
        int ans = nums[0];
//        这里用两个变量来分别存储前缀和pre、答案ans
//        由状态转移方程知道每次的新pre是pre+num和num中更大的那一个
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            ans = Math.max(pre, ans);
        }
//        对数组进行增强for循环 每次更新pre和ans 这样就可以不用开一个
//        长度为n的ans数组来存储每个状态的答案
//        优化空间复杂度从 O（N）到 O（1）
//        但是这样写的话可读性不好hhh
        return ans;
    }

//      进行了空间复杂度优化的代码

    //    14.合并区间
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });//重写了比较器 把二维数组按照第一个元素来升序排列
        List<int[]> merged = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            int L = interval[0];
            int R = interval[1];
//            用L R来存一个节点的左右端点值
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else
                merged.get(merged.size() - 1)[1] = Math.max(R, merged.get(merged.size() - 1)[1]);
        }
//     先把interval的第一组L R拿出来 merged非空（初始化用）或merged末尾的右侧元素小于当前的L（即不会出现合并时 直接把L R添加进即可）
//     否则的话 维护更新merged的末尾的右端元素 使其为合并后的区间最长值即可
        return merged.toArray(new int[merged.size()][]);
    }

//          15.轮转数组
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] temp=new int[n];
        for (int i = 0; i < n; i++) {
            temp[(i+k)%n]=nums[i];
        }
        System.arraycopy(temp,0,nums,0,n);
    }
//    很简单一道题目 类似循环列表 算出来移动后的坐标后 开一个新数组来存 最后memcopy就行
//    要注意的点就是System.arraycopy五个参数 还有%运算优先级高于+ 写的时候要记得带括号
}