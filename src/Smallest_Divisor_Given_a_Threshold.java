public class Smallest_Divisor_Given_a_Threshold {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(smallestDivisor(arr,6));
    }
    public static int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = max(nums);
        while(start<=end){
            int mid = (start+end)/2;
            if(helper(nums,mid,threshold)>=0){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return start;
    }
    public static int max(int[] arr){
        int ans = 0;
        for(int i = 0; i < arr.length; i++) {
            ans = Math.max(ans,arr[i]);
        }
        return ans;
    }
    public static int helper(int[] arr, int p, int h){
        int i = 0;
        while(i < arr.length) {
            if(p==1){
                h -= arr[i];
            }
            //vimp
            else if(arr[i]%p==0){
                h -= arr[i]/p;
            }else{
                h -= (arr[i]/p)+1;
            }
            i++;
        }
        return h;
    }
}
