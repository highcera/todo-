package Udemic;

public class U2_061 {
    public static void main(String[] args) {
 
        String name = "Spot";
        int age = 4;
        String str = "My dog " + name + " is " + age;  // My dog Spot is 4
        System.out.println(str);
 
        StringBuilder sb = new StringBuilder();
 
        sb.append("My dog " + name + " is " + age);
        System.out.println(sb);  // My dog Spot is 4
 
        sb.setLength(0); // StringBuilder 초기화, sb.delete()
        
        sb.append("My dog ").append(name).append(" is ").append(age);
        System.out.println(sb);  // My dog Spot is 4
 
        // sb.insert("My dog ").append( name + " is " + age);
        // no suitable method found for insert(java.lang.String)
 
        // sb.insert("My dog ").insert( name ).insert(" is ").insert(age);
        // no suitable method found for insert(java.lang.String)
    }
}
