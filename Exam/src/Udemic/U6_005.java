package Udemic;

import java.util.ArrayList;
import java.util.Arrays;

class Chicken {}
interface HenHouse { public java.util.List<Chicken> getChickens(); }
class MyHenHouse implements HenHouse {
    public java.util.List<Chicken> getChickens() {
        // return null;
        // return new ArrayList<>(Arrays.asList(new Chicken()));
        return new ArrayList<>(Arrays.asList(new Chicken(), new Chicken()));
    }
}
public class U6_005 {  // ChickenSong
    public static void main(String[] args) {
        HenHouse house = new MyHenHouse();
        Chicken chicken = house.getChickens().get(0);             // Line 6
        for(int i=0; i<house.getChickens().size();                // Line 7
            chicken = house.getChickens().get(i++)) {             // Line 8
            System.out.println("Cluck");
        }
    }
}