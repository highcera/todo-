package Udemic;

public class U1_130 {
    static String checkPets(StringBuilder myPet, StringBuilder yourPet){      
        return myPet == yourPet ? "same" : "different";
    }
    static String checkNames(StringBuilder myPet, StringBuilder yourPet){
        return myPet.equals(yourPet) ? "same" : "different";
    }
    public static void main(String[] args) {
        StringBuilder myPet = new StringBuilder("Fluffy");
        StringBuilder yourPet = new StringBuilder("Fluffy");
        System.out.print(checkPets(myPet, yourPet) + " pets, ");
        // different pets, 
        System.out.println(checkNames(myPet, yourPet) + " names");
       // different names
    }
}
