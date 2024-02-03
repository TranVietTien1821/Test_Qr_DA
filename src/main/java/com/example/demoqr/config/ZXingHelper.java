package com.example.demoqr.config;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.EnumMap;
import java.util.Hashtable;
import java.util.Map;

public class ZXingHelper {
    public static  byte[] getBarCodeImage(String text, int width, int height){
        try {
//            String id = "443E39A0-52B8-4A0B-B028-06F57B3B21FB";
            String qrCodePath = "C:\\Users\\VietTien\\Downloads\\Assiment_2 Xây dựng trang wed\\img\\";
            String qrCodeName = qrCodePath + "anhgiay2" +  ".png";
            Map<EncodeHintType, Object> hints = new EnumMap<>(EncodeHintType.class);
            hints.put(EncodeHintType.CHARACTER_SET, StandardCharsets.UTF_8.name());

            QRCodeWriter qrCodeWriter = new QRCodeWriter();

            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hints);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "png", byteArrayOutputStream);

            // Lưu ảnh vào đường dẫn qrCodeName
            File file = new File(qrCodeName);
            ImageIO.write(MatrixToImageWriter.toBufferedImage(bitMatrix), "png", file);
            return byteArrayOutputStream.toByteArray();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
