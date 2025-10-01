import java.util.HashMap;

public class LRU_Cache {
    public static void main(String[] args) {
//        LRUCache lr = new LRUCache(2);
//        lr.put(1,1);
//        lr.put(2,2);
//        lr.get(1);
//        lr.put(3,3);
    }
}
class LRUCache {
    HashMap hs;
    HashMap helper;
    public LRUCache(int capacity) {
        hs = new HashMap<>(capacity);
        helper = new HashMap<>();
    }
    public int get(int key) {
        int freq = (int) helper.getOrDefault(key,0);
        helper.put(key,freq+1);
        return (int) hs.getOrDefault(key,-1);
    }

//    public void put(int key, int value) {
//        if(hs.containsKey(key)){
//
//        }
//        hs.put(key,value);
//        helper.put(key,value);
//    }
}
