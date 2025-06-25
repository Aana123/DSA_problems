import java.util.Arrays;
import java.util.HashMap;

public class sort_people {
    public static void main(String[] args) {
        String[] str = {"Mary","John","Emma"};
        int[] he = {180,165,170};
        System.out.println(Arrays.toString(sortPeople(str,he)));
    }


    //Brute force
    public static String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer,String> hs = new HashMap<>();
        for(int i = 0; i<names.length; i++){
            hs.put(heights[i],names[i]);
        }
        String[] str = new String[names.length]; int i = 0;
        while(i<names.length){
            int max = 0; int p = 0;
            while(p<heights.length){
                max = Math.max(max,heights[p]);
                p++;
            }for(int q = 0; q<heights.length;q++){
                if(heights[q]==max){
                    heights[q]=0;
                    break;
                }
            }
            str[i] = hs.get(max);
            i++;
        }
        return str;
    }
}
