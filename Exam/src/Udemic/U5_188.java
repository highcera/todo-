package Udemic;

public class U5_188 {  // ObjectFields {
    int iVar;
    static int cVar;
    void setFields(){
        this.iVar = 22;
        this.cVar = 22;
    }
    public static void main(String[] args) {
        U5_188 of = new U5_188();
        of.iVar = 100;
        U5_188.cVar = 200;
        // iVar = 200;
        cVar = 300;
        // this.iVar = 200;
        // this.cVar = 400;
        of.iVar = 100;
        of.cVar += 200;
        System.out.println("iVar=" + of.iVar + ", cVar=" + of.cVar);
        U5_188.cVar += 300;
        System.out.println("iVar=" + of.iVar + ", cVar=" + of.cVar);
        of.setFields();
        System.out.println("iVar=" + of.iVar + ", cVar=" + of.cVar);
        // iVar=22, cVar=22
    }
}