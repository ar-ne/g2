package g2.mapper.Extra;

import g2.model.Charge;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
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

    @Select({
            "<script>",
            "select",
            "id, Car_id, Mac_id,name,amount, time, result, reason",
            "from chargelog",
            "where 1=1",
            "<when test=\"Mac_id!=null and Mac_id!=''\">",
            "AND Mac_id= #{Mac_id,jdbcType=NUMERIC}",
            "</when>",
            "</script>"
    })
    List<Charge> selectByMacId(@Param("Mac_id") Long Mac_id);
}
