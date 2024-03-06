package Udemic;

public class U1_025 {
   
    public static void main(String[] args) {
    
        // float myarray[] = {10.20f, 20.30f, 30.40f, 50.60f};
        float[] myarray = {10.20f, 20.30f, 30.40f, 50.60f};
        int index = 0;
        boolean isFound = false;
        float key = 30.40f;
        // Right answer:
        while (index < myarray.length){
            if (key == myarray[index]) {
                isFound = true;
            }
            index++;
        }
        System.out.println(isFound);  // true
    
        // false
        index = 0;
        isFound = false;
        while (key == myarray[index++]) {
            isFound = true;
        }
        System.out.println(isFound);  // false
    
        // ArrayIndexOutOfBoundsException:
//        index = 0;
//        isFound = false;
//        while (index++ < 5) {
//            if(key == myarray[index]){
//            // ArrayIndexOutOfBoundsException
//                isFound = true;
//            }
//        }
//        System.out.println(isFound);
        
        // Infinite loop:
//        index = 0;
//        isFound = false;
//        while (index <= 4) {
//            if(key == myarray[index]){
//                index++;
//                isFound = true;
//                break;
//            }
//        }
//        System.out.println(isFound);
        
        // Infinite loop:
//        index = 0;
//        isFound = false;
//        while (index < 5) {
//            if(key == myarray[index]){
//                isFound = true;
//                break;
//            }
//        }
//        System.out.println(isFound);
    }
}
