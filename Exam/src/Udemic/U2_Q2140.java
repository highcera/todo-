package Udemic;

interface Money {
    int cash = 0;
    abstract void earn(int amount);
    public void spend(int amount);
}

class LocalCurrency implements Money {
  int cash = 100;
  public void earn(int amount) {
    cash = cash + amount;
    System.out.println(cash);
  }
  public void spend(int amount) {
    cash = cash - amount;
    System.out.println(cash);
  }
}

class U2_Q2140 {  // UnderpaidJavaCoder 
  public static void main(String[] args) {
    Money m = new LocalCurrency();
    m.earn(5000);
    m.spend(200);
    System.out.println("What’s left in his pocket: " + m.cash);
  }
}