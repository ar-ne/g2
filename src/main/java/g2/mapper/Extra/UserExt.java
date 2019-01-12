package g2.mapper.Extra;

import g2.model.Extra.UserKey;
import g2.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface UserExt {
    @Select({
            "select",
            "*",
            "from Users",
            "where name = #{name,jdbcType=VARCHAR}",
            "and password = #{password,jdbcType=VARCHAR}",
            "and type = #{type,jdbcType=INTEGER}"
    })
    @ResultMap("g2.mapper.UserMapper.BaseResultMap")
    User selectByUserKey(UserKey key);

    @Delete({"delete from",
            "Users",
            "where",
            "Car_id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByCardId(Long id);

    @Select({"select name",
            "from Users",
            "where",
            "Car_id = #{id,jdbcType=VARCHAR}"
    })
    String selectNameByCardId(Long id);

    @Select({"select name from Users where Car_id=#{id,jdbcType=NUMERIC}"})
    String selectNameByCardID(Long id);
}
