import java.util.Arrays;
import java.util.HashMap;

public class The_Two_Sneaky_Numbers_of_Digitville {
    public static void main(String[] args) {
        int[] nums = {7,1,5,4,3,4,6,0,9,5,8,2};
        System.out.println(Arrays.toString(getSneakyNumbers(nums)));
    }
    //TC - O(N)
    //SC - O(1)
    public static int[] getSneakyNumbers(int[] nums) {
        HashMap<Integer,Integer> hs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hs.put(nums[i],hs.getOrDefault(nums[i],0)+1);
        }
        System.out.println(hs);
        int n1 = -1, n2 = -1;
        for (int i = 0; i<hs.size(); i++) {
            if(hs.get(i)==2){
                if(n1 == -1){
                    n1 = i;
                } else {
                    n2 = i;
                }
            }
        }
        return new int[] {n1,n2};
    }
    //TC - O(nLog*n+n)
    //SC - O(1)
    public static int[] getSneakyNumbers1(int[] nums) {
        Arrays.sort(nums);
        int cur = 0, n1 = -1, n2 = -1;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]!=cur){
                if(n1 == -1){
                    n1 = nums[i];
                } else {
                    n2 = nums[i];
                }
            }else{
                cur++;
            }
        }
        return new int[] {n1,n2};
    }
}
