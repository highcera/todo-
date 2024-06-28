package Udemic;

class PrintException extends Exception {}
class PaperPrintException extends PrintException {}
interface Printer {
    abstract int printData() throws PrintException;
}

class Test1 implements Printer {
    public int printData() { return 0; }
}
class Test2 implements Printer {
    public int printData() throws PaperPrintException { return 0; }
}
class Test3 implements Printer {
    public int printData() throws PrintException { return 0; }
}
// class Test4 implements Printer {
//     public int printData() throws Exception { return 0; }
// }
public class U3_Q3154 {
    public static void main(String[] args) {}
}
