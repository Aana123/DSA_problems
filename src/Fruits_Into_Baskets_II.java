public class Fruits_Into_Baskets_II {
    public static void main(String[] args) {
        int[] fruits = {4,2,5};
        int[] baskets = {3,5,4};
        System.out.println(numOfUnplacedFruits(fruits,baskets));
    }
    //TC - O(N^2)
    // SC - O(1)
    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = fruits.length;
        for (int i = 0; i < fruits.length; i++) {
            for (int j = 0; j < baskets.length; j++) {
                if(baskets[j]>=fruits[i]){
                    count--;
                    baskets[j] = 0;
                    break;
                }
            }
        }
        return count;
    }
}
