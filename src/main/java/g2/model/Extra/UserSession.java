package g2.model.Extra;

import g2.model.Extra.UserKey;
import g2.model.User;
import g2.util.Properites;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户Session，包含用户类型，登陆状态和用户登录名
 */
public class UserSession {
    private int type;
    private boolean state;
    private String name;
    private Long cardID;

    /**
     * '
     * 从request生成一个UserSession
     *
     * @param request
     */
    public UserSession(HttpServletRequest request) {
        try {
            this.type = (int) request.getSession(false).getAttribute(Properites.Session.type);
            this.name = (String) request.getSession(false).getAttribute(Properites.Session.name);
            this.state = (boolean) request.getSession(false).getAttribute(Properites.Session.state);
            this.cardID = (Long) request.getSession(false).getAttribute(Properites.Session.cardID);
            if (name.isEmpty() || !state)
                throw new Exception("登录状态肯定有问题");
        } catch (Exception e) {
            this.state = false;
            this.type = Properites.Login.unAuth;
        }
    }

    /**
     * 用user初始化一个登录状态为true的UserSession
     *
     * @param user user
     */
    public UserSession(User user) {
        this.name = user.getName();
        this.type = user.getType();
        this.cardID = user.getCar_id();
        this.state = true;
    }

    public void setSession(HttpServletRequest request) {
        request.getSession().setAttribute(Properites.Session.state, state);
        request.getSession().setAttribute(Properites.Session.type, type);
        request.getSession().setAttribute(Properites.Session.name, name);
        request.getSession().setAttribute(Properites.Session.cardID, cardID);
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

    public Long getCardID() {
        return cardID;
    }
}
