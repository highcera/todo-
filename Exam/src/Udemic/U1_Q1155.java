package Udemic;

class CastleUnderSiegeException extends Exception {}
class KnightAttackingException extends CastleUnderSiegeException {}

public class U1_Q1155 {    
    public void openDrawbridge() throws RuntimeException {  // Line q1
        try {
            throw new KnightAttackingException();
        } catch (Exception e) {
            throw new ClassCastException();
        } finally {
            // throw new CastleUnderSiegeException();       // Line q2
        }
    }
    public static void main(String[] moat) {
        new U1_Q1155().openDrawbridge();                     // Line q3
    }
}
