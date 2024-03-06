package Udemic;

class U1_006 {
    private int i;
    
    public void disp() {
        while (i <= 5) {
            for (int i = 1; i <= 5;) {
                System.out.print(i + " ");
                // 1 2 3 4 5
                // 1 2 3 4 5
                // 1 2 3 4 5
                // 1 2 3 4 5
                // 1 2 3 4 5
                // 1 2 3 4 5
                i++;
            }
            i++;
            System.out.println();
        }
    }
    public static void main(String[] args) {
        U1_006 test = new U1_006();
        test.disp();
    }
}