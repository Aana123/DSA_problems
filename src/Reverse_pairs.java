public class Reverse_pairs {
    public static void main(String[] args) {
        int[] arr = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        System.out.println(reversePairs(arr));
    }
    //Best
    public static int reversePairs(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }
    private static int mergeSortAndCount(int[] arr, int start, int end){
        if (start >= end) {
            return 0;
        }

        int mid = start + (end - start) / 2;
        int count = 0;

        count += mergeSortAndCount(arr, start, mid);
        count += mergeSortAndCount(arr, mid + 1, end);
        count += mergeAndCount(arr, start, mid, end);

        return count;
    }
    private static int mergeAndCount(int[] arr, int left, int mid, int right) {
        int count = 0;
        int p = mid + 1;

        // Counting reverse pairs
        for (int i = left; i <= mid; i++) {
            while (p <= right && arr[i] > 2 * (long) arr[p]) {
                p++;
            }
            count += (p - (mid + 1));
        }

        // Merging the two halves
        int[] temp = new int[right - left + 1];
        int i = left, k = 0;
        p = mid + 1;

        while (i <= mid && p <= right) {
            if (arr[i] <= arr[p]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[p++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (p <= right) {
            temp[k++] = arr[p++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = temp[i - left];
        }

        return count;
    }

    //TLE
    public static int reversePairs1(int[] nums) {
        int count = 0;
        for(int i = 0; i<nums.length; i++){
            long a = nums[i];
            for(int p = i+1; p<nums.length; p++){
                long b = nums[p];
                if(a>2*b){
                    count++;
                }
            }
        }
        return count;
    }
}
