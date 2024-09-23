package Udemic;

public class U2_Q2115 {
     public void testRefs(String str, StringBuilder sb){
        str = str + sb.toString();
        sb.append(str);
        str = null;
        sb = null;
    }
    public static void main(String[] args){
        String str = "aaa";
        StringBuilder sb = new StringBuilder("bbb");
        new U2_Q2115().testRefs(str, sb);
        System.out.println("str=" + str + " sb=" + sb);
        // str=aaa sb=bbbaaabbb
    }
}
