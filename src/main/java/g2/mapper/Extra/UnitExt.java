package g2.mapper.Extra;

import g2.model.Unit;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UnitExt {

    @Select({"<script>",
            "select * from Unit",
            "where 1=1",
            "<when test='id!=null'>",
            "AND id= #{id}",
            "</when>",
            "<when test='type!=null'>",
            "AND type= #{type}",
            "</when>",
            "</script>"})
    List<Unit> get(int id, String type);
    }
