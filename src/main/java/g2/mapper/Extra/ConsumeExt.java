package g2.mapper.Extra;

import g2.model.Consume;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ConsumeExt {
    @Select({
            "select",
            "id, Car_id, name, Mac_id,amount, time, result, reason",
            "from consumelog",
    })
    List<Consume> getAll();//查询所有消费记录

    @Delete({
            "delete from consumelog",
            "where Mac_id = #{id,jdbcType=NUMERIC}"
    })
    int DeleteByMacId(Long id);

    @Delete({
            "delete from consumelog",
            "where Car_id = #{id,jdbcType=NUMERIC}"
    })
    int DeleteByCardId(Long id);
    /*@Delete({
            "delete from consumelog",
            "where name = #{name,jdbcType=VARCHAR}"
    })
    int DeleteByName(String name);*/
}
