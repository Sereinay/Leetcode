import java.util.HashMap;

public class lengthOfLongestSubstring {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.isEmpty())
                return 0;
            HashMap<Character, Integer> Map = new HashMap<>();
            int max = 0;
            int left = 0;
            for (int i = 0; i < s.length(); i++) {
                if (Map.containsKey(s.charAt(i))) {
                    left = Math.max(left, Map.get(s.charAt(i)) + 1);
                }
                Map.put(s.charAt(i), i);
                max = Math.max(max, i + 1 - left);
            }
            return max;
        }
    }
}
