package g2.service;

import g2.mapper.java.UserMapper;
import g2.model.User;
import g2.model.UserKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UserMapper userMapper;

    public boolean chkLogin(UserKey userKey) {
        User chkUser = userMapper.selectByPrimaryKey(userKey);
        return chkUser.getType().equals(userKey.getType()) &&
                chkUser.getName().equals(userKey.getName()) &&
                chkUser.getPassword().equals(userKey.getPassword());
    }
}
