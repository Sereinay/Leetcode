public class Solutions {
//    239.滑动窗口最大值
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] preMax = new int[n];
        int[] revMax = new int[n];
        for (int i = 0; i < n; i++) {
            if (i%k==0)
                preMax[i]=nums[i];
            else
                preMax[i]=Math.max(preMax[i-1],nums[i] );
        }
        for (int i = n-1; i >=0; i--) {
            if ((i+1)%k==0||i==n-1)
                revMax[i]=nums[i];
            else
                revMax[i]=Math.max(revMax[i+1],nums[i]);
        }
        int[] ans = new int[n-k+1];
        for (int i = 0; i < ans.length; i++) {
            ans[i]=Math.max(preMax[i+k-1],revMax[i]);
        }
        return ans;
    }
}
