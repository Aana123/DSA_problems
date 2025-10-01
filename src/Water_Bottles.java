public class Water_Bottles {
    public static void main(String[] args) {
        System.out.println(numWaterBottles(9,3));
    }
    //Time complexity: O(n)
    //Space complexity: O(1)
    public static int numWaterBottles(int numBottles, int numExchange) {
        int totalBottles = numBottles;
        while(numBottles>0){
            int c = numBottles/numExchange;
            if(c!=0){
                numBottles = c+(numBottles%numExchange);
            }else{
                numBottles = c;
            }
            totalBottles += c ;
        }
        return totalBottles;
    }
}
