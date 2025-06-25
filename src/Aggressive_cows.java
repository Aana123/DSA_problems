import java.util.Arrays;

public class Aggressive_cows {
    public static void main(String[] args) {
        int[] arr = {35, 77, 8, 58, 103, 39, 100, 30, 89, 88, 147, 2, 33, 130, 34, 63, 123, 72, 131, 132, 73, 96, 9, 7, 125, 81, 53, 112, 6, 115, 138, 20, 109, 50, 45, 27};
        //int[] arr = {1,2,4,8,9};
        System.out.println(aggressiveCows(arr,21));
    }
    //Binary search with optimal code
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int start = 0;
        int end = stalls[stalls.length - 1] - stalls[0];
        while(start<=end){
            int mid = (start+end)/2;
            if(helper1(stalls,mid,k)){
                start = mid+1;
            } else{
                end = mid-1;
            }
        }
        return end;
    }
    public static boolean helper1(int[] stalls, int dist, int cows) {
        cows --;
        int last = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - last >= dist) {
                cows--;
                last = stalls[i];
            }
            if (cows == 0) return true;
        }
        return false;
    }



    //Without binary search
    public static boolean canWePlace(int[] stalls, int dist, int cows) {
        int n = stalls.length; //size of array
        int cntCows = 1; //no. of cows placed
        int last = stalls[0]; //position of last placed cow.
        for (int i = 1; i < n; i++) {
            if (stalls[i] - last >= dist) {
                cntCows++; //place next cow.
                last = stalls[i]; //update the last location.
            }
            if (cntCows >= cows) return true;
        }
        return false;
    }
    public static int aggressiveCows2(int[] stalls, int k) {
        int n = stalls.length; //size of array
        //sort the stalls[]:
        Arrays.sort(stalls);

        int limit = stalls[n - 1] - stalls[0];
        for (int i = 1; i <= limit; i++) {
            if (!canWePlace(stalls, i, k)) {
                return (i - 1);
            }
        }
        return limit;
    }



    //Absolute brute force #proud :))
    public static int aggressiveCows1(int[] stalls, int k) {
        Arrays.sort(stalls);
        int start = 0;
        int end = max(stalls);
        while(start<=end){
            int mid = (start+end)/2;
            if(helper(stalls,mid,k)){
                start = mid+1;
            } else{
                end = mid-1;
            }
        }
        return end;
    }
    public static int max(int[] arr){
        int ans = 0;
        for (int j : arr) {
            ans = Math.max(ans, j);
        }
        return ans;
    }
    public static boolean helper(int[] arr, int p, int k){
        int i = 0, cur = 0;
        int[] ans = new int[k]; //int m = i; int n = k;
        while(i<arr.length){
            k--;
            ans[cur] = arr[i]; cur++;
            i++;
            while(k>0 && i<arr.length){
                if(isPossible(ans,p,arr[i],cur)){
                    break;
                }else{
                    i++;
                }
            }
            if(k==0){
                return true;
            }
//            else if(i==arr.length){
//                i = m+1; k = n; cur = 0;
//                ans = new int[k]; m = i;
//            }
        }

        return false;
    }
    public static boolean isPossible(int[] arr, int p, int k, int m){
        for (int i = 0; i<m; i++){
            if (Math.abs(k - arr[i]) < p) {
                return false;
            }
        }
        return true;
    }
}
