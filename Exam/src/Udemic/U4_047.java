package Udemic;

public class U4_047 {
    public static void main(String[] args) {
        String[] nycTourLoops =
            new String[] {"Downtown", "Uptown", "Brooklyn"};
        String[] times = new String[] {"Day", "Night"};
        // for (int i = 0, j = 0;
        //      i < nycTourLoops.length && j < times.length; i++; j++) {
        // for (int i = 0, j = 0;
        //      i < nycTourLoops.length && j < times.length; i++, j++) {
        //     System.out.print(nycTourLoops[i] + " " + times[j] + "-");
        // }

        for (int i = 0; i < nycTourLoops.length; i++)   
            for (int j = 0; j < times.length; j++) 
                System.out.println(nycTourLoops[i] + " " + times[j]);
    }
}
