package g2.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.binary.Base64;

import java.text.SimpleDateFormat;

import static g2.util.Properites.*;
import static g2.util.Properites.Login.unAuth;


public final class Parse {

    public final static SimpleDateFormat simpleDateFormatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");

    public static int userType(String str) {
        if (str == null || str.isEmpty()) return unAuth;
        for (int i = 0; i < loginTypeString.length; i++) {
            if (loginTypeString[i].equals(str)) return loginType[i];
        }
        return unAuth;
    }

    public static String encodeBase64JSON(Object o) {
        return Base64.encodeBase64URLSafeString(JSON.toJSONString(o).getBytes(encodeing));
    }

    public static String decodeBase64JSON(String s) {
        return new String(Base64.decodeBase64(s), encodeing);
    }
}
