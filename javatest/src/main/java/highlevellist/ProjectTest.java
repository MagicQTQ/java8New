package highlevellist;

import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

/**
 * @Author qtq
 * @Created on 2019-10-09 14:58.
 */
public class ProjectTest {
    public static void main(String[] args) {

        Instant time = Instant.now();

        int year = time.atZone(ZoneId.of("+8")).toLocalDate().getYear();
        int yearOne = time.atZone(ZoneId.of("+8")).minus(1, ChronoUnit.MONTHS).toLocalDate().getYear();
        int month = time.atZone(ZoneId.of("+8")).toLocalDate().getMonthValue();
        int monthOne = time.atZone(ZoneId.of("+8")).minus(1, ChronoUnit.MONTHS).toLocalDate().getMonthValue();
        String monthNow = "";
        String monthAddOne = "";
        String loggerTime = "";
        if (month < 10 && monthOne < 10) {
            monthNow = "0" + String.valueOf(month);
            monthAddOne = "0" + String.valueOf(monthOne);
            loggerTime = "qly-v2-" + year + "-" + monthNow + "-" + "*" + ","
                    + "qly-v2-" + yearOne + "-" + monthAddOne + "-" + "*";
        } else if (month < 10) {
            monthNow = "0" + String.valueOf(month);
            loggerTime = "qly-v2-" + year + "-" + monthNow + "-" + "*" + ","
                    + "qly-v2-" + yearOne + "-" + monthOne + "-" + "*";
        } else if (monthOne < 10) {
            monthAddOne = "0" + String.valueOf(monthOne);
            loggerTime = "qly-v2-" + year + "-" + month + "-" + "*" + ","
                    + "qly-v2-" + yearOne + "-" + monthAddOne + "-" + "*";
        } else {
            loggerTime = "qly-v2-" + year + "-" + month + "-" + "*" + ","
                    + "qly-v2-" + yearOne + "-" + monthOne + "-" + "*";
        }

        System.out.println(loggerTime);
    }
}
