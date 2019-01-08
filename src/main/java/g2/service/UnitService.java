package g2.service;

import g2.mapper.UnitMapper;
import g2.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {
    private final UnitMapper unitmapper;

    @Autowired
    public UnitService(UnitMapper unitmapper) {
        this.unitmapper = unitmapper;
    }


    public List<Unit> UnitGet(int id,String type){
       return unitmapper.get(id,type);
    }

}
