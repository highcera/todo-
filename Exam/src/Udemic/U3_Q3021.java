package Udemic;

class U3_Q3021 { // MySearch
    public static void main(String[] args) {
        String url = "http://www.domain.com/index.html";
        System.out.println(url.indexOf("com"));  // 18
        if (url.indexOf("com") != -1) {
            System.out.println("Found");         // Found
        }
    }
}