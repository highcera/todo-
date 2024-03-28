package Udemic;

public class U2_003 { //Netbeans
    private String theme;
    public String getTheme() {
        return theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }
    public static void main (String[] args) {
        U2_003 nb1 = new U2_003();
        U2_003 nb2 = new U2_003();
        nb1.setTheme(null);
        nb2.setTheme("Darcula");
        System.out.print(nb1.getTheme() + " : " + nb2.getTheme());
    }
}
