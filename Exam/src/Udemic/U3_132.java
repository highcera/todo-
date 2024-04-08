package Udemic;

class Report {
    int sizeMB;
    String title;
    public Report(int sizeMB, String title) {
        this.sizeMB = sizeMB;
        this.title = title;
    }
}
public class U3_132 {
    public static void main(String[] args) {
        Report r1 = new Report(25, "Report");
        Report r2 = new Report(25, "Report");
        Report r3 = r1;
        boolean b1 = r1 == r2;
        boolean b2 = r2.title.equals(r3.title);
        System.out.print(b1 + " : " + b2);  // false : true
    }
}
