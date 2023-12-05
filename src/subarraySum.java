import java.util.HashMap;

public class subarraySum {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int count=0;
            int pre=0;
            HashMap<Integer, Integer> Map = new HashMap<>();
            Map.put(0,1);
            for (int i = 0; i < nums.length; i++) {
                pre+=nums[i];
                if (Map.containsKey(pre-k))
                    count+=Map.get(pre-k);
                Map.put(pre,Map.getOrDefault(pre,0)+1);
            }
            return count;
        }
    }


}
