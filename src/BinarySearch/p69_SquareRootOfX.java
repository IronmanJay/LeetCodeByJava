package BinarySearch;

public class p69_SquareRootOfX {

    public static void main(String[] args) {
        int x = 8;
        int res = mySqrt(8);
        System.out.println("res = " + res);
    }

    public static int mySqrt(int x) {
        int left = 0;
        int right = x;
        int res = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if((long)mid * mid <= x){
                res = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return res;
    }

}
