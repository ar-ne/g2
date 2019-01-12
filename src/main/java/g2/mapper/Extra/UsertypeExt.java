package g2.mapper.Extra;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UsertypeExt {
    @Select({"select distinct type",
            "from usertype"
    })
    List<String> selectType();

    @Select({"select distinct type",
            "from usertype",
            "where ",
            "type= #{type,jdbcType=VARCHAR}"
    })
    String selectByType(String type);
}
