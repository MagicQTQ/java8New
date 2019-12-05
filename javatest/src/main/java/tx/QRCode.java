package tx;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.apache.xmlbeans.impl.util.Base64;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Map;

/**
 * @Author qtq
 * @Created on 2019-12-01 23:47.
 */
public class QRCode {

    @Test
    public void genQRCode() throws WriterException, IOException {

        JSONObject json = new JSONObject();

        json.put("cpmpany", "http://www.baidu.com");
        json.put("username", "karato");
        json.put("address", "广东省广州市天河区");
        json.put("author", "ChurThor");

        System.out.println(json.toJSONString());
        String content = json.toJSONString();

        int width = 300;
        int height = 300;

        Map<EncodeHintType, Object> hints = Maps.newHashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);

        String filePath = "d://";
        String fileName = "QR_code.jpg";

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        MatrixToImageWriter.writeToStream(bitMatrix, "jpeg", bos);

        bos.toByteArray();
        // 第一种，返回字节流
        String base64 = Base64.encode(bos.toByteArray()).toString().trim();
        System.out.println("二维码的字节流已生成：>>>" + "data:image/jpeg;base64," + new String(base64));

        // 第二种，生成在本地
        Path path = FileSystems.getDefault().getPath(filePath, fileName);
        MatrixToImageWriter.writeToPath(bitMatrix, "jpeg", path);


    }
}
