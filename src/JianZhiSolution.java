import com.sun.javafx.collections.MappingChange;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
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

    public static int minArray(int[] numbers) {
        int min = Integer.MAX_VALUE;
        int count = 0;
        for(int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
                count = i;
            }
        }

        int[] res = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            res[i] = numbers[count % (numbers.length)];
            count ++;
        }
        return res[0];
    }

    public static boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    private static boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;
        char tmp = board[i][j];
        board[i][j] = '#';
        boolean res = dfs(board, word, i + 1, j, k + 1) ||
                dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) ||
                dfs(board, word, i , j - 1, k + 1);
        board[i][j] = tmp;
        return res;
    }

    public static int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0,0});
        while (queue.size() > 0) {
            int[] x = queue.poll();
            int i = x[0];
            int j = x[1];
            if (i < 0 || i >= m || j < 0 || j >= n || calDigit(i) + calDigit(j) > k || visited[i][j]) continue;
            visited[i][j] = true;
            res ++;
            queue.add(new int[] {i + 1, j});
            queue.add(new int[] {i, j + 1});
        }
        return res;
    }

    private static int calDigit(int num) { // 数位和计算可优化
        int res = 0;
        while(num != 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }

    public static int cuttingRope_1(int n) {
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }

    public static int cuttingRope_2(int n) {
        if(n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        for(int a = n / 3 - 1; a > 0; a /= 2) {
            if(a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
        }
        if(b == 0) return (int)(rem * 3 % p);
        if(b == 1) return (int)(rem * 4 % p);
        return (int)(rem * 6 % p);
    }

    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    public static double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
