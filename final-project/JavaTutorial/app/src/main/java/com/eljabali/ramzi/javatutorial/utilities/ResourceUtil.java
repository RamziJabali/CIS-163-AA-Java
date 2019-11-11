package com.eljabali.ramzi.javatutorial.utilities;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.RawRes;

import java.io.InputStream;

public class ResourceUtil {

    public static String getRawString(Context context, @RawRes int fileId) {
        String text;
        try {
            Resources res = context.getResources();
            InputStream in_s = res.openRawResource(fileId);

            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            text = new String(b);
        } catch (Exception e) {
            text = "";
        }
        return text;
    }
}
