public class Ship_Packages_Within_D_Days {
    public static void main(String[] args) {
        int[] arr = {3,2,2,4,1,4};
        System.out.println(shipWithinDays(arr,3));
    }
    public static int shipWithinDays(int[] weights, int days) {
        int start = max(weights);
        int end = sum(weights);
        while(start<end){
            int mid = (start+end)/2;
            if(helper(weights,mid)>days){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return start;
    }
    public static int max(int[] arr){
        int ans = 0;
        for (int j : arr) {
            ans = Math.max(ans, j);
        }
        return ans;
    }
    public static int sum(int[] arr){
        int ans = 0;
        for (int j : arr) {
            ans += j;
        }
        return ans;
    }
    public static int helper(int[] arr, int p){
        int need = 1, cur = 0;
        for (int w: arr) {
            if (cur + w > p) {
                need += 1;
                cur = 0;
            }
            cur += w;
        }
        return need;
    }



    //self
    public static int shipWithinDays1(int[] weights, int days) {
        int start = max(weights);
        int end = sum(weights);
        while(start<end){
            int mid = (start+end)/2;
            if(helper1(weights,mid,days)>=0){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return start;
    }

    //mem T_T *2
    public static int helper2(int[] arr, int p, int h){
        int i = 0; int sum = arr[0];
        while(i<arr.length){
            if(arr[i]>p){
                return -1;
            }
            if(sum<=p && i<arr.length-1){
                sum += arr[i+1];
            }
            else{
                h--;
                sum = arr[i];
                if(i<arr.length-1){
                    i--;
                }
            }
            i++;
        }
        if(i==arr.length && sum<p){
            h--;
        }
        return h;
    }


    //mem T-T
    public static int helper1(int[] arr, int p, int h){
        int i = 0; int sum = arr[0];
        while(i < arr.length-1) {
            if(sum<=p){
                while(sum<=p && i < arr.length-1){
                    i++;
                    sum += arr[i];
                }
                if(arr[i]>p){
                    return -1;
                }
                h--;
                sum = arr[i];
            }else{
                return -1;
            }
        }
        if(arr[i]<sum){
            h--;
        }
        return h;
    }
}
