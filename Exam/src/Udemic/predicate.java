package Udemic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class predicate {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Predicate를 이용한 짝수 필터링
        Predicate<Integer> evenPredicate = number -> number % 2 == 0;
        List<Integer> evenNumbers = filterNumbers(numbers, evenPredicate);
        System.out.println("Even numbers: " + evenNumbers);

        // Predicate를 이용한 홀수 필터링
        Predicate<Integer> oddPredicate = number -> number % 2 != 0;
        List<Integer> oddNumbers = filterNumbers(numbers, oddPredicate);
        System.out.println("Odd numbers: " + oddNumbers);
    }

    // Predicate를 이용한 필터링 메서드
    public static List<Integer> filterNumbers(List<Integer> numbers, Predicate<Integer> predicate) {
        List<Integer> filteredNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (predicate.test(number)) {
                filteredNumbers.add(number);
            }
        }
        return filteredNumbers;
    }
}
