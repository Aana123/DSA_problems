import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Next_smaller {
    public static void main(String[] args) {
        int arr[] = {11, 13, 1, 3,12};
        System.out.println(Arrays.toString(next(arr)));
    }

    //By stack
    public static int[] next(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> hs = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            while(!st.isEmpty() && arr[i]<st.peek()){
                hs.put(st.pop(),arr[i]);
            }
            System.out.println(hs);
            st.push(arr[i]);
        }
        for(int i = 0; i<arr.length; i++){
            ans[i] = hs.getOrDefault(arr[i],-1);
        }
        return ans;
    }

    //Brute force
    public static int[] next1(int[] arr){
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = -1;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<arr[i]){
                    ans[i] = arr[j];
                    break;
                }
            }
        }
        return ans;
    }
}
