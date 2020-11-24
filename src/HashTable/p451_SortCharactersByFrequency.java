package HashTable;

import java.util.HashMap;

public class p451_SortCharactersByFrequency {

    public static void main(String[] args) {
        String s = "tree";
        String res = frequencySort(s);
        System.out.println("res = " + res);
    }

    public static String frequencySort(String s) {
        // 哈希表存放各元素出现的次数
        HashMap<Character, Integer> map = new HashMap<>();
        // 计算各个元素出现的次数，key是元素，value是对应元素出现的次数
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        // 结果字符流
        StringBuilder res = new StringBuilder();
        // 某个字符最长也就是字符串的长度，题目要求降序排列，所以从后向前遍历
        for (int i = s.length(); i >= 0; i--) {
            // 得到所有的key
            for (char c : map.keySet()) {
                // 如果某个key出现的次数等于当前长度，也就是当前最大长度
                if (map.get(c) == i) {
                    // 那么长度是多少就拼接几个当前key
                    for (int j = 0; j < i; j++) {
                        res.append(c);
                    }
                }
            }
        }
        // 返回结果
        return res.toString();
    }

}
