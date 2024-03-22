package Udemic;


class OS {
    String name;
    OS(String name) {
        this.name = name;
    }
}
class Linux extends OS {
    int ver;
    Linux(String name, int ver) {
        // super.name = name;
        super(name);
        // this(ver);
        this.ver = ver;
    }
}
public class U3_008 {
    public static void main(String[] args) {
        Linux os = new Linux("Ubuntu",16);
    }
}

