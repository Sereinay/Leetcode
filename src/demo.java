import java.util.*;

public class demo {
    class Solution {
        public int longestConsecutive(int[] nums) {
            HashSet<Integer> num_NoRepeat = new HashSet<>();
            for (int num : nums) {
                num_NoRepeat.add(num);
//请注意这里 在使用增强for循环时 前面设置的变量即为取出来的后面的类型 请不要再按照索引方式
// 即这种写法  num_NoRepeat.add(nums[num]); 是错误的！！！
            }
//把数组的数据结构转换成HashMap 去掉其中的重复元素
            int longestBreak = 0;
            for (int i : num_NoRepeat) {
                if (!num_NoRepeat.contains(i-1)){
                    int CurrentNum = i;
                    int CurrentBreak = 1;

                    while (num_NoRepeat.contains(CurrentNum+1)){
                        CurrentBreak++;
                        CurrentNum++;
                    }
                    longestBreak = Math.max(longestBreak, CurrentBreak);
                }
            }
            return longestBreak;
        }
    }
}
