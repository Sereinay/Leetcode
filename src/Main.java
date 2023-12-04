import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class Main {
    public static void main(String[] args) {
        class Solution {
            public static List<List<String>> groupAnagrams(String[] strs) {
                HashMap<String, List<String>> AnswerMap = new HashMap<>();
                for (String str : strs) {
                    char[] charArray = str.toCharArray();
                    Arrays.sort(charArray);
                    String key = Arrays.toString(charArray);
                    List<String> list = AnswerMap.getOrDefault(key, new ArrayList<String>());
                    list.add(str);
                    AnswerMap.put(key,list);
                }
                return new ArrayList<List<String>>(AnswerMap.values());
            }
        }
//        String[] strings = new String[]{"eat","tea","tan","ate","nat","bat"};
//        System.out.println(Solution.groupAnagrams(strings));
        }

}