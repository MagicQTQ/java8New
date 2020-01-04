package tx;


import org.apache.commons.collections4.CollectionUtils;

import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author qtq
 * @Created on 2019-11-17 22:25.
 */
public class DailyTest {

    public static void main(String[] args) {

        List<String> listsNull = null;
        List<String> listsEmpty = new ArrayList<>();
        System.out.println(CollectionUtils.isEmpty(listsNull) + "--" + CollectionUtils.isEmpty(listsEmpty));

        // String toAmount = String.valueOf(new BigDecimal(Double.parseDouble("1") / 100).setScale(2, BigDecimal.ROUND_HALF_UP));
        String host = "http://s93.sws.ecyao.com/ws-gateway/t/live/114052065f424a9994fc68c675b9775f/raw";
        String str = "https://sws.ecyao.com/ws-gateway/t/live/114052065f424a9994fc68c675b9775f/raw";
        String ss = host + str.substring(str.indexOf("ws-gateway"));
        System.out.println(ss);

        String qrUrlSub = "";
        for (int i = 1; i <= 5; i++) {
            String aa = "good";
            qrUrlSub = qrUrlSub + aa + ",";
        }
        String bb = qrUrlSub.substring(0, qrUrlSub.length() - 1);
        System.out.println(bb);

        System.out.println(Instant.now().atZone(ZoneId.of("+8")).getMonth());
    }
}
