public class Book_allocation {
    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        System.out.println(findPages(arr,2));
        //Mid is the maximum number of pages !!!
    }
    public static int findPages(int[] arr, int k) {
        if(arr.length<k){
            return -1;
        }
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

    //Pichle se try
    public static int helper1(int[] arr, int p){
        int need = 1, cur = 0;
        for (int w: arr) {
            if(w>p){
                return p;
            }
            if (cur + w > p) {
                need += 1;
                cur = 0;
            }
            cur += w;
        }
        return need;
    }
}
