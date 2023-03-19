package DoublePointer;

/**
 * @Author: IronmanJay
 * @Description: 165.比较版本号
 * @CreateTime: 2023-03-19  09:23
 */
public class p165_CompareVersionNumbers {

    public static void main(String[] args) {
        String version1 = "1.01";
        String version2 = "1.001";
        int res = compareVersion(version1, version2);
        System.out.println("res = " + res);
    }

    public static int compareVersion(String version1, String version2) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < version1.length() || index2 < version2.length()) {
            int x = 0;
            while (index1 < version1.length() && version1.charAt(index1) != '.') {
                x = x * 10 + version1.charAt(index1) - '0';
                index1++;
            }
            index1++;
            int y = 0;
            while (index2 < version2.length() && version2.charAt(index2) != '.') {
                y = y * 10 + version2.charAt(index2) - '0';
                index2++;
            }
            index2++;
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }

}
