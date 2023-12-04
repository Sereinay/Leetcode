import java.util.*;

public class demo {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> AnswerMap = new HashMap<>();
            for (String str : strs) {
                char[] charArray = str.toCharArray();
                Arrays.sort(charArray);
                String key = charArray.toString();
                List<String> list = AnswerMap.getOrDefault(key, new ArrayList<String>());
                list.add(str);
                AnswerMap.put(str,list);
            }
            return new ArrayList<List<String>>(AnswerMap.values());
        }
    }
}
