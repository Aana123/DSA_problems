import java.util.ArrayList;
import java.util.List;

public class Replace_NonCoprime_Numbers_in_Array {
    public static void main(String[] args) {
        int[] nums = {48757,2};
        System.out.println(replaceNonCoprimes(nums));
    }


    public static List<Integer> replaceNonCoprimes(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(nums.length==1){
           arr.add(nums[0]);
        }
        for (int i = 0; i < nums.length; i++) {
            boolean ans;
            if(arr.isEmpty()){
                ans = isNonCoprime(nums[i],nums[i+1]);
                i++;
                if(ans){
                    arr.add(lcm(nums[i],nums[i+1]));
                }
            }else{
                ans = isNonCoprime(arr.getLast(),nums[i]);
                if(ans){
                    int add = lcm(nums[i],arr.getLast());
                    arr.removeLast();
                    arr.add(add);
                }
            }
            if(!ans){
                arr.add(nums[i]);
            }if(!ans && i+1==nums.length-1){
                arr.add(nums[i+1]);
            }

            System.out.println(arr);
        }
        return arr;
    }
    public static int lcm(int a, int b){
        int c = Math.max(a,b);
        for (int i = c; i <= a*b; i+=a) {
            if(i%a==0 && i%b==0){
                return i;
            }
        }
        return -1;
    }
    public static boolean isNonCoprime(int a, int b){
        int c = Math.min(a,b);
        for (int i = 2; i <= c ; i++) {
            if(a%i==0 && b%i==0){
                return true;
            }
        }
        return false;
    }
}
