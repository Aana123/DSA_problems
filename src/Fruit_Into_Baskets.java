import java.util.HashSet;
import java.util.Set;

public class Fruit_Into_Baskets {
    public static void main(String[] args) {
        int[] fruits = {0,1,0,2,2,0,2,1,2,1,0,1,1};
        System.out.println(totalFruit(fruits));
    }
    //Sliding window approach
    //TC - O(N)
    //SC - O(1)
    public static int totalFruit(int[] fruits) {
        Set<Integer> hs = new HashSet<>();
        int left = 0; int right = 0; int max = 0; int k = 2;

        while(right<fruits.length){
            if(hs.isEmpty() || (!hs.contains(fruits[right]) && k>0)){
                hs.add(fruits[right]);
                k--;
                right++;
            } else if(hs.contains(fruits[right])){
                right++;
            } else{
                int lastFruit = fruits[right-1];
                for(int i = right-1; i>=left; i--){
                    if(fruits[i]!=lastFruit){
                        left = i+1;
                        hs.remove(fruits[i]);
                        k++;
                    }
                }
            }
            max = Math.max(max,right-left);
        }
        return max;
    }
}
