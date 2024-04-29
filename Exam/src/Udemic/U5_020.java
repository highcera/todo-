package Udemic;

class U5_020 {  // TestArrayForNPE
    static int spoil() throws Exception {
        throw new Exception();
    }
    public static void main(String[] args) {
        int[] a = null;
        try {
            a[spoil()]++;
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("Caught AIOOBE");
        } catch (NullPointerException npe) {
            System.out.println("Caught NPE");
        } catch (Exception e) {
            System.out.println("Caught E");  // Caught E
            System.out.println(e);  // java.lang.Exception
        }
    }
}