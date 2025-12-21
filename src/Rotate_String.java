public class Rotate_String {
    public static void main(String[] args) {
        String s = "abcde", goal = "cdeab";
        System.out.println(rotateString(s,goal));
    }

    //Optimal solution
    //TC - O(N^2) - worst case
    //SC - O(N)
    public static boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        String ans = s+s;
        return ans.contains(goal);
    }

    //Brute force
    //TC - O(N^2)
    //SC - O(N)
    public static boolean rotateString1(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        StringBuilder sb = new StringBuilder(s); //O(N)
        for (int i = 0; i < goal.length(); i++) { //O(N)
            if(sb.substring(i,sb.length()).equals(goal)){ //O(N+N)
                return true;
            }
            sb.append(s.charAt(i)); //O(1)
        }
        return false;
    }
}
