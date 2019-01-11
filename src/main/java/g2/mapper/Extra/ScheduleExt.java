package g2.mapper.Extra;

import g2.model.Schedule;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ScheduleExt {
    @Select({"select * from schedule"})
    public List<Schedule> selectAll();
}
