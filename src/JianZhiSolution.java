public class JianZhiSolution {
    public static int findRepeatNumber(int[] nums) {
        int[] mem = new int[nums.length];
        for (int i:mem) {
            i = 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (mem[nums[i]] > 0)
                return nums[i];
            mem[nums[i]] ++;
        }
        return 0;
    }
}
