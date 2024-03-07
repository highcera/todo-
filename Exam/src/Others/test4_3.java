package Others;
// How many instances are ready for garbage collection in the following code after line 14

public class test4_3 {

    String name;
    int phone_num;
    int age;

    public static void main(String[] args) {
        test4_3 student = new test4_3();
        test4_3 student_2 = new test4_3();
        test4_3 student_3 = new test4_3();

        student_2 = student;
        student_3 = student;
    }
}
