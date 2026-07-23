import java.util.Arrays;

public class Minimum_Platforms {
    public static void main(String[] args) {
        int arr[] = {1000, 935, 1100};
        int dep[] = {1200, 1240, 1130};
        System.out.println(minPlatform(arr,dep));
    }
    public static int minPlatform(int arr[], int dep[]) {
        int n = arr.length; int count = 0;
        int[][] ans = new int[n][2];
        for (int i = 0; i < n; i++) {
            ans[i][0] = arr[i];
            ans[i][1] = dep[i];
        }
        Arrays.sort(ans,(a, b) -> Integer.compare(a[1],b[1]));
        System.out.println(Arrays.deepToString(ans));
        int j = 0;
        while(j<n){
            int max1 = ans[0][0], max2 = ans[0][1];
            for(int i = 1; i<n; i++){
                if(ans[i][0]>max1 && ans[i][0]>max2){
                    max1 = ans[i][0];
                    max2 = ans[i][1];
                } else{
                    count++;
                }
            }
            j++;
        }
        return count;
    }
}
