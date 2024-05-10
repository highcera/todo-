package Udemic;

public class U5_108 {  // Gift {
    // private final Object contents;
    private Object contents;
    protected Object getContents() {
        return contents;
    }
    protected void setContents(Object contents) {
        this.contents = contents;
    }
    public void showPresent() {
        System.out.print("Your gift: "+contents);
        // Your gift: wrap.Gift@29453f44
    }
    public static void main(String[] treats) {
        U5_108 gift = new U5_108();
        gift.setContents(gift);
        gift.showPresent();
    }

}
