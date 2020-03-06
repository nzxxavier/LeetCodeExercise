import com.sun.org.apache.xalan.internal.xsltc.dom.SingleNodeCounter;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class JianZhiSolution {
    static int preCount = 0;
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

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int inCount = 0;
        while (inorder[inCount] != preorder[preCount])
            inCount ++;
        TreeNode root = new TreeNode(preorder[preCount]);
        preCount ++;
        TreeNode left = buileTree(preorder, inorder, 0, inCount - 1);
        if (left != null) {
            root.left = left;
        }
        TreeNode right = buileTree(preorder, inorder, inCount + 1, inorder.length - 1);;
        if (right != null) {
            root.right = right;
        }
        return root;
    }

    private static TreeNode buileTree(int[] preorder, int[] inorder, int inStart, int inEnd) {
        int inCount = inStart;
        if (preCount == preorder.length)
            return null;
        if (inStart == inEnd) {
            TreeNode node = new TreeNode(preorder[preCount]);
            preCount ++;
            return node;
        }
        if (inStart < inEnd) {
            TreeNode node = new TreeNode(preorder[preCount]);
            while (inorder[inCount] != preorder[preCount]) {
                inCount++;
                if (inCount > inEnd) {
                    return null;
                }
            }
            preCount ++;
            TreeNode left = buileTree(preorder, inorder, inStart, inCount - 1);
            if (left != null) {
                node.left = left;
            }
            TreeNode right = buileTree(preorder, inorder, inCount + 1, inEnd);
            if (right != null) {
                node.right = right;
            }
            return node;
        }
        else
            return null;
    }

    public static int fib(int n) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
