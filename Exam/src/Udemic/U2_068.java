package Udemic;

class Hat {
    public int ID = 0;
    public String name = "hat";
    public String size = "One Size Fit All";
    public String color = "";
    public String getName() { return name; }
    public void setName(String name) {
      this.name = name;
    }
}
   
public class U2_068 { // blackCowboyHat
    public static void main(String[] args) {
        Hat blackCowboyHat = new Hat();
        blackCowboyHat.setName("Cowboy Hat");
        System.out.println(blackCowboyHat.getName());
        // Cowboy Hat
 
        // blackCowboyHat.setName = "Cowboy Hat";
        // cannot find symbol
        // setName("Cowboy Hat");
        // cannot find symbol
        // Hat.setName("Cowboy Hat");
        // non-static method setName() cannot
        // be referenced from a static context
    }
}
