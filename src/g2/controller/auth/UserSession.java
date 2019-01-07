package g2.controller.auth;

import g2.model.UserKey;
import g2.util.Parse;
import g2.util.properties.SessionProperties;
import g2.util.properties.UserProperties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户Session，包含用户类型，登陆状态和用户登录名
 */
public class UserSession {
    private int type;
    private boolean state;
    private String name;

    /**
     * 从参数构造
     *
     * @param type  用户类型
     * @param state 登陆状态
     * @param name  用户登录名
     */
    public UserSession(int type, boolean state, String name) {
        this.type = type;
        this.state = state;
        this.name = name;
    }

    /**
     * '
     * 从request生成一个UserSession
     *
     * @param request
     */
    UserSession(HttpServletRequest request) {
        try {
            this.type = (int) request.getSession(false).getAttribute(SessionProperties.type);
            this.name = (String) request.getSession(false).getAttribute(SessionProperties.name);
            this.state = (boolean) request.getSession(false).getAttribute(SessionProperties.state);
            if (name.isEmpty())
                throw new Exception("反正就是出了点问题，我代码大概没写错");
        } catch (Exception e) {
            this.state = false;
            this.type = UserProperties.unAuth;
        }
    }

    /**
     * 用userKey初始化一个登录状态为true的UserSession
     *
     * @param userKey userKey
     */
    public UserSession(UserKey userKey) {
        this.name = userKey.getName();
        this.type = Parse.userType(userKey.getType());
        this.state = true;
    }

    public void setSession(HttpServletRequest request) {
        request.getSession().setAttribute(SessionProperties.state, state);
        request.getSession().setAttribute(SessionProperties.type, type);
        request.getSession().setAttribute(SessionProperties.name, name);
    }

    public int getType() {
        return type;
    }

    public boolean getState() {
        return state;
    }

    public String getName() {
        return name;
    }
}
