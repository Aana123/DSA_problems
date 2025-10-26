import java.util.Arrays;

public class Fractional_Knapsack {
    public static void main(String[] args) {
        int[] val = {60,100,120,100};
        int[] wt = {10,20,30,10};
        System.out.println(fractionalKnapsack(val,wt,50));
    }
    //TC - O(NlogN)
    //SC - O(1)
    public static double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        int n = val.length;

        // Create 2D array to store value and weight
        // items[i][0] = value, items[i][1] = weight
        double[][] items = new double[n][3];

        for (int i = 0; i < n; i++) {
            //val/wt ratio, val, wt
            items[i][0] = (1.0*val[i]/wt[i]);
            items[i][1] = (1.0*(val[i]));
            items[i][2] = (1.0*(wt[i]));
        }
        System.out.println(Arrays.deepToString(items));

        // Sort items based on value-to-weight ratio in descending order
        Arrays.sort(items,(a, b) -> Double.compare(b[0], a[0]));
        System.out.println(Arrays.deepToString(items));
        double ans = 0.0;
        int currentCapacity = capacity;

        // Process items in sorted order
        for (int i = 0; i < n; i++) {

            // If we can take the entire item
            if (items[i][2] <= currentCapacity) {
                ans += items[i][1];
                currentCapacity -= items[i][2];
            }

            // Otherwise take a fraction of the item
            else {
                ans += (1.0 * items[i][1] / items[i][2]) * currentCapacity;

                // Knapsack is full
                break;
            }
        }

        return ans;
    }
}
