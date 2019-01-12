package g2.util;

public final class Properites {
    public static final int[] loginType = {Login.user, Login.admin, Login.admin2, Login.unAuth};
    public static final String[] loginTypeString = {"user", "admin", "admin2", "unAuth"};
    public static final String[] loginUrlString = {"/user", "/admin", "/admin2", "/unAuth"};

    public final class CardStatus {
        public final static String frozen = "冻结";
    }

    public final class ErrorMessages {
        public final static String Exceed_Limit = "超出消费限制";
        public final static String Insufficient_Balance = "余额不足";
        public final static String Report_Loss = "挂失卡";
        public final static String DBERROR = "DBERROR";
    }

    public final class Session {
        public static final String state = "login_state";
        public static final String name = "login_id";
        public static final String type = "login_type";
        public static final String cardID = "card_id";
    }

    public final class Login {
        public static final int user = 0;
        public static final int admin = 1;
        public static final int admin2 = 2;
        public static final int unAuth = -1;
    }

    public final class Result {
        public static final int success = 1;
        public static final int failed = 0;
    }
}
