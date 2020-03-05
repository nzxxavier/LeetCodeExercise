import java.util.Stack;

class CQueue {
    Stack<Integer> A;
    Stack<Integer> B;
    public CQueue() {
        A = new Stack<Integer>();
        B = new Stack<Integer>();
    }

    public void appendTail(int value) {
        while(!B.isEmpty()) A.push(B.pop());
        A.push(value);
    }

    public int deleteHead() {
        while(!A.isEmpty()) B.push(A.pop());
        return B.isEmpty() ? -1 : B.pop();
    }
}
