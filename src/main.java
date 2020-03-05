public class main {
    public static void main(String[] args) {
        //int[][] nums = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
        //int[][] num1 = {{}};
        //System.out.println(JianZhiSolution.findNumberIn2DArray(nums, 5));
        int[] pre = {-1};
        int[] in = {-1};
        System.out.println(JianZhiSolution.buildTree(pre, in));
    }
}
