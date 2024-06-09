package Udemic;

class Phone {
    String keyboard = "in-built";
    // boolean playMovie;
}
class U4_129 extends Phone {  // Tablet 
    boolean playMovie = false;
    public static void main(String[] args) {
        Phone phone = new U4_129();
        System.out.println(phone.keyboard + ":");
    }

}