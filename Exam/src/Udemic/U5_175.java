package Udemic;

class GasException extends Exception {}
class Element {
    public int getSymbol() throws GasException { return -1; }  // Line g1
}
public class U5_175 extends Element {  // Oxygen
    public static void main(String[] args) {}
    public int getSymbol() { return 8; }                       // Line g2
    public void printData() {
        try {
            System.out.print(getSymbol());
        // } catch {  // '(' expected                          // Line g3
        } catch (Exception e) {
            System.out.print("Unable to read data");
        }
    }
}