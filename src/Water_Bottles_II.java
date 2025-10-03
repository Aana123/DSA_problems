public class Water_Bottles_II {
    public static void main(String[] args) {
        System.out.println(maxBottlesDrunk(20,1));
    }
    //TC - O(N)
    //SC - O(1)
    public static int maxBottlesDrunk(int numBottles, int numExchange) {
        int totalBottles = numBottles;
        int emptyBottles = numBottles;
        numBottles = 0;
        while(emptyBottles>=numExchange){
            emptyBottles -= numExchange;
            numBottles++; numExchange++; totalBottles++; emptyBottles++;
        }
        return totalBottles;
    }
}
