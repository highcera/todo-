package Udemic;

public class U5_135 {
    // int a, b;
    int a, b;
    final int c = 0;
    void switchMe() {
        switch ( a = 0 ) {}         // Line 1
        // switch ( int d = 0 ) {}  // Line 2
        switch ( 1 ) {}             // Line 3
        switch ( a++ ) {            // Line 4
            // case a:              // Line 5
            case c:                 // Line 6
        }
    }
}
