package g2.mapper.Extra;

import g2.model.Extra.UserKey;
import g2.model.User;
import org.apache.ibatis.annotations.*;

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

    @Select({"select password from Users where Car_id=#{id,jdbcType=NUMERIC}"})
    String getPasswordByCardID(Long cardID);

    @Update({
            "update Users",
            "set",
            "password=#{password,jdbcType=VARCHAR}",
            "where ",
            "Car_id = #{carID,jdbcType=NUMERIC}"
    })
    int editPassword(@Param("carID") Long id, @Param("password") String password);
}
