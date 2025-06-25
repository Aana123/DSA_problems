public class Kth_rotation {
    public static void main(String[] args) {
        int[] arr = {16, 18, 22, 23, 24, 36, 43, 1, 2};
        System.out.println(findKRotation(arr));
    }
    public static int findKRotation(int[] ar) {
//        int [] ar = new int[arr.size()];
//        int p = 0;
//        for(int i : arr){
//            ar[p] = i;

//            p++;
//        }

        int start = 0;
        int end = ar.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(mid<end && ar[mid]>ar[mid+1]){
                return mid+1;
            } else if(mid>start && ar[mid]<ar[mid-1]){
                return mid;
            } else if(ar[mid]<=ar[end]){
                end = mid-1;
            } else{
                start = mid+1;
            }
        }
        return 0;
    }
}
