package g2.mapper.java;

import g2.model.Unit;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UnitMapper{
    List<Unit> get(@Param("id")Long id,@Param("type")String type);
}