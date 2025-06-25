import java.util.Arrays;

public class median_of_two_sorted_arrays {
    public static void main(String[] args) {
        int[] nums1 = {2,3,6,7,9};
        int[] nums2 = {1,4,8,10};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    //Brute force
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length; int n = nums2.length;
        int[] ans = new int[m+n];
        int p = 0; int q = 0;
        int i = 0;
        while(p<m && q<n){
            if(nums1[p]<=nums2[q]){
                ans[i] = nums1[p];
                p++;
            } else{
                ans[i] = nums2[q];
                q++;
            }
            i++;
        }
        while(p<m){
            ans[i] = nums1[p];
            p++;
            i++;
        }
        while(q<n){
            ans[i] = nums2[q];
            q++;
            i++;
        }
        System.out.println(Arrays.toString(ans));
//        double an;
//        if(ans.length%2==0){
//            an = (double) (ans[(ans.length / 2) - 1] + ans[ans.length / 2]) /2;
//        } else{
//            an = ans[ans.length/2];
//        }
//        return an;

        return ans[5];
    }
}
