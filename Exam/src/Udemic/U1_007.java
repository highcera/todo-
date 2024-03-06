package Udemic;

class U1_007 {
    public static void main(String[] args) {
    
        boolean baloonInflated = false;
        do {
            if (!baloonInflated) {
            baloonInflated = true;
            System.out.print("inflate-");
            }
        } while (baloonInflated);
        System.out.println("done");
    }
}

// infinite loop