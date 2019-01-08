package g2.mapper.Extra;

import g2.model.Unit;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UnitExt {

    @Select({"select * from unit"})
    List<Unit> get(int id, String type);
    }
