package g2.service;

import g2.mapper.UserMapper;
import g2.model.Extra.UserKey;
import g2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final UserMapper userMapper;

    @Autowired
    public LoginService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public boolean chkLogin(UserKey userKey) {
        User chkUser = userMapper.selectByUserKey(userKey);
        if (chkUser == null) return false;
        return chkUser.getType().equals(userKey.getType()) &&
                chkUser.getName().equals(userKey.getName()) &&
                chkUser.getPassword().equals(userKey.getPassword());
    }
}
