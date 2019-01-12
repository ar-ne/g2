package g2.mapper.Extra;

import g2.model.Charge;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ChargeExt {
    @Delete({
            "delete from chargelog",
            "where Mac_id = #{id,jdbcType=NUMERIC}"
    })
    int DeleteByMacId(Long id);

    @Delete({
            "delete from chargelog",
            "where Car_id = #{id,jdbcType=NUMERIC}"
    })
    int DeleteByCardId(Long id);

    @Select({
            "select",
            "id, Car_id, name, Mac_id,amount, time, result, reason",
            "from chargelog",
    })
    List<Charge> getAll();//查询所有消费记录
    /*@Delete({
            "delete from chargelog",
            "where name = #{name,jdbcType=VARCHAR}"
    })
    int DeleteByName(String name);*/
}
