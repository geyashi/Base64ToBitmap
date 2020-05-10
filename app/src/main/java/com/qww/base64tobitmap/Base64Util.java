package com.qww.base64tobitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import Decoder.BASE64Decoder;

public class Base64Util {
    /**
     * 通过Base32将Bitmap转换成Base64字符串
     * @param bit
     * @return
     */
    public static String Bitmap2StrByBase64(Bitmap bit){
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        bit.compress(Bitmap.CompressFormat.JPEG, 40, bos);//参数100表示不压缩
        byte[] bytes=bos.toByteArray();
        String content = "data:image/jpg;base64," + Base64.encodeToString(bytes, Base64.NO_WRAP);
        Log.d("Base64Util", "content:" + content);
        return content;
    }


    /**
     * 将Base64字符串转成Bitmap
     * @param content
     * @return bitmap
     */
    public static Bitmap Base64ToBitMap(String content) {
        String base64 = content.substring(content.indexOf(",") + 1);
        Log.d("Base64Util", "base64:" + base64);
        byte[] decode = Base64.decode(base64, Base64.NO_WRAP);
        Bitmap bitmap = BitmapFactory.decodeByteArray(decode, 0, decode.length);
        return bitmap;
    }
}
