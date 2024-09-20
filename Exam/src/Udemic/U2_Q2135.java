package Udemic;

class Ship {
    public int serviceLife;
}
class Starship extends Ship {
    public int shields;
}
class Enterprise extends Starship {
    public int warpSpeed;
}
public class U2_Q2135 {  // ShipSpecs
    public static void main(String[] args) {
        Ship ship = new Ship();
        Starship starship = new Starship();
        Enterprise enterprise = new Enterprise();
        ship.serviceLife = 50;
        enterprise.serviceLife = 45;
        starship.shields = 1000;
        enterprise.warpSpeed = 12;
        // ship.shields = 10;       // Ship doesn't have shields
        // starship.warpSpeed = 2;  // Starship doesn't have warpSpeed
    }
}
