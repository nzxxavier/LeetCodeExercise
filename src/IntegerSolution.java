import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
