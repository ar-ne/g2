package g2.mapper.Extra;

import g2.model.UserKey;
import org.apache.ibatis.annotations.Select;

public interface UserExt {
    @Select({
            "select * from Users where "+
            "name = #{name,jdbcType=VARCHAR} and password = #{password,jdbcType=VARCHAR}"+
                    "and type = #{type,jdbcType=INTEGER}"
    })
    g2.model.User selectByUserKey(UserKey userKey);
}
