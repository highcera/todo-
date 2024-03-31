package Udemic;

public class U2_029 {
    public static void main(String[] args) {
        String movie = "The";
        movie.concat(" ").concat("MATRIX".toLowerCase());
        // movie = movie.concat(" ").concat("MATRIX".toLowerCase());
        System.out.print(movie.substring(5, 6));
        // StringIndexOutOfBoundsException
    }
}
