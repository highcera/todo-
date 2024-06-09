package Udemic;

class Forest {
    public long treeCount;
    public Forest() {}  // This makes it compile!
    public Forest(long treeCount) {
        this.treeCount = treeCount + 2;
    }
}
public class U4_125 extends Forest {  // RainForest
    public U4_125 (long treeCount) {
        // super(treeCount);  // This would also make it compile!
        this.treeCount = treeCount + 1;
    }
    public static void main(String[] birds) {
        System.out.print(new U4_125(5).treeCount);  // 6
    }
}