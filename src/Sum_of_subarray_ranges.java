import java.util.Stack;

public class Sum_of_subarray_ranges {
    public static void main(String[] args) {
        int[] nums = {1,3,3};
        System.out.println(subArrayRanges(nums));
    }
    public static long subArrayRanges(int[] nums) {
        int n = nums.length;
        //Array to store index of previous smaller element
        int[] l1 = new int[n];
        //Array to store index of next smaller element
        int[] r1 = new int[n];
        //Array to store index of previous greater element
        int[] l2 = new int[n];
        //Array to store index of next greater element
        int[] r2 = new int[n];

        //Stack to manage previous and next smaller elements
        Stack<Integer> st1 = new Stack<>();
        //Stack to manage previous and next greater elements
        Stack<Integer> st2 = new Stack<>();

        for(int i = 0; i<n; i++){
            //For prev smaller
            while(!st1.isEmpty() && nums[st1.peek()]>nums[i]){
                st1.pop();
            }
            if(st1.isEmpty()){
                l1[i] = -1;
            }else{
                l1[i] = st1.peek();
            }
            st1.push(i);

            //For prev greater
            while(!st2.isEmpty() && nums[st2.peek()]<nums[i]){
                st2.pop();
            }
            if(st2.isEmpty()){
                l2[i] = -1;
            }else{
                l2[i] = st2.peek();
            }
            st2.push(i);
        }

        st1.clear();
        st2.clear();

        for(int i = n-1; i>=0; i--){
            //For next smaller
            while(!st1.isEmpty() && nums[st1.peek()]>=nums[i]){
                st1.pop();
            }
            if(st1.isEmpty()){
                r1[i] = n;
            }else{
                r1[i] = st1.peek();
            }
            st1.push(i);

            //For next greater
            while(!st2.isEmpty() && nums[st2.peek()]<=nums[i]){
                st2.pop();
            }
            if(st2.isEmpty()){
                r2[i] = n;
            }else{
                r2[i] = st2.peek();
            }
            st2.push(i);
        }

        long left = 0; long right = 0;
        for(int i = 0; i<n; i++){
            left += (long)(i-l1[i])*(r1[i]-i)*nums[i];
            right += (long)(i-l2[i])*(r2[i]-i)*nums[i];
        }

        return right-left;
    }
}
