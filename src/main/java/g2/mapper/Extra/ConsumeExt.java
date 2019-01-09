package g2.mapper.Extra;

import g2.model.Consume;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ConsumeExt {
    @Select({
            "select",
            "id, Car_id, Use_id, amount, time, result, reason",
            "from consumelog",
    })
    List<Consume> getAll();//查询所有消费记录
}
