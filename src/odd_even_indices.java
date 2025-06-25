import java.util.Arrays;

public class odd_even_indices {
    public static void main(String[] args) {
        int[] arr = {36,45,32,31,15,41,9,46,36,6,15,16,33,26,27,31,44};
        System.out.println(Arrays.toString(sortEvenOdd(arr)));
    }
    //Brute force
    public static int[] sortEvenOdd(int[] nums){
        int[] even;
        if(nums.length%2!=0){
            even = new int[(nums.length/2)+1];
        } else{
            even = new int[nums.length/2];
        }
        int[] odd = new int[nums.length/2];

        int p = 0; int q = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i%2==0){
                even[p] = nums[i];
                p++;
            } else{
                odd[q] = nums[i];
                q++;
            }
        }

        Arrays.sort(even);
        Arrays.sort(odd);

        p = 0; q = odd.length-1;
        for (int i = 0; i < nums.length; i++) {
            if(i%2==0){
                nums[i] = even[p];
                p++;
            } else{
                nums[i] = odd[q];
                q--;
            }
        }

        return nums;
    }


    //Wrong interpretation - odd = decreasing adn even = increasing me thought T-T
    public static int[] sortEvenOdd1(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.sort(nums);
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]%2==0){
                ans[p] = nums[i];
                p = p+2;
            }
        }
        p = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            if(nums[i]%2!=0){
                ans[p] = nums[i];
                p = p+2;
            }
        }
        return ans;
    }
}
