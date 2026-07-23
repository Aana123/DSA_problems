public class Minimum_Add_to_Make_Parentheses_Valid {
    public static void main(String[] args) {
        String s = "()(";
        System.out.println(minAddToMakeValid(s));
    }
    public static int minAddToMakeValid(String s) {
        int opened = 0, closed = 0, ans = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                opened++;
            }
            else if(s.charAt(i)==')'){
                opened--;
                if(opened<0){
                    ans++;
                }
            }
        }
        for(int i = s.length()-1; i>=0; i--){
            if(s.charAt(i)==')'){
                closed++;
            }
            else if(s.charAt(i)=='('){
                closed--;
                if(closed<0){
                    ans++;
                }
            }
        }
        return ans;
    }
}
