import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Next_greater_1 {
    public static void main(String[] args) {
        int[] a = {4,1,2};
        int[] b = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(a,b)));
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2){
        HashMap<Integer,Integer> hs = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int i : nums2){
            //while the stack is not empty and current element is greater than top of the stack then put that element
            // in hashmap as value
            while(!st.isEmpty() && i<st.peek()){
                hs.put(st.pop(),i);
            }
            //push current element into the stack
            st.push(i);
        }
        int[] ans = new int[nums1.length];
        for(int a  = 0; a<nums1.length; a++){
            ans[a] = hs.getOrDefault(nums1[a],-1);
        }
        return ans;
    }

    //brute force using hashmap
    public static int[] nextGreaterElement3(int[] nums1, int[] nums2){
        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int i = 0; i<nums2.length; i++){
            hs.put(nums2[i],-1);
            for (int j = i+1; j < nums2.length; j++) {
                if(nums2[j]>nums2[i]){
                    hs.put(nums2[i],nums2[j]);
                    break;
                }
            }
        }
        int[] ans = new int[nums1.length];
        for(int a  = 0; a<nums1.length; a++){
            ans[a] = hs.get(nums1[a]);
        }
        return ans;
    }

    //absolute brute
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length];
        int a = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int k = 0; k < nums2.length; k++) {
                if(nums1[i]==nums2[k]){
                    for (int p = k+1; p < nums2.length; p++) {
                        if(nums2[p]>nums2[k]){
                            nums[a]=nums2[p];
                            break;
                        }
                        else{
                            nums[a]=-1;
                        }
                    }
                }
            }
            if(nums1[i]==nums2[nums2.length-1]){
                nums[a]=-1;
            }
            a++;
        }

        return nums;
    }

    //meine broken try
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length];
        int p = 0;
        for (int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                int q = p;
                if(nums2[j]==nums1[i]){
                    while(j< nums2.length){
                        if(nums2[j]>nums1[i]){
                            arr[p] = nums2[j];
                            p++;
                            break;
                        }
                        else {
                            j++;
                        }
                    }
                }
                if(p==q){
                    arr[p] = -1;
                }
            }
        }
        return arr;
    }
}
