package g2.service;

import g2.mapper.StuffMapper;
import g2.model.Stuff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuffService {
    private final
    StuffMapper stuffMapper;

    @Autowired
    public StuffService(StuffMapper stuffMapper) {
        this.stuffMapper = stuffMapper;
    }

    @Nullable
    public List<Stuff> getAll() {
        return stuffMapper.selectAll();
    }

    public Stuff get(Long id) {
        return stuffMapper.selectByPrimaryKey(id);
    }

    public int add(Stuff stuff) {
        return stuffMapper.insertSelective(stuff);
    }

    public int update(Stuff stuff) {
        return stuffMapper.updateByPrimaryKey(stuff);
    }

    public int delete(Long id) {
        return stuffMapper.deleteByPrimaryKey(id);
    }
}
