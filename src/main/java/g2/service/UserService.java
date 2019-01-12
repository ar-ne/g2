package g2.service;

import g2.mapper.UserMapper;
import g2.model.Extra.UserKey;
import g2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 验证成功则返回用户（实体类）
     * 否则返回null
     *
     * @param userKey 包含用户名、密码、登陆类型
     * @return 用户（实体类）
     */
    @Nullable
    public User login(UserKey userKey) {
        User chkUser = userMapper.selectByUserKey(userKey);
        if (chkUser == null) return null;
        if (chkUser.getType().equals(userKey.getType()) &&
                chkUser.getName().equals(userKey.getName()) &&
                chkUser.getPassword().equals(userKey.getPassword())) return chkUser;
        else return null;
    }

    public User getUser(String name) {
        return userMapper.selectByPrimaryKey(name);
    }

    public String getNameByCardID(Long cardID) {
        return userMapper.selectNameByCardID(cardID);
    }
}
