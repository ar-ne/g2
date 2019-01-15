package g2.service;

import g2.mapper.ConsumeMapper;
import g2.model.Consume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConsumeService {
    public final ConsumeMapper consumeMapper;

    @Autowired
    public ConsumeService(ConsumeMapper consumeMapper) {
        this.consumeMapper = consumeMapper;
    }
//    public List<Long> getMacID(Long carID){
//        return consumeMapper.getMacID(carID);
//    }

    public List<Consume> getCosumeList(Long carID) {
        return consumeMapper.getCosumeList(carID);
    }

    public List<Consume> selectByCdAmount(Long carID, Double money) {
        return consumeMapper.selectByCdAmount(carID, money);
    }

    public List<Consume> getAll() {
        return consumeMapper.getAll();
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

    public Map<String, Object> statisticsTime_Count(int begin, int end) {
        Map<String, Object> result = new HashMap<>();
        List<Consume> consumes = getAll();
        int[] data = new int[end - begin + 1];
        String[] label = new String[end - begin + 1];
        for (int i = 0; i < label.length; i++) {
            label[i] = String.valueOf(begin + i);
        }
        for (int i = 0; i < consumes.size(); i++) {
            for (int j = 0; j < data.length; j++) {
                if (consumes.get(i).getTime().getHours() == j)
                    data[j]++;
            }
        }
        result.put("data", data);
        result.put("label", label);
        return result;
    }
  /*  public List<Integer> getNumDay(){

    }*/
}
