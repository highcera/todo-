package Udemic;

public class U4_126 {
    public static void main(String[] args)  {
        float fVar = 123.123f;
        double dVar  = 123;
        short sVar = 123;
        int iVar = 123;
        long lVar = 123;
        // iVar = fVar;
        fVar = iVar;
        dVar = fVar;
        lVar = sVar;
        // fVar = dVar;
        dVar = iVar;
        // iVar = dVar;
    }
}
