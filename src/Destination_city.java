import java.util.*;

public class Destination_city {
    public static void main(String[] args) {
        List<String> p1 = Arrays.asList("London", "New York");
        List<String> p2 = Arrays.asList("New York","Lima");
        List<String> p3 = Arrays.asList("Lima","Sao Paulo");
        List<List<String>> paths = Arrays.asList(p1,p2,p3);
        System.out.println(destCity(paths));
    }
    public static String destCity(List<List<String>> paths) {
        Set<String> st = new HashSet<>();
        for(int i = 0; i<paths.size(); i++){
            st.add(paths.get(i).getFirst());
        }
        for (int i = 0; i < paths.size(); i++) {
            if(!st.contains(paths.get(i).get(1))){
                return paths.get(i).get(1);
            }
        }
        return "";
    }
}
