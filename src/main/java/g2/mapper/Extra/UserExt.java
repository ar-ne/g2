package g2.mapper.Extra;

import g2.model.Extra.UserKey;
import g2.model.User;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface UserExt {
    @Select({
            "select",
            "name, password, type, id, Car_id, usertype",
            "from Users",
            "where name = #{name,jdbcType=VARCHAR}",
            "and password = #{password,jdbcType=VARCHAR}",
            "and type = #{type,jdbcType=INTEGER}"
    })
    @ResultMap("g2.mapper.UserMapper.BaseResultMap")
    User selectByUserKey(UserKey key);
}
