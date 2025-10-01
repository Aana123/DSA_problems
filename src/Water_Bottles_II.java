public class Water_Bottles_II {
    public static void main(String[] args) {
        System.out.println(maxBottlesDrunk(20,1));
    }
    //incorrect
    public static int maxBottlesDrunk(int numBottles, int numExchange) {
        int totalBottles = numBottles;
        while(numBottles>0){
            int c = numBottles/numExchange;
            if(c!=0){
                numBottles = c+(numBottles%numExchange);
            }else{
                numBottles = c;
            }
            totalBottles += c;
            numBottles -= numExchange;
            numExchange++;
        }
        return totalBottles;
    }
}
