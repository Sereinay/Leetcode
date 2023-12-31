public class trap {
    class Solution {
        public int trap(int[] height) {
            int n=height.length;
            if (n==0)
                return 0;

            int[] lMax = new int[n];
            lMax[0]=height[0];
            for (int i = 1; i < height.length; i++) {
                lMax[i]=Math.max(lMax[i-1],height[i]);
            }

            int[] rMax = new int[n];
            rMax[n-1]=height[n-1];
            for (int i = rMax.length - 2; i >= 0; i--) {
                rMax[i]=Math.max(rMax[i+1],height[i]);
            }

            int ans=0;
            for (int i = 0; i < n; i++) {
                ans+=Math.min(rMax[i],lMax[i])-height[i];
            }
            return ans;
        }
    }
}
