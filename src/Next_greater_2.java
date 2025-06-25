import java.util.Arrays;
import java.util.Stack;

public class Next_greater_2 {
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }

    public static int[] nextGreaterElements(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        // Pre-fill the stack with elements to simulate circular array
        for (int i = n - 2; i >= 0; i--){
            st.push(nums[i]);
        }

        // Process from end to start
        for (int i = n - 1; i >= 0; i--){
            int num = nums[i];
            //A - while the stack is not empty and num >= top of the stack, then pop
            while (!st.isEmpty() && num >= st.peek()){
                st.pop();
            }
            //B - if the stack is empty then set ans [i] = -1
            if (st.isEmpty()){
                ans[i] = -1;
            }
            //C - answer condition - next greater element is found
            // so set ans [i] as top of the stack
            else{
                ans[i] = st.peek();
            }
            //D - push the current element into the stack
            st.push(num);
        }

        return ans;
    }

    //absolute brute force - me :))
    public static int[] nextGreaterElements1(int[] nums) {
        int[] num = new int[nums.length];
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int k = i; k < nums.length; k++) {
                if(nums[k]>nums[i]){
                    num[a] = nums[k];
                    break;
                }
                if(k==nums.length-1){
                    for (int j = 0; j <= i; j++) {
                        if(nums[j]>nums[i]){
                            num[a] = nums[j];
                            break;
                        }
                        else{
                            num[a] = -1;
                        }
                    }
                }
            }
            a++;
        }
        return num;
    }
}
