import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Displays the current date (and time for the 4th line/date of output) to the user.
 *
 * @author Ravi Spigner
 */
public class FormatDates {

    public static void main(String[] args) {
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        DateTimeFormatter format4 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm")
                .withZone(ZoneId.of("GMT"));
        System.out.println(LocalDateTime.now().format(format1));
        System.out.println(LocalDateTime.now().format(format2));
        System.out.println(LocalDateTime.now().format(format3));
        System.out.println(LocalDateTime.now().format(format4));
    }
}
