class Skillcertlab{
    public static void main(String[] args) {
        int x = -10;
        int y = 10;


        System.out.println(x%(-3));

        if(y++>=10 ^ x%(-3)==-1) 
            System.out.println("A");

    }
}
    
    // A. if(y++>10 | x%(-3)==1)
    // B. if(y>=10&x%(-3)==-1) O
    // C. if(y>10 | x%(3)==-1) O
    // D. if(++y>10 & x%(-3)==1)
    // E. if(++y>10 | x%(-3)==1) o
    // F. if(y++>=10 ^ x%(-3)==-1) 