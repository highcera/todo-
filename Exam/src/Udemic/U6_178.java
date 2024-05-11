package Udemic;

// Objects have instance methods while primitives do not.
// Since int is a primitive, you cannot call instance methods on it.
// Integer and String are both objects and have instance methods.

public class U6_178 {
    public String convert1(int value) {
        // return value.toString();
        return Integer.toString(value);
    }
    public String convert2(Integer value) {
        return value.toString();
    }
    public String convert3(Object value) {
        return value.toString();
    }
}
