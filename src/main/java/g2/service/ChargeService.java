package g2.service;

import g2.mapper.ChargeMapper;
import g2.model.Charge;
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

    public int add(Charge charge) {
        return chargeMapper.insertSelective(charge);
    }

    public int deleteByCardId(Long id) {
        return chargeMapper.DeleteByCardId(id);
    }
  /*  public int deleteByName(String name) {
        return chargeMapper.DeleteByName(name);
    }*/
}


