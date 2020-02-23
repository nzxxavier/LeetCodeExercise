import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i ++) {
            if (s.charAt(i) == ' ')
                builder.append("%20");
            else
                builder.append(s.charAt(i));
        }
        return builder.toString();
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        if (head == null) {
            return new int[0];
        }
        stack.push(head.val);
        while (head.next != null) {
            head = head.next;
            stack.push(head.val);
        }
        int len = stack.size();
        int[] res = new int[len];
        for (int i = 0; i < len; i ++) {
            res[i] = stack.pop();
        }

        return res;
    }
}
