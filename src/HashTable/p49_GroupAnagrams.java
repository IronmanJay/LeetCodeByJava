package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class p49_GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = groupAnagrams(strs);
        System.out.println("res = " + res);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        // 使用HashMap键值对存储元素
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        // 遍历每一个元素
        for (String str : strs) {
            // 首先将这个元素转换为字符数组
            char[] ch = str.toCharArray();
            // 排序，这样的话，具有相同字母的字符串就会生成一样的键
            Arrays.sort(ch);
            // 再将这个字符数组拼接成字符串，以这个为键进行匹配
            String key = String.valueOf(ch);
            // 如果以这个键查找HashMap，不能找到对应的元素，说明此时还没有这些元素的字符串加入，那么就以这个为键新建一个字符列表，方便后续加入具有相同字母的字符串
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            // 将具有相同字母的字符串加入到对应key的列表中
            map.get(key).add(str);
        }
        // 返回结果
        return new ArrayList(map.values());
    }

}
