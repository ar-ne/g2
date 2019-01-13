package g2.mapper.Extra;

import g2.model.Machine;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MachineExt {
    @Delete({
            "delete from Machine",
            "where Uni_id = #{id,jdbcType=NUMERIC}"
    })
    int DeleteByUnitId(Long id);

    @Delete({
            "delete from Machine",
            "where id = #{id,jdbcType=NUMERIC}"
    })
    int deleteById(Long id);

    @Select({
            "select",
            "id",
            "from Machine",
            "where Uni_id = #{id,jdbcType=NUMERIC}"
    })
    List<Long> SelectByUnitId(Long id);

    @Select({
            "select",
            "distinct",
            "addr",
            "from Machine"
    })
    List<String> getAddr();

    @Select({"<script>",
            "select ",
            "id, Uni_id,addr",
            "from Machine",
            "where 1=1",
            "<when test=\"id!=null and id!=''\">",
            "AND id= #{id,jdbcType=NUMERIC}",
            "</when>",
            "<when test=\"Uni_id!=null and Uni_id!=''\">",
            "AND Uni_id = #{Uni_id,jdbcType=NUMERIC}",
            "</when>",
            "</script>"})
    List<Machine> GetByTwoId(@Param("id") Long id, @Param("Uni_id") Long Uni_id);

//    @Select({
//            "select",
//            "addr",
//            "from Machine",
//            "where Uni_id = #{id,jdbcType=NUMERIC}"
//    })
//    List<Long> getAddrByMacID(Long MacID);

    @Select({"SElect * from machine where uni_id=#{id,jdbcType=NUMERIC}"})
    List<Machine> selectMachinesByUnitID(Long id);
}
