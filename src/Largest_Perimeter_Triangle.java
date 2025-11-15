import java.util.Arrays;

public class Largest_Perimeter_Triangle {
    public static void main(String[] args) {
        int[] nums = {1,2,1,10};
        System.out.println(largestPerimeter(nums));
    }
    //Optimal solution
    //TC - O(NlogN)
    //SC - O(1)
    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i = nums.length-1; i>1; i--){
            int n1 = nums[i];
            int n2 = nums[i-1];
            int n3 = nums[i-2];
            //Checking if the sum of two numbers is > the largest number then
            // the other two cases will be true by default - if 2+1>10 then 1+10>2 etc
            if(n2+n3>n1){
                return n1+n2+n3;
            }
        }
        return 0;
    }

    //Checker to check for all cases of given three numbers
    public static boolean isPossible(int i, int j, int k){
        if(i+j>k && j+k>i && i+k>j){
            return true;
        }
        return false;
    }
    //Brute force approach will be done in - O(N^3)
}
