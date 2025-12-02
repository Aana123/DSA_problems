import java.util.HashMap;
import java.util.HashSet;

public class Check_If_N_and_Its_Double_Exist {
    public static void main(String[] args) {
        int[] arr = {1,3,0,0};
        System.out.println(checkIfExist(arr));
    }
    //TC - O(N)
    //SC - O(N)
    public static boolean checkIfExist(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0; i<arr.length; i++){
            hs.add(arr[i]);
            hm.put(arr[i],i);
        }
        for(int i = 0; i<arr.length; i++){
            if(hs.contains(arr[i]*2)){
                if(hm.get(arr[i]*2)!=i) {
                    return true;
                }
            }
        }
        return false;
    }
}
