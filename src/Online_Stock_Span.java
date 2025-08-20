import java.util.*;

public class Online_Stock_Span {
    public static void main(String[] args) {
        StockSpanner sp = new StockSpanner();
        System.out.println(sp.next(100));
        System.out.println(sp.next(80));
        System.out.println(sp.next(60));
        System.out.println(sp.next(70));
        System.out.println(sp.next(60));
        System.out.println(sp.next(75));
        System.out.println(sp.next(85));
    }
}
class StockSpanner {
    Stack<Integer> st;
    ArrayList<Integer> arr;
    int idx;
    public StockSpanner() {
        st  = new Stack<>();
        arr = new ArrayList<>();
        //to maintain the index of arraylist
        idx = 0;
    }

    public int next(int price) {
        arr.add(price);

        int ans = 0;
        //previous greater element - decreasing stack
        while(!st.isEmpty() && arr.get(st.peek())<=arr.get(idx)){
            st.pop();
        }

        if(st.isEmpty()){
            ans = idx+1;
        } else{
            ans = idx-st.peek();
        }

        st.push(idx);
        idx++;
        return ans;
    }


    //tried a lil too bad mem :( firstly tried to fit in pse then assumed arraylist as array - faltu for loop making n^2
    //baar baar call karna manually(here) means apn for loop ka kaam khud he kar rhe hai, hence inside a for only needed
//    int idx = 0;
//    public int next(int price) {
//        hs.put(idx++,price);
//
//        int ans = 1;
//        for (int i = 0; i < hs.size(); i++) {
//
//            while(!st.isEmpty() && hs.get(st.peek())>=hs.get(i) && st.peek()!=i-1){
//                st.pop();
//            }
//            if(st.isEmpty()){
//                return ans;
//            }
//            st.push(price);
//        }
//
//        return ans;
//    }

}
