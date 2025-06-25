public class Painter_partition {
    public static void main(String[] args) {
        int[] arr = {5,10,30,20,15};
        System.out.println(minTime(arr,3));
    }

    public static int minTime(int[] arr, int k) {
        int start = 0;
        int end = sum(arr);
        while(start<=end){
            int mid = (start+end)/2;
            if(helper(arr,mid,k)){
                end = mid-1;
            } else{
                start = mid+1;
            }
        }
        return start;
    }
    public static int sum(int[] arr){
        int ans = 0;
        for (int j : arr) {
            ans += j;
        }
        return ans;
    }
    public static boolean helper(int[] arr, int p, int k){
        int need = 1, cur = 0;
        for (int w: arr) {
            if (cur + w > p) {
                need ++;
                if(need>k || w>p){
                    return false;
                }
                cur = w;
            }else{
                cur += w;
            }
        }
        return true;
    }
}