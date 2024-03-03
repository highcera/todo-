import java.time.LocalDate;

public class test3_2 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2018,02,02);
        System.out.println(date.getMonthValue());
        // year - 2018, month - 2, date - 2
    }
}
