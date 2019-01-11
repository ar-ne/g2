package g2.mapper.Extra;

import g2.model.Stuff;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StuffExt {
    @Select({"SELECT",
            "*",
            "FROM",
            "stuff"})
    List<Stuff> selectAll();
}
