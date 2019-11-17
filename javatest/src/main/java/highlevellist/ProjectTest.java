package highlevellist;

import org.apache.commons.codec.Charsets;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

/**
 * @Author qtq
 * @Created on 2019-10-09 14:58.
 */
public class ProjectTest {
    public static void main(String[] args) throws UnsupportedEncodingException {

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

        //    System.out.println(loggerTime);
        //==========================================================================
        String callback = "https://ws.uatm2.dwfei.com/ws-gateway/api/auth/wxopen/wxeafde6d8bc451bad/code" + "?action=auth&storeId";
        //System.out.println(URLEncoder.encode(callback, Charsets.UTF_8.toString()));

        System.out.println(RandomStringUtils.randomAlphabetic(16)); //生成随机[a-z]字符串，包含大小写
        System.out.println(RandomStringUtils.randomAlphabetic(2, 4)); //2-19位的

        System.out.println(RandomStringUtils.randomAlphanumeric(3, 12)); //生成指定长度的字母和数字的随机组合字符串

        //使用指定的字符生成5位长度的随机字符串
        String rand = RandomStringUtils.random(5, new char[]{'a', 'b', 'c', 'd', 'e', 'f', '1', '2', '3'});
        System.out.println(rand);
    }
}
