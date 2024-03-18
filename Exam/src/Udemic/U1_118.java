package Udemic;

class Twin {
    int age;
    String gender;
    Twin(int age, String gender) {
        this.age = age;
        this.gender = gender;
    }
    // @Override // (not working)
    public boolean equals(){
        return this.age == age & this.gender == gender;
    }
}

// public boolean equals(Twins t){
//     return this.age == t.age & this.gender == t.gender;
// }

class U1_118 {
    public static void main (String[] args) {
        Twin t1 = new Twin(13, "Male");
        Twin t2 = new Twin(13, "Male");
        if (t1 == t2) {
          System.out.println("Identical");
        } else {
          System.out.println("Dissimilar");
        }
        if (t1.equals(t2)) {
          System.out.println("Identical");
        } else {
          System.out.println("Dissimilar");
        }
    }
}
