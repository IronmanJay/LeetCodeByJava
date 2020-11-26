package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class p380_InsertDeleteGetrandomO1 {

    public static void main(String[] args) {
        p380_InsertDeleteGetrandomO1 O1 = new p380_InsertDeleteGetrandomO1();
        O1.RandomizedSet();
        boolean res1 = O1.insert(1);
        System.out.println("res1 = " + res1);
        boolean res2 = O1.remove(2);
        System.out.println("res2 = " + res2);
        boolean res3 = O1.insert(2);
        System.out.println("res3 = " + res3);
        int res4 = O1.getRandom();
        System.out.println("res4 = " + res4);
        boolean res5 = O1.remove(1);
        System.out.println("res5 = " + res5);
        boolean res6 = O1.insert(2);
        System.out.println("res6 = " + res6);
        int resd7 = O1.getRandom();
        System.out.println("resd7 = " + resd7);
    }

    // 哈希表起辅助作用，存放元素在list中对应的索引
    private static HashMap<Integer, Integer> map;
    // list存储元素
    private static List<Integer> list;
    // 随机数
    private static Random random;

    /**
     * 初始化
     */
    public static void RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /**
     * 插入元素：list存放元素值，hashMap存放元素在list的索引
     *
     * @param val 待插入元素值
     * @return 成功：true 失败：false
     */
    public static boolean insert(int val) {
        if (!map.containsKey(val)) {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
        return false;
    }

    /**
     * 删除元素：将待删除元素与list最后一个元素位置交换，list删除最后一个位置元素即可，hashMap中元素对应索引修改
     *
     * @param val 待删除元素
     * @return 成功：true 失败：false
     */
    public static boolean remove(int val) {
        if (map.containsKey(val)) {
            int curIndex = map.get(val);
            int lastVal = list.get(list.size() - 1);
            list.set(curIndex, lastVal);
            map.put(lastVal, curIndex);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }
        return false;
    }

    /**
     * 使用随机数种子随机返回元素
     *
     * @return 返回随机值
     */
    public static int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

}
