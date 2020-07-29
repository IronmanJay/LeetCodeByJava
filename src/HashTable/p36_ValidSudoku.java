package HashTable;

public class p36_ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {
                {'.', '8', '7', '6', '5', '4', '3', '2', '1'},
                {'2', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'9', '.', '.', '.', '.', '.', '.', '.', '.'}};
        boolean res = isValidSudoku(board);
        System.out.println("res = " + res);
    }

    public static boolean isValidSudoku(char[][] board) {
        // 记录某行，某位数字是否已经存在
        boolean[][] row = new boolean[9][9];
        // 记录某列，某位数字是否已经存在
        boolean[][] col = new boolean[9][9];
        // 记录某3*3宫格内，某位数字是否已经存在
        boolean[][] block = new boolean[9][9];
        // 依次遍历二维数组每一个元素
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    // 获取当前数字，这里-‘1’有两个作用，第一是使其成为int类型，第二是数组下标从0开始，所以对应-1
                    int curNum = board[i][j] - '1';
                    // 获取当前数字对应的块
                    int blockIndex = i / 3 * 3 + j / 3;
                    // 如果发现某行、某列、某块中有重复数字（判断依据是对应位置为true就是已经存在这个元素了），返回false，意味着存在重复元素
                    if (row[i][curNum] || col[j][curNum] || block[blockIndex][curNum]) {
                        return false;
                    }
                    // 否则说明当前元素是第一次出现，那么对应位置置为true，说明已经存在这个元素了
                    else {
                        row[i][curNum] = true;
                        col[j][curNum] = true;
                        block[blockIndex][curNum] = true;
                    }
                }
            }
        }
        // 如果没有发现重复元素，返回true
        return true;
    }

}
