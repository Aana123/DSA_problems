import java.util.HashMap;

public class Rabbits_in_Forest {
    public static void main(String[] args) {
        int[] ans = {1,0,1,0,0};
        System.out.println(numRabbits(ans));
    }
    public static int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int total = 0;

        for (int i : answers) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : map.keySet()) {
            if(i==0){
                total += map.get(i);
            } else{
                total += i+1;
            }
        }
        return total;
    }
}
