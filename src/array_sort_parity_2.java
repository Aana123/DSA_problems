import java.util.ArrayList;
import java.util.Arrays;

public class array_sort_parity_2 {
    public static void main(String[] args) {
        int[] nums = {3,0,4,0,2,1,3,1,3,4};
        System.out.println(Arrays.toString(sortArrayByParityII(nums)));
    }
    //extra space solution
    public static int[] sortArrayByParityII(int[] nums){
        ArrayList<Integer> ls = new ArrayList<>();
        for(int i : nums){
            ls.add(i);
        }
        int p = 0;
        int q = 1;
        for (int i = 0; i<ls.size(); i++) {
            if(ls.get(i)%2==0){
                nums[p] = ls.get(i);
                p = p+2;
            }
            else{
                nums[q] = ls.get(i);
                q = q+2;
            }
        }
        return nums;
    }

    //failed in-place T-T
    public static int[] sortArrayByParityII1(int[] nums) {
        int i = 0;
        for(int p = 0; p<nums.length; p++){
            if(nums[p]%2==0){
                int temp = nums[i];
//                if(nums[i]%2==0){
//                    i = i+2;
//                }
                nums[i] = nums[p];
                nums[p] = temp;
                //change the even number to num-1 so that it does not count again
                nums[i] -= 1;
                i = i+2;
            }
        }
        for (int j = 0; j < nums.length; j = j+2) {
            nums[j] += 1;
        }
        return nums;
    }
}
