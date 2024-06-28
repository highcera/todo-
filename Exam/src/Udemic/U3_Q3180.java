package Udemic;

public class U3_Q3180 {
    public static void main(String[] args) {
        StringBuilder bucket = new StringBuilder("Empty me!");
        // bucket.empty();
        // bucket.clear();
        // bucket.delete(0, bucket.size());
        // bucket.deleteAll();
        // bucket.remove(0, bucket.length());
        // bucket.removeAll();
        bucket.delete(0, bucket.length());
        System.out.println(bucket);  // No output
    }
}
