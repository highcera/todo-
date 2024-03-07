package Others;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class test3 {
    public static void main(String[] args) {
        LocalDate Id = LocalDate.of(2015, 12, 12);
        Id = Id.with(ChronoField.DAY_OF_YEAR,30);
        System.out.println(Id);
    }
}