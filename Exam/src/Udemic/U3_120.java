package Udemic;

class Phone {
    void call() {
        System.out.println("Call-Phone");
    }
}
class SmartPhone extends Phone{
    void call() {
        System.out.println("Call-SmartPhone");
    }
}

class U3_120 { // TestPhones
    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone smartPhone = new SmartPhone();
        phone.call();       // Call-Phone
        smartPhone.call();  // Call-SmartPhone
    }
}