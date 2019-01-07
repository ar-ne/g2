package g2.util.properties;

/**
 * 用户状态的定义
 */
public final class UserProperties {
    public static final int user = 0;
    public static final int admin = 1;
    public static final int admin2 = 2;
    public static final int unAuth = -1;
    public static final int[] types = {user, admin, admin2, unAuth};
    public static final String[] typeString = {"0", "1", "2", "-1"};
}
