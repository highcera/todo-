package Udemic;

public class U1_Q1122 {
    public static void main(String[] args) {
        AnotherSampleClass asc = new AnotherSampleClass();
        SampleClass sc = new SampleClass();
        sc = asc;
        System.out.println("sc: " + sc.getClass());    // sc: class AnotherSampleClass
        System.out.println("asc: " + asc.getClass());  // asc: class AnotherSampleClass
    }
}
class SampleClass { }
class AnotherSampleClass extends SampleClass {}