package Tree;

/**
 * @Author: IronmanJay
 * @Description: 968.监控二叉树
 * @CreateTime: 2022-12-17  08:57
 */
public class p968_BinaryTreeCameras {

    int val;
    p968_BinaryTreeCameras left;
    p968_BinaryTreeCameras right;

    public p968_BinaryTreeCameras() {
    }

    public p968_BinaryTreeCameras(int val) {
        this.val = val;
    }

    public p968_BinaryTreeCameras(int val, p968_BinaryTreeCameras left, p968_BinaryTreeCameras right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        p968_BinaryTreeCameras root = new p968_BinaryTreeCameras();
        p968_BinaryTreeCameras left = new p968_BinaryTreeCameras();
        p968_BinaryTreeCameras left1 = new p968_BinaryTreeCameras();
        p968_BinaryTreeCameras left2 = new p968_BinaryTreeCameras();
        root.left = left;
        left.left = left1;
        left.right = left2;
        int res = minCameraCover(root);
        System.out.println("res = " + res);
    }

    private static int res = 0;

    public static int minCameraCover(p968_BinaryTreeCameras root) {
        if (getRes(root) == 3) {
            res++;
        }
        return res;
    }

    public static int getRes(p968_BinaryTreeCameras root) {
        if (root == null) {
            return 2;
        }
        int left = getRes(root.left);
        int right = getRes(root.right);
        if (left == 3 || right == 3) {
            res++;
            return 1;
        }
        if (left == 1 || right == 1) {
            return 2;
        }
        return 3;
    }

}
