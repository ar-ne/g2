package g2.util;

import static g2.util.properties.UserProperties.*;

public final class Parse {

    public static int userType(String str) {
        if (str == null || str.isEmpty()) return unAuth;
        for (int i = 0; i < typeString.length; i++) {
            if (typeString[i].equals(str)) return types[i];
        }
        return unAuth;
    }
}
