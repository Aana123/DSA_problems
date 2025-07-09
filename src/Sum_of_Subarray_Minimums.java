import java.util.Stack;

public class Sum_of_Subarray_Minimums {
    public static void main(String[] args) {
        int[] arr = {1,3,3};
        System.out.println(sumSubarrayMins(arr));
    }
    //Stack solution
    //TC - O(N)
    //SC - O(N)
    public static int sumSubarrayMins(int[] arr){
        int n = arr.length;
        //Left array represents the previous smaller element
        int[] left = new int[n];
        //Right array represents the next smaller element
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i <n ; i++) {
            //Pop elements from stack until element smaller than current ele is found
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            //If stack is empty, it means there is no smaller element on the left, so set it -1
            //Otherwise, set it to the previous smaller element
            if(st.isEmpty()){
                left[i] = -1;
            }else{
                left[i] = st.peek();
            }

            st.push(i);
        }

        //Clear the stack to reuse it in finding previous smaller elements
        st.clear();

        for (int i = n-1; i >=0 ; i--) {
            //Removing the elements smaller than current element from the stack
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            //If stack is empty, there is no smaller element to the right, so set right[i] to the length of the array.
            //Otherwise, set it to the next smaller element's index
            if(st.isEmpty()){
                right[i] = n;
            }else{
                right[i] = st.peek();
            }

            st.push(i);
        }

        long ans = 0;
        int mod = 1000000007;
        for(int i = 0; i<n; i++){
            ans = (ans+(long)(i-left[i])*(right[i]-i)*arr[i])%mod;
            //find the no. of sub-arrays each element is min in, then multiply it to the element
        }

        return (int)ans;
    }

    //Brute force - zeir solution
    //TC - O(N^2)
    //SC - O(N)
    public static int sumSubarrayMins2(int[] arr){
        int MOD = 1000000007;
        long sumOfMin = 0;

        for(int i = 0; i < arr.length; i++){
            sumOfMin += findSubArrayMin(arr, i) % MOD;
        }
        return (int)sumOfMin;
    }
    public static int findSubArrayMin(int[] arr, int start){
        int minVal = arr[start];
        int result = 0;

        for(int i = start; i < arr.length; i++){
            minVal = Math.min(minVal, arr[i]);
            result += minVal;
        }
        return result;
    }

    //Brute force - not in form :(
    //Integer overflow
    //TC - O(N^2)
    //SC - O(N)
    public static int sumSubarrayMins1(int[] arr) {
        int MOD = 1000000007;
        long ans =  0;
        for (int i = 0; i < arr.length ; i++) {
            int min = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                min = Math.min(min,arr[j]);
                ans += min;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            ans += arr[i];
        }
        return (int)ans%MOD;
    }
}
