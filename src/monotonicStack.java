import java.util.*;

public class monotonicStack {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6};
        System.out.println(Arrays.toString(incStack(arr)));

        int[] arr1 = {3, 1, 4, 1, 5, 9, 2, 6};
        System.out.println(Arrays.toString(decStack(arr1)));
    }

    //Increasing stack
    public static int[] incStack(int[] arr){
        Stack<Integer> st = new Stack<>();
        //minimum language, same output
        for(int i : arr){
            //Keep popping elements from the stack until -
            // either the stack becomes empty or
            // the top of the stack is greater than the current element
            while(!st.isEmpty() && st.peek()>i){
                st.pop();
            }
            //Add the current element in the stack when -
            // either the stack is empty or
            // the top of the stack is smaller than the current element
            st.push(i);
        }
        int[] lis = new int[st.size()];
        for(int i = lis.length-1; i>=0; i--){
            lis[i] = st.pop();
        }
        return lis;
    }

    //Decreasing stack
    public static int[] decStack(int[] arr){
        Stack<Integer> st = new Stack<>();
        //So much unnecessary language
        for(int i : arr){
            if(st.isEmpty() || st.peek()>=i){
                st.push(i);
            } else{
                while(!st.isEmpty() && st.peek()<i){
                    st.pop();
                }
                st.push(i);
            }
        }
        int[] lis = new int[st.size()];
        for(int i = lis.length-1; i>=0; i--){
            lis[i] = st.pop();
        }
        return lis;
    }
}
