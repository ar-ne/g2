package g2.service;

import g2.mapper.ConsumeMapper;
import g2.model.Consume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumeService {
    public final ConsumeMapper consumeMapper;

    @Autowired
    public ConsumeService(ConsumeMapper consumeMapper) {
        this.consumeMapper = consumeMapper;
    }

    public List<Consume> getCosumeList(Long carID) {
        return consumeMapper.getCosumeList(carID);
    }

    public int deleteByMacId(Long id) {
        return consumeMapper.DeleteByMacId(id);
    }
}
