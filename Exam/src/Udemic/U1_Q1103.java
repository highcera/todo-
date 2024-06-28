package Udemic;

class U1_Q1103 {
    // public String stuff;
    private String stuff;
    public String getStuff() {
        System.out.println("In the getStuff function");
        return stuff;
    }
    public void setStuff(String stuff) {
        this.stuff = stuff;
    }

    public static void main(String[] args) {
        U1_Q1103 test = new U1_Q1103();
        test.setStuff("Hello");
        
        System.out.println(test.getStuff());
    }
}