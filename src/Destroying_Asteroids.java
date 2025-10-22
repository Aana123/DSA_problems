import java.util.Arrays;

public class Destroying_Asteroids {
    public static void main(String[] args) {
        int[] asteroids = {3,9,19,5,21};
        int mass = 10;
        System.out.println(asteroidsDestroyed(mass,asteroids));
    }
    //Optimal solution
    //TC - O(Nlog(n))
    //SC - O(1)
    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long tempMass = mass;
        for(int i = 0; i<asteroids.length; i++){
            if(tempMass>=asteroids[i]){
                tempMass += asteroids[i];
            } else{
                return false;
            }
        }
        return true;
    }
}
