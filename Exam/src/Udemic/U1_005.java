package Udemic;

class U1_005 {
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
        U1_005 test = new U1_005();
        test.setStuff("Hello");
        
        System.out.println(test.getStuff());
    }
}