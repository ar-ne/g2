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

    public List<Consume> getConsumeListByMacID(Long carID, Long MacId) {
        return consumeMapper.getConsumeListByMacID(carID, MacId);
    }

    public List<Consume> getCosumeList(Long carID) {
        return consumeMapper.getCosumeList(carID);
    }

    public List<Consume> selectByCDMAmount(Long carID, Double money, Long MacId) {
        return consumeMapper.selectByCDMAmount(carID, money, MacId);
    }

    ;

    public int deleteByMacId(Long id) {
        return consumeMapper.DeleteByMacId(id);
    }
}
