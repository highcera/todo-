package MP_Java_Ess;

import java.util.Vector;

public class MP_7_1 {  // VectorEx
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<Integer>();
        v.add(5);
        v.add(4);
        v.add(-1);

        // 벡터 중간에 삽입하기
        v.add(2, 100);

        System.out.println("벡터 내의 요소의 개수 : " + v.size());
        System.out.println("벡터의 현재 용량 : " + v.capacity());

        // 모든 요소 정수 출력하기
        for (int i = 0; i < v.size(); i++) {
            int n = v.get(i);
            System.out.println(n);
        }

        // 벡터 속에 모든 정수 더하기
        int sum = 0;
        for (int i = 0; i < v.size(); i++) {
            int n = v.elementAt(i);
            sum += n;
        }
        System.out.println("벡터에 있는 정수 합 : " + sum);
    }
}
