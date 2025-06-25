public class Min_days_to_make_m_bouquets {
    public static void main(String[] args) {
        int[] arr = {7,9,16,5,12,7,10};
        System.out.println(minDays(arr,3,2));
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) {
            return -1;
        }
        int start = 1;
        int end = max(bloomDay);
        while(start<=end){
            int mid = (start+end)/2;
            if(helper(bloomDay,mid,m,k)<=0){
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
    public static int helper(int[] arr, int p, int h,int k){
        int m = k; int i = 0;
        while(i < arr.length && h>0) {
            while(k>0 && i<arr.length){
                if(arr[i]<=p){
                    k--;
                }else{
                    i++;
                    break;
                }
                i++;
            }
            if(k==0){
                h--;
            }
            k = m;
        }
        return h;
    }
}
