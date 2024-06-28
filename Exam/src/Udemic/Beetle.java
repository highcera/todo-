package Udemic;

public class U1_Q1125 {

}

interface HasExoskeleton {
    abstract int getNumberOfSections();
}
abstract class Insect implements HasExoskeleton {
    abstract int getNumberOfLegs();
}
// public class Beetle extends Insect {  // Line 7
public abstract class Beetle extends Insect {
    int getNumberOfLegs() { return 6; }
 
    // public int getNumberOfSections() { return 0; }
}