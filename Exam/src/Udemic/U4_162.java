package Udemic;

class JavaCourse {
    String courseName = "Java";
}
class U4_162 {  // University
    public static void main(String[] args) {
        JavaCourse[] courses = { new JavaCourse(), new JavaCourse() };
        courses[0].courseName = "OCA";
        for (JavaCourse c : courses)
            c = new JavaCourse();
        for (JavaCourse c : courses)
            System.out.println(c.courseName);
        // OCA
        // Java
    }
}

// In the enhanced for loop the element is not writeable.
