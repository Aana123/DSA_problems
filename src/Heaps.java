import java.util.ArrayList;
import java.util.PriorityQueue;

public class Heaps {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(3);
        pq.add(42);
        pq.add(7);
        pq.add(8);
        pq.add(90);
        System.out.println(pq);
        pq.poll();
        pq.add(39);
        System.out.println(pq);
        System.out.println(pq.peek());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.add(43);
        maxHeap.add(73);
        maxHeap.add(473);
        maxHeap.add(430);
        maxHeap.add(83);
        System.out.println(maxHeap);

        Heap minHeap = new Heap();
        minHeap.add(12);
        minHeap.add(1);
        minHeap.add(2);
        minHeap.add(121);
        System.out.println(minHeap);
        minHeap.peek();
        minHeap.poll();
        System.out.println(minHeap);
        System.out.println(minHeap.isEmpty());
    }

}
class Heap{
    private ArrayList<Integer> heap;
    public Heap(){
        heap = new ArrayList<>();
    }
    private int parent(int i){
        return (i-1)/2;
    }
    private int leftChild(int i){
        return (i*2)+1;
    }
    private int rightChild(int i){
        return (i+1)*2;
    }
    private void swap(int i, int j){
        int temp = heap.get(i);
        heap.set(i,heap.get(j));
        heap.set(j,temp);
    }
    public void add(int val){
        heap.add(val);
        int currentIdx = heap.size()-1;

        while(currentIdx>0 && heap.get(parent(currentIdx))>heap.get(currentIdx)){
            swap(parent(currentIdx),currentIdx);
            currentIdx = parent(currentIdx);
        }
    }
    public int peek(){
        if(heap.isEmpty()) throw new RuntimeException("Heap is Empty!");
        return heap.get(0);
    }
    public int poll(){
        if(heap.isEmpty()) throw new RuntimeException("Heap is Empty!");
        int min = heap.get(0);
        int lastElement = heap.remove(heap.size()-1);
        if(!heap.isEmpty()){
            heap.set(0,lastElement);
            sinkdown(0);
        }
        return min;
    }
    private void sinkdown(int i){
        while(true){
            int minIdx = i;
            int left = leftChild(i);
            int right = rightChild(i);

            if(left<heap.size() && heap.get(left)<heap.get(minIdx)){
                minIdx = left;
            }
            if(right<heap.size() && heap.get(right)<heap.get(minIdx)){
                minIdx = right;
            }

            swap(i,minIdx);
            if(minIdx==i) break;
            i=minIdx;
        }
    }
    public boolean isEmpty(){
        if(heap.isEmpty()) return true;
        return false;
    }
    //since our heap is a custom class printing it gives its hashcode
    @Override
    public String toString(){
        return heap.toString();
    }
}
