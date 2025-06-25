import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NSEs_in_array {
    public static void main(String[] args) {
        int[] arr = {5,2,6,1};
        System.out.println(countSmaller1(arr));
    }
//    public static List<Integer> countSmaller(int[] nums) {
//        List<Integer> lis = new ArrayList<>();
//        Stack<Integer> st = new Stack<>();
//        for(int i = 0; i<nums.length;i++){
//            int count = 0;
//            if(){
//                count++;
//            }
//        }
//    }

    //Brute force
    //TC - O(N^2)
    //SC - O(N)
    public static List<Integer> countSmaller1(int[] nums) {
        List<Integer> ans = new ArrayList();
        for(int i = 0; i<nums.length; i++){
            int count = 0;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]<nums[i]){
                    count++;
                }
            }
            ans.add(count);
        }
        return ans;
    }
}
