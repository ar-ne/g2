package g2.service;

import g2.mapper.UnitMapper;
import g2.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class UnitService {
    private final UnitMapper unitmapper;
    private Unit unit;
    @Autowired
    public UnitService(UnitMapper unitmapper) {
        this.unitmapper = unitmapper;
    }


    public List<Unit> UnitGet(Long id, String type) {
        return unitmapper.getd(id, type);
    }

    public int UnitDelete(Long id) {
        return unitmapper.deleteByPrimaryKey(id);
    }

    public int UnitUpdate(Unit unit) {
        return unitmapper.updateByPrimaryKeySelective(unit);
    }

    public Unit unitselectbyid(Long id) {
        return unitmapper.selectByPrimaryKey(id);
    }

    public int unitInsert(Unit unit) {
        return unitmapper.insertSelective(unit);
    }

}
