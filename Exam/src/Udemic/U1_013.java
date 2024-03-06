package Udemic;

public class U1_013 {
    public static void main(String[] args) {}
}

interface Implementable {
void runMe() throws java.io.IOException;
}

class Implementer1 implements Implementable {
public void runMe() throws java.io.IOException {}
}

class Implementer2 implements Implementable {
public void runMe() throws java.io.FileNotFoundException {}
}

class Implementer3 implements Implementable {
public void runMe() {}
}

// class Implementer implements Implementable {
//    // overridden method does not throw java.lang.Exception
//    public void runMe() throws Exception {}
// }


  