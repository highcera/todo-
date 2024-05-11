package Udemic;

public class U5_136 {  //  Scopetest {
    int z;
    public static void main(String[] args){
        U5_136 myScope = new U5_136();
        int z = 6;
        System.out.print(z + " ");          // 6
        myScope.doStuff();                  // 5
        System.out.print(z + " ");          // 6
        System.out.print(myScope.z + " ");  // 4
    }
    void doStuff(){
        int z = 5;
        doStuff2();
        System.out.print(z + " ");
    }
    void doStuff2(){
        z = 4;
    }

}
