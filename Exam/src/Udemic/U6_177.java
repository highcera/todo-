package Udemic;

import java.util.Arrays;
import java.util.List;

public class U6_177 {
    public static void main(String[] args) {
        List<String> drinks = Arrays.asList("can", "cup");
        for (int container = drinks.size() - 1;
                 container >= 0; container--)
            System.out.print(drinks.get(container) + ",");  // cup,can,
    }
}
