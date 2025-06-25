import java.util.*;
public class Snapshot_array {
    public static void main(String[] args) {
        SnapshotArray sa = new SnapshotArray(3);
        sa.set(0,3);
        int id = sa.snap();
        System.out.println(id);
        sa.set(0,5);
        int i = sa.get(0,id);
        System.out.println(i);
    }
}
class SnapshotArray {

    int[] arr;
    int i = -1;
    HashMap<Integer,int[]> hs = new HashMap<>();

    public SnapshotArray(int length) {
        arr = new int[length];
    }

    public void set(int index, int val) {
        arr[index] = val;
    }

    public int snap() {
        hs.put(++i,arr);
        return i;
    }

    public int get(int index, int snap_id) {
        int[] array = hs.get(snap_id);
        System.out.println(Arrays.toString(hs.get(0)));
        return array[index];
    }
}
