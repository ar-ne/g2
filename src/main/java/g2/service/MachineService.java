package g2.service;

import g2.mapper.MachineMapper;
import g2.model.Machine;
import g2.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MachineService {
    private final MachineMapper machineMapper;
    private final ConsumeService consumeService;
    private final ChargeService chargeService;

    @Autowired
    public MachineService(MachineMapper machineMapper, ConsumeService consumeService,
                          ChargeService chargeService) {
        this.machineMapper = machineMapper;
        this.consumeService = consumeService;
        this.chargeService = chargeService;
    }

    /**
     * 根据单位ID删除刷卡机
     * 同时删除消费记录和收费记录
     *
     * @param id 单位ID
     * @return 被影响行数量
     */
    public int deleteByUnitId(Long id) {
        List<Long> macList = selectByUnitId(id);
        int count = 0;
        if (macList != null)
            for (int i = 0; i < macList.size(); i++) {
                count += consumeService.deleteByMacId(macList.get(i));
                count += chargeService.deleteByMacId(macList.get(i));
            }
        return machineMapper.DeleteByUnitId(id) + count;
    }

    public List<Long> selectByUnitId(Long id) {
        return machineMapper.SelectByUnitId(id);
    }

    public List<Machine> getMachineByUnit(Long id) {
        return machineMapper.selectMachinesByUnitID(id);
    }

    public List<Machine> getByTwoId(Long id, Long Uni_id) {
        return machineMapper.GetByTwoId(id, Uni_id);
    }

    public int insertSelective(Machine machine) {
        return machineMapper.insertSelective(machine);
    }

    public int deleteById(Long id) {
        return consumeService.deleteByMacId(id) + chargeService.deleteByMacId(id) + machineMapper.deleteById(id);
    }

    public int updateByPrimaryKey(Machine machine) {
        return machineMapper.updateByPrimaryKeySelective(machine);
    }

    public Machine selectByPrimaryKey(Long id) {
        return machineMapper.selectByPrimaryKey(id);
    }
}
