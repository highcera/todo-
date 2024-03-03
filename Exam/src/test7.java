public class test7 {
    public static void main(String args[]){
        int x = 1;
        int y = new test7().change(x);
        System.out.print(x+y);
    }
    int change(int x) {
        x = 2;
        return x;
    }
   
}
