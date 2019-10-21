package file;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @Author qtq
 * @Created on 2019-09-09 16:49.
 */
public class InstantTest {

    public static void main(String[] args) {

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.systemDefault());
        String date = dateFormat.format(Instant.now());
        System.out.println(date + "=====================" + Instant.now());

        // 格式化的LocalDate 转换 Instant
        Instant begin = LocalDate.parse("2018-12-12", DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay()
                .toInstant(ZoneOffset.of("+8"));

        Instant end = LocalDate.parse("2018-12-12", DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay().atZone(ZoneId.of("+8"))
                .toInstant().plus(1, ChronoUnit.DAYS);

        System.out.println(begin + "======================" + end);

        // LocalDate 转换 Instant
        LocalDate date2Instant = LocalDate.now();
        Instant timeInstant = date2Instant.atStartOfDay(ZoneId.of("+8")).toInstant();
        System.out.println(date2Instant + "=======date2Instant==============" + timeInstant);

        LocalDateTime dateTime = LocalDateTime.now();
        Instant dateTime2Instant = dateTime.atOffset(ZoneOffset.of("+8")).toInstant();
        System.out.println(dateTime + "=======dateTime2Instant==============" + dateTime2Instant);


        // ZonedDateTime 转换 Instant和LocalDateTime
        ZonedDateTime ztime1 = ZonedDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        System.out.println(ztime1);
        System.out.println(ztime1.toInstant()); //1
        System.out.println(ztime1.toLocalDateTime()); //3
        ZonedDateTime ztime2 = ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Australia/Darwin"));
        System.out.println(ztime2);
        System.out.println(ztime2.toInstant()); //2
        System.out.println(ztime2.toLocalDateTime()); //4

        //Instant 转换输出格式
        //e.getModified().atZone(ZoneId.of("+8")).format(READABLE_DATETIME);
        System.out.println(Instant.now().atZone(ZoneId.of("+8")).toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
        System.out.println(Instant.now().atZone(ZoneId.of("+8")).format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss:SSS")));


    }

}
