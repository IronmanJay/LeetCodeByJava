package String;

/**
 * @Author: IronmanJay
 * @Description: 171.Excel 表列序号
 * @CreateTime: 2022-11-30  09:25
 */
public class p171_ExcelSheetColumnNumber {

    public static void main(String[] args) {
        String columnTitle = "AB";
        int res = titleToNumber(columnTitle);
        System.out.println("res = " + res);
    }

    public static int titleToNumber(String columnTitle) {
        int res = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            int num = columnTitle.charAt(i) - 'A' + 1;
            res = res * 26 + num;
        }
        return res;
    }

}
