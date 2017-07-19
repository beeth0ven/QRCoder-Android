package beeth0ven.tk.qrcoder.exframeworks.zxing;


import android.graphics.Bitmap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.util.HashMap;
import java.util.Map;

public class ExImage {

    public static Bitmap qrcode(String text) {

        int width = 400, height = 400;
        Map<EncodeHintType, Object> params = new HashMap<>();
        params.put(EncodeHintType.CHARACTER_SET, "utf-8");
        params.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        params.put(EncodeHintType.MARGIN, 0);

        try {
            BitMatrix bitMatrix = new QRCodeWriter().encode(text, BarcodeFormat.QR_CODE, 400, 400, params);
            int[] pixels = new int[width * height];
            for (int i=0; i<height; i++) {
                for (int j=0; j<height; j++) {
                    pixels[i * width + j] = bitMatrix.get(j, i) ? 0x00000000 : 0xffffffff;
                }
            }
            return Bitmap.createBitmap(pixels, 0, width, width, height, Bitmap.Config.RGB_565);
        } catch (WriterException error) {
            error.printStackTrace();
        }
        return null;

    }
}
