package Udemic;

public class U2_110 {
    public static void main(String[] args) {
        char[] arr = {
          'A', 'e', 'I', 'O', 'u'
        };
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
                switch (arr[i]) {
                case 'A':
                    continue;
                case 'a':
                    count++;
                    break;
                case 'E':
                    count++;
                    break;
                case 'I':
                    count++;
                    continue;
                case 'O':
                    count++;
                    break;
                case 'U':
                    count++;
            }
    }
    System.out.print("Total match found: " + count);
    }
}
