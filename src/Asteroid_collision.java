import java.util.Arrays;
import java.util.Stack;

public class Asteroid_collision {
    public static void main(String[] args) {
        int[] arr = {5,10,-5};
        System.out.println(Arrays.toString(asteroidCollision(arr)));
    }

    //Brute force
    //TC - O(N)
    //SC - O(N)
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int i = 0;
        while(i < asteroids.length) {
            //Conditions to pop
            if (!st.isEmpty() && st.peek() > 0 && asteroids[i] < 0 && st.peek() == Math.abs(asteroids[i])) {
                st.pop();
                i++;
            }
            while(i<asteroids.length && !st.isEmpty() && st.peek()>0 && asteroids[i]<0 && st.peek()<Math.abs(asteroids[i])) {
                st.pop();
            }
            if(i<asteroids.length && !st.isEmpty() && st.peek()>0 && asteroids[i]<0 && st.peek()>Math.abs(asteroids[i])){
                i++;
            }
            //Conditions to push
            if(i<asteroids.length){
                if(st.isEmpty() || asteroids[i]>0){
                    st.push(asteroids[i]);
                    i++;
                }
                else if(st.peek()<0 && asteroids[i]<0){
                    st.push(asteroids[i]);
                    i++;
                }
            }
        }
        int[] ans = new int[st.size()];
        for (int j = ans.length-1; j >= 0; j--) {
            ans[j] = st.pop();
        }

        return ans;
    }

    //Mis-interpreted the question
    public static int[] asteroidCollision1(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int i = 0;
        while(i < asteroids.length) {
            //Conditions to pop
            if (!st.isEmpty() && st.peek()>0 && asteroids[i]<0 && st.peek()==Math.abs(asteroids[i])) {
                st.pop();
                i++;
            } else if(!st.isEmpty() && st.peek()<0 && asteroids[i]>0 && Math.abs(st.peek())==asteroids[i]){
                st.pop();
                i++;
            }
            while(!st.isEmpty() && st.peek()>0 && asteroids[i]<0 && st.peek()<Math.abs(asteroids[i])) {
                st.pop();
            }
            while(!st.isEmpty() && st.peek()<0 && asteroids[i]>0 && Math.abs(st.peek())<asteroids[i]){
                st.pop();
            }
            //Conditions to push
            if(i<asteroids.length){
                if(st.isEmpty()){
                    st.push(asteroids[i]);
                    i++;
                }
                else if(st.peek()<0 && asteroids[i]<0){
                    st.push(asteroids[i]);
                    i++;
                }
                else if(st.peek()>0 && asteroids[i]>0){
                    st.push(asteroids[i]);
                    i++;
                }
            }
        }
        int[] ans = new int[st.size()];
        for (int j = ans.length-1; j >= 0; j--) {
            ans[j] = st.pop();
        }

        return ans;
    }
}
