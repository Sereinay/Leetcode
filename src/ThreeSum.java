import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
//            这里注意 是多态的写法 List是一个接口 不能作为对象new
//            new的只能是他的实现类ArrayList
            for (int first = 0; first <n; first++) {
                if (first>0&&nums[first]==nums[first-1]){
                    continue;
                }
//            这里因为要对数字进行去重处理 但是如果从头开始这么写的话
//            会出现第一个元素的去重操作回访问到-1号的元素 所以要加一个&&判断
                int third=n-1;
                for (int second = first+1; second < n; second++) {
                    if (second>first+1&&nums[second]==nums[second-1]){
                        continue;
                    }
                    while (second<third&&nums[first]+nums[second]+nums[third]>0){
                        third--;
                    }
                    if (second==third){
                        break;
                    }
                    if (nums[first]+nums[second]+nums[third]==0){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        ans.add(list);
                    }
                }
            }
            return ans;
        }
    }
}
