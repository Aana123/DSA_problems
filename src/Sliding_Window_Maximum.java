import java.util.*;

public class Sliding_Window_Maximum {
    public static void main(String[] args) {
        int[] arr = {2,5,1,3,8};
        System.out.println(Arrays.toString(maxSlidingWindow(arr,2)));
    }

    //Optimal approach - using Deque
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n-k+1];
        //n-k+1 is the number of sub-arrays that can be made from the given array having a fixed size of k
        Deque<Integer> dq = new LinkedList<>();  // store index values
        int idx = 0;
        //n length tak jaenge as i represents the right end of the window not the left unlike brute force
        for(int i=0;i<n;i++) {
            //Checking if the current max element in the dequeue is out of the current window parameter
            if(!dq.isEmpty() && dq.peekFirst() == i-k) {
                dq.removeFirst();
            }
            //Making a decreasing deque - previous greater element
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
            //If all the elements of the current window have been traversed, update it's max in ans[]
            if(i >= k-1) {
                ans[idx++] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }



    //Tried stack based approach but not possible
//    public static int[] maxSlidingWindow2(int[] nums, int k) {
//        Stack<Integer> st = new Stack<>();
//        for (int i = 0; i < nums.length; i++) {
//            while(!st.isEmpty() && nums[st.peek()]<=nums[i] && k>0){
//                st.pop();
//                k++;
//            }
//            st.push(i);
//            k--;
//        }
//    }



    //Brute force - TLE
    //TC - O(N*M)
    //SC - O(N)
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        for (int i = 0; i <= nums.length-k; i++) {
            ans[i] = max(Arrays.copyOfRange(nums,i,i+k));
        }
        return ans;
    }
    public static int max(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max,arr[i]);
        }
        return max;
    }
}
