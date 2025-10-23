import java.util.Arrays;

public class Minimum_Cost_of_Buying_Candies_With_Discount {
    public static void main(String[] args) {
        int[] cost = {7,4,2};
        System.out.println(minimumCost(cost));
    }
    //Optimal solution
    //TC -O(N)
    //SC -O(1)
    public static int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int ans =  0, count = 2;
        for(int i = cost.length-1; i>=0; i--){
            if(count==0){
                count = 2;
            } else{
                ans += cost[i];
                count--;
            }
        }
        return ans;
    }
}
