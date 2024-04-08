package Udemic;

class U3_104 { // MySearch
    public static void main(String[] args) {
        String url = "http://www.domain.com/index.html";
        System.out.println(url.indexOf("com"));  // 18
        if (url.indexOf("com") != -1) {
            System.out.println("Found");         // Found
        }
    }
}