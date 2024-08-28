package Udemic;

import java.util.ArrayList;
import java.util.List;

interface CanSwim {}
class Amphibian implements CanSwim {}
class Tadpole extends Amphibian {}

public class U1_Q1141 {
    public static void main(String[] args) {
        List<Tadpole> tadpoles = new ArrayList<Tadpole>();
        for(Amphibian amphibian : tadpoles) {
            CanSwim tadpole1 = amphibian;
            Amphibian tadpole2 = amphibian;
            Object tadpole3 = amphibian;
 
            // Long tadpole4 = amphibian;     // incompatible types
            // Tadpole tadpole5 = amphibian;  // incompatible types
        }
    }
}