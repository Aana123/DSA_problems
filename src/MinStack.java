import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        ms.getMin();
        ms.pop();
        ms.getMin();
    }
    private Stack<Integer> st;
    public MinStack() {
        st = new Stack<>();
    }
    public void push(int val) {
        st.push(val);
    }
    public void pop() {
        st.pop();
    }
    public int top() {
        return st.peek();
    }

    //Brute force
    public int getMin() {
        int[] s = new int[st.size()];
        int min = 2147483647;
        int p = 0;
        while(!st.isEmpty()){
            s[p] = st.pop();
            p++;
        }
        for(int i = s.length-1; i>=0; i--){
            min = Math.min(min,s[i]);
            st.push(s[i]);
        }
        return min;
    }
}

