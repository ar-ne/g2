package g2.service;

import g2.mapper.ConsumeMapper;
import g2.model.Consume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumeService {
    public final ConsumeMapper consumeMapper;

    @Autowired
    public ConsumeService(ConsumeMapper consumeMapper) {
        this.consumeMapper = consumeMapper;
    }

    public int deleteByMacId(Long id) {
        return consumeMapper.DeleteByMacId(id);
    }

    public int deleteByCardId(Long id) {
        return consumeMapper.DeleteByCardId(id);
    }
    /*public int deleteByName(String name) {
        return consumeMapper.DeleteByName(name);
    }*/
    public int insert(Consume consume) {
        return consumeMapper.insert(consume);
    }
}
