package g2.mapper.Extra;

import g2.model.Consume;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ConsumeExt {
    @Select({
            "select",
            "id, Car_id, name, Mac_id,amount, time, result, reason",
            "from consumelog",
    })
    List<Consume> getAll();//查询所有消费记录

    @Select({
            "<script>",
            "select",
            "*",
            "from consumelog",
            "where 1=1",
            "<when test=\"carId!=null and carId!=''\">",
            "AND Car_id= #{carId,jdbcType=NUMERIC}",
            "</when>",
            "<when test=\"MacId!=null and MacId!=''\">",
            "AND Mac_id= #{MacId,jdbcType=NUMERIC}",
            "</when>",
            "</script>"
    })
    List<Consume> getConsumeListByMacID(@Param("carID") Long carID, @Param("MacId") Long MacId);//通过卡号，卡机编号查询用户消费记录


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
            "<when test=\"carId!=null and carId!=''\">",
            "AND Car_id= #{carId,jdbcType=NUMERIC}",
            "</when>",
            "<when test=\"money!=null and money!=''\">",
            "AND amount= #{money,jdbcType=DOUBLE}",
            "</when>",
            "<when test=\"MacId!=null and MacId!=''\">",
            "AND Mac_id= #{MacId,jdbcType=NUMERIC}",
            "</when>",
            "</script>"

    })
    List<Consume> selectByCDMAmount(@Param("carId") Long carId, @Param("money") Double money, @Param("MacId") Long MacId);//通过消费金额,卡机编号查询用户的消费记录

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

}
