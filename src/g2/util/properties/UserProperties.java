package g2.util.properties;

/**
 * 类型的定义和映射
 */
public final class UserProperties {
    public static final int user = 0;
    public static final int admin = 1;
    public static final int admin2 = 2;
    public static final int unAuth = -1;
    public static final int[] types = {user, admin, admin2, unAuth};
    public static final String[] typeString = {"user", "admin", "admin2","unAuth"};
    public static final String[] urlString = {"/user", "/admin", "/admin2","/unAuth"};
}
