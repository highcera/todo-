package Udemic;

public class U3_056 {
    private String type;  // null
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public static void main(String[] args) {
        U3_056 obj1 = new U3_056();
        U3_056 obj2 = new U3_056();
        // obj1.setType(null);
        obj2.setType("Fresco");
        System.out.print(obj1.getType() + " : " + obj2.getType());
        // null : Fresco
    }
}
