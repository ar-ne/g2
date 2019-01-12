package g2.util;

import java.text.SimpleDateFormat;

import static g2.util.Properites.Login.unAuth;
import static g2.util.Properites.loginType;
import static g2.util.Properites.loginTypeString;


public final class Parse {

    public final static SimpleDateFormat simpleDateFormatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");

    public static int userType(String str) {
        if (str == null || str.isEmpty()) return unAuth;
        for (int i = 0; i < loginTypeString.length; i++) {
            if (loginTypeString[i].equals(str)) return loginType[i];
        }
        return unAuth;
    }
}
