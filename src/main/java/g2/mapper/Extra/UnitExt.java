package g2.mapper.Extra;

import g2.model.Unit;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UnitExt {

    @Select({"<script>",
            "select ",
            "id, type, account, password, pnum",
            "from Unit",
            "where 1=1",
            "<when test=\"id!=null and id!=''\">",
            "AND id= #{id,jdbcType=NUMERIC}",
            "</when>",
            "<when test=\"type!=null and type!=''\">",
            "AND type= #{type,jdbcType=VARCHAR}",
            "</when>",
            "</script>"})
    List<Unit> getd(@Param("id") Long id, @Param("type") String type);//数据库查询方法

    @Select({
            "select ",
            " id",
            "from Unit"
    })
    List<Long> getIdAll();

    @Select({"select * from Unit"})
    List<Unit> selectAll();
}
