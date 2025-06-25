import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Previous_greater {
    public static void main(String[] args) {
        int[] arr = {10, 4, 2, 20, 40, 12, 30};
        System.out.println(Arrays.toString(prevGreater(arr,arr.length)));
    }

    public static int[] prevGreater(int arr[],int n){
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> hs = new HashMap<>();
        int[] ans = new int[n];
        for (int i = arr.length-1; i >= 0; i--) {
            while(!st.isEmpty() && st.peek()<arr[i]) {
                hs.put(st.pop(),arr[i]);
            }
            st.push(arr[i]);
        }
        for(int i = 0; i < arr.length; i++){
            ans[i] = hs.getOrDefault(arr[i],-1);
        }
        return ans;
    }

    //Brute force
    //TC - O(N^2)
    //SC - O(1)
    public static int[] prevGreater1(int arr[],int n){
        int[] ans = new int[n];
        for (int i = n-1; i >= 0 ; i--) {
            ans[i] = -1;
            for (int j = i-1; j >= 0 ; j--) {
                if(arr[j]>arr[i]){
                    ans[i] = arr[j];
                    break;
                }
            }
        }
        return ans;
    }
}
