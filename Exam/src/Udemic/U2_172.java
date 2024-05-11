package Udemic;

public class U2_172 {  // Address
    public String getAddress(String street, String city) {
        try {
            return street.toString() + " - " + city.toString();
        } finally {
            System.out.print("Posted:");
        }
    }
    public static void main(String[] form) {
        String street = "350 5th Ave";
        String city = "New York";
        System.out.print(new U2_172().getAddress(street,city));
        // Posted:350 5th Ave - New York
    }
}