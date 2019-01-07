package g2.mapper.Extra;

import g2.model.User;
import g2.model.UserKey;
import org.apache.ibatis.annotations.Select;

public interface UserExt {
    @Select({
            "select",
            "id, Car_id, name, password, usertype, type",
            "from Users",
            "where name = #{name,jdbcType=VARCHAR} and type = #{type,jdbcType=INTEGER} and password = #{password,jdbcType=VARCHAR}"
    })
    User selectByUserKey(UserKey userKey);
}
