package g2.service;

import g2.mapper.UnitMapper;
import g2.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {
    private final UnitMapper unitmapper;
    private final MachineService machineService;
    private final ConsumeService consumeService;
    private final ChargeService chargeService;

    @Autowired
    public UnitService(UnitMapper unitmapper, MachineService machineService, ConsumeService consumeService, ChargeService chargeService) {
        this.unitmapper = unitmapper;
        this.machineService = machineService;
        this.consumeService = consumeService;
        this.chargeService = chargeService;
    }


    public List<Unit> UnitGet(Long id, String type) {
        return unitmapper.getd(id, type);
    }

    /**
     * 根据单位id同时删除单位和刷卡机
     *
     * @param id 单位id
     * @return 被影响的行数目
     * @see MachineService#deleteByUnitId(Long)
     */
    public int delete(Long id) {
        return machineService.deleteByUnitId(id) + unitmapper.deleteByPrimaryKey(id);

    }

    public int update(Unit unit) {
        return unitmapper.updateByPrimaryKeySelective(unit);
    }

    public Unit getByPrimaryKey(Long id) {
        return unitmapper.selectByPrimaryKey(id);
    }

    public int add(Unit unit) {
        return unitmapper.insertSelective(unit);
    }

    public List<Long> getIdList() {
        return unitmapper.getIdAll();
    }
}
