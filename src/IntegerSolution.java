public class IntegerSolution {
    public static int maxArea(int[] height) {
        int first = 0;
        int last = height.length - 1;
        int max = 0;
        while (first != last) {
            max = max = Math.max(max, Math.min(height[first], height[last]) * (last - first));
            if (height[first] < height[last])
                first ++;
            else
                last --;
        }
        return max;
    }
}
