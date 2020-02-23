import java.lang.reflect.Array;
import java.util.*;

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

    public static int romanToInt(String s) {
        int len = s.length();
        HashMap<String, Integer> sMap = new HashMap<>();
        sMap.put("I", 1);
        sMap.put("IV", 4);
        sMap.put("V", 5);
        sMap.put("IX", 9);
        sMap.put("X", 10);
        sMap.put("XL", 40);
        sMap.put("L", 50);
        sMap.put("XC", 90);
        sMap.put("C", 100);
        sMap.put("CD", 400);
        sMap.put("D", 500);
        sMap.put("CM", 900);
        sMap.put("M", 1000);

        int res = 0;

        for(int i = 0; i < len; ) {
            if (i + 2 <= len) {
                String one = s.substring(i, i + 1);
                String two = s.substring(i, i + 2);
                if (sMap.containsKey(two)) {
                    res += sMap.get(two);
                    i += 2;
                } else {
                    res += sMap.get(one);
                    i++;
                }
            }
            else {
                res += sMap.get(s.substring(i, i + 1));
                i++;
            }
        }

        return res;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int k = 0; k < nums.length - 2; k++){
            if(nums[k] > 0) break;
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0){
                    while (i < j && nums[i] == nums[++i]);
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]);
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]);
                    while (i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min_sub = Integer.MAX_VALUE;
        int res = 0;
        for(int k = 0; k < nums.length - 2; k ++){
            int i = k + 1; int j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                int sub = sum - target;
                if (sub == 0)
                    return target;
                if (Math.abs(sub) < min_sub) {
                    min_sub = Math.abs(sub);
                    res = sum;
                }
                if (sub > 0) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        return res;
    }
}
