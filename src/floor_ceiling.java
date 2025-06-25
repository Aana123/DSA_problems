import java.util.*;
public class floor_ceiling {
    public static void main(String[] args) {
        int[] ar = {5, 6, 8, 9, 6, 5, 5, 6};
        System.out.println(Arrays.toString(getFloorAndCeil(10,ar)));
    }
    public static int[] getFloorAndCeil(int x, int[] arr) {
        int floor = 0 ; int ceil = 0;
        Arrays.sort(arr);
        int i = 0; int p = arr.length-1;
        while(i<=arr.length){
            if(i==arr.length){
                floor = arr[arr.length-1];
                break;
            }
            if(i==0 && arr[i]>x){
                floor = -1;
                break;
            }
            if(arr[i]>x && i>0){
                floor = arr[i-1];
                break;
            }
            i++;
        }
        while(p>=-1){
            if(p==-1){
                ceil = arr[0];
                break;
            }
            if(p==arr.length-1 && arr[p]<x){
                ceil = -1;
                break;
            }
            if(arr[p]<x && p<x){
                ceil = arr[p+1];
                break;
            }
            p--;
        }
        return new int[]{floor,ceil};
    }
}
