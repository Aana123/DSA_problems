import java.util.Arrays;

public class Buy_Maximum_Stocks {
    public static void main(String[] args) {
        int[] price = {4,5,3,1};
        System.out.println(buyMaximumProducts(price.length,10,price));
    }
    //2d array sorting
    //TC - O(Nlogn)
    //SC - O(N)
    public static int buyMaximumProducts(int n, int k, int[] price) {
        int[][] ans = new int[n][2];
        int count = 0;
        for (int i = 0; i < n; i++) {
            ans[i][0] = price[i];
            ans[i][1] = i+1;
        }
        Arrays.sort(ans, (a,b) -> Integer.compare(a[0],b[0]));
        System.out.println(Arrays.deepToString(ans));

        int i = 0;
        while(k>0 && i<n){
            count += Math.min(ans[i][1],k/ans[i][0]);
            k -= ans[i][0]*ans[i][1];
            i++;
        }
        return count;
    }
}
