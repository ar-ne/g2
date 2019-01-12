package g2.service;

import g2.mapper.ScheduleMapper;
import g2.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    private final ScheduleMapper scheduleMapper;

    @Autowired
    public ScheduleService(ScheduleMapper scheduleMapper) {
        this.scheduleMapper = scheduleMapper;
    }

    public List<Schedule> getAll() {
        return scheduleMapper.selectAll();
    }

    public List<Long> getIdList() {
        return scheduleMapper.getIdAll();
    }

    public int add(Schedule schedule) {
        return scheduleMapper.insertSelective(schedule);
    }

    public Schedule get(Long id) {
        return scheduleMapper.selectByPrimaryKey(id);
    }

    public int update(Schedule schedule) {
        return scheduleMapper.updateByPrimaryKeySelective(schedule);
    }

    public int delete(Long id) {
        return scheduleMapper.deleteByPrimaryKey(id);
    }

}
