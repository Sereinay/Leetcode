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
                return o1[0] - o2[0];
            }
        });//重写了比较器 把二维数组按照第一个元素来升序排列
        List<int[]> merged = new ArrayList<>();
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
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }
        System.arraycopy(temp, 0, nums, 0, n);
    }
//    很简单一道题目 类似循环列表 算出来移动后的坐标后 开一个新数组来存 最后memcopy就行
//    要注意的点就是System.arraycopy五个参数 还有%运算优先级高于+ 写的时候要记得带括号


//              16.除自身以外数组的乘积
    public int[] productExceptSelf(int[] nums) {
        int n= nums.length;
        int[] L=new int[n];
        int[] R=new int[n];
        int[] ans=new int[n];
//开了一个前缀积数组 一个后缀积数组 一个答案数组
        L[0]=1;
        for (int i = 1; i <n ; i++) {
            L[i]=L[i-1]*nums[i-1];
        }
//L[]是处理i位置的前缀 由于L[0]=1
// 所以L中所有位置都比nums大1 即L[i]=L[i-1]*nums[i-1]
        R[n-1]=1;
        for (int i = n-2; i>=0; i--) {
            R[i]=R[i+1]*nums[i+1];
        }
//R[]是处理i位置的后缀 由于R[n-1]=1
// 所以R中所有位置都比nums小1 即R[i]=R[i+1]*nums[i+1]
        for (int i = 0; i < n; i++) {
            ans[i]=L[i]*R[i];
        }
//        最后遍历把L R的值相乘得到答案即可
        return ans;
    }


//    41.缺失的第一个正数
    public int firstMissingPositive(int[] nums) {
        int n =nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i]<=0)
                nums[i]=n+1;
        }
        for (int i = 0; i < n; i++) {
            int num=Math.abs(nums[i]);
            if (num<=n){
                nums[num-1]=-Math.abs(nums[num-1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i]>0)
                return i+1;
        }
        return 1+n;
    }


    //    18.矩阵置零
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row=new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]==0)
                    row[i]=col[j]=true;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (col[j]||row[i])
                    matrix[i][j]=0;
            }
        }
    }

//    19.螺旋矩阵
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        List<Integer> ans =new ArrayList<Integer>();
        int t=0,b=m-1,l=0,r=n-1;
        while (true){
            for (int i = l; i <= r; i++) ans.add(matrix[t][i]);
            if (++t>b) break;
            for (int i = t; i <= b; i++) ans.add(matrix[i][r]);
            if (--r<l) break;
            for (int i = r; i >= l; i--) ans.add(matrix[b][i]);
            if (--b<t) break;
            for (int i = b; i >= t; i--) ans.add(matrix[i][l]);
            if (++l>r) break;
        }
        return ans;
    }

//  20.旋转图像
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] matrix_new = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix_new[j][n-i-1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix_new[i], 0, matrix[i], 0, n);
        }//用arraycopy会性能更好一点
    }

//    21.搜索二维矩阵II
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[]num:matrix) {
            for (int i : num) {
                if (i==target)
                    return true;
            }
        }
        return false;
    }
//    最简单的暴力解法 直接迭代器遍历 两重循环找target 复杂度O(MN)
//    解法二：利用元素的有序性进行二分查找
    public boolean searchMatrix_1(int[][] matrix, int target) {
        for (int[] nums : matrix) {
            int index = binary_search(nums, target);
            if (index >= 0)
                return true;
        }
        return false;
    }

        private int binary_search(int[] nums, int target) {
            int low = 0, high = nums.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                int num = nums[mid];
                if (num == target)
                    return mid;
                else if (target < num) {
//      注意这里比较的是target和num的值 而不是target和mid 写错就GG；
                    low = mid + 1;
                } else
                    high = mid - 1;
            }
            return -1;
        }

//      解法三：Z字形查找
    public boolean searchMatrix_2(int[][] matrix, int target) {
        int m=matrix.length,n=matrix[0].length;
        int x=0,y=n-1;
        while (x<=m-1&&y>=0){
            if (matrix[x][y]==target)
                return true;
            else if (matrix[x][y]>target)
                --y;
            else
                ++x;
        }
        return false;
    }

//    22.相交链表
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null||headB==null) return null;
        ListNode p1=headA,p2=headB;
        while (p1!=p2){
            p1= p1==null ? headB : p1.next;
            p2= p2==null ? headA : p2.next;
        }
        return p1;
    }
}