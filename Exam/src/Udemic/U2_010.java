package Udemic;

class Sport {
    int num_players;
    String name, ground_condition;
    Sport(int np, String sname, String sground) {
        num_players = np;
        name = sname;
        ground_condition = sground;
    }
}

class Cricket extends Sport {
    int num_umpires;
    int num_substitues;
    Cricket() {
        super(11, "Cricket", "Condition OK");
        num_umpires = 3;
        num_substitues = 2;
    }
}

class U2_010 {
    public static void main(String[] args) {
        Cricket crckt = new Cricket();
        System.out.printf("%s, %d, %s", crckt.name, crckt.num_players, crckt.ground_condition);
        System.out.printf("\n %d, %d", crckt.num_umpires, crckt.num_substitues);
    }
}