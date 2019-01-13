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

//    @Select({
//            "select",
//            "Mac_id",
//            "from consumelog",
//            "where Car_id=#{carID,jdbcType=NUMERIC}"
//    })
//    List<Long> getMacID(Long carID);//查询用户消费卡机ID


    @Select({
            "select",
            "*",
            "from consumelog",
            "where Car_id=#{carID,jdbcType=NUMERIC}"
    })
    List<Consume> getCosumeList(Long carID);//查询用户的消费记录

    @Select({"<script>",
            "select",
            "id, Car_id, name, Mac_id,amount, time, result, reason",
            "from consumelog",
            "where 1=1",
            "<when test=\"carID!=null and carID!=''\">",
            "AND Car_id= #{carId,jdbcType=NUMERIC}",
            "</when>",
            "<when test=\"money!=null and money!=''\">",
            "AND amount= #{money,jdbcType=DOUBLE}",
            "</when>",
            "</script>"

    })
    List<Consume> selectByCdAmount(Long carID, Double money);//通过消费金额查询用户的消费记录

    @Delete({
            "delete from consumelog",
            "where Mac_id = #{id,jdbcType=NUMERIC}"
    })
    int DeleteByMacId(Long id);
}
