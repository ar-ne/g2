package g2.service;

import g2.mapper.ChargeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChargeService {
    private final ChargeMapper chargeMapper;

    @Autowired
    public ChargeService(ChargeMapper chargeMapper) {
        this.chargeMapper = chargeMapper;
    }

    public int deleteByMacId(Long id) {
        return chargeMapper.DeleteByMacId(id);
    }

    public int deleteByCardId(Long id) {
        return chargeMapper.DeleteByCardId(id);
    }
  /*  public int deleteByName(String name) {
        return chargeMapper.DeleteByName(name);
    }*/
}


