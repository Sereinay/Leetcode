import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class findAnagrams {
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int s_len = s.length();
            int p_len = p.length();
            if (s_len < p_len)
                return new ArrayList<Integer>();

            List<Integer> ans = new ArrayList<>();
            char[] s_chars = new char[26];
            char[] p_chars = new char[26];
            for (int i = 0; i < p_len; i++) {
//            这里不能写成for (int i = 0; i < 26; i++)
//            要时刻记得小心索引下表越界 26长度是开出来在最坏情况下的可能
                ++s_chars[s.charAt(i) - 'a'];
                ++p_chars[p.charAt(i) - 'a'];
            }

            if (Arrays.equals(s_chars, p_chars)) {
                ans.add(0);
            }

            for (int i = 0; i < s_len - p_len; i++) {
                --s_chars[s.charAt(i) - 'a'];
                ++s_chars[s.charAt(i + p_len) - 'a'];
                if (Arrays.equals(s_chars, p_chars))
                    ans.add(i + 1);
            }
            return ans;
        }
    }
}
