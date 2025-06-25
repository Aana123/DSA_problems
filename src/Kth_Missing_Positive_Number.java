import java.util.HashSet;

public class Kth_Missing_Positive_Number {
    public static void main(String[] args) {
        int[] arr = {1,4,5};
        System.out.println(findKthPositive(arr,2));
    }
    public static int findKthPositive(int[] arr, int k){
        for(int i : arr){
            if(i <= k){
                k++;
            }else{
                break;
            }
        }
        return k;
    }

    //Brute force
    public static int findKthPositive1(int[] arr, int k) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i : arr){
            hs.add(i);
        }
        int count = 0; int i = 1;
        while(count<=k){
            if(!hs.contains(i)){
                count++;
            }
            if(count==k){
                return i;
            }
            i++;
        }
        return -1;
    }
}
