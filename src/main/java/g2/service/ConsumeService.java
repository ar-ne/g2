package g2.service;

import g2.mapper.ConsumeMapper;
import g2.model.Consume;
import javafx.util.Pair;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.HashMap;

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

    //    public List<Long> selectByCDateAmount(Long carId, Date time){
//        return consumeMapper.selectByCDateAmount(carId,time);
//    }
    public List<Consume> getCosumeList(Long carID) {
        return consumeMapper.getCosumeList(carID);
    }

    public List<Consume> selectByCDMAmount(Long carID, Double money, Long MacId) {
        return consumeMapper.selectByCDMAmount(carID, money, MacId);
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

    public Map<String, Object> statisticsAmount_AmountCount(int section) {
        Map<String, Object> result = new HashMap<>();
        List<Consume> consumeList = consumeMapper.getAll();
        int max = 0, min = Integer.MAX_VALUE;
        List<Double> amounts = new ArrayList<>();
        for (Consume consume : consumeList) {
            amounts.add(consume.getAmount());
            max = (int) (Math.max(consume.getAmount(), max) + 1);
            min = (int) Math.min(consume.getAmount(), min);
        }
        int step = ((max - min) / section);
        if (step == 0) step = 1;
        result.put("step", step);
        result.put("section", section);

        //初始化计数表data，值全为0
        //初始化标签表label，值为每段min-max
        int[] data = new int[section];
        String[] label = new String[section];
        List<Pair<Integer, Integer>> MMVs = new ArrayList<>();//Min-Max-Value(Pairs)
        for (int i = 0, v0 = min; i < section; i++) {
            MMVs.add(new Pair<>(v0, v0 + step));
            label[i] = MMVs.get(i).getKey() + "~" + MMVs.get(i).getValue();
            v0 += step + 1;
        }
        result.put("label", label);

        for (Double amount : amounts) {
            for (int i = 0; i < MMVs.size(); i++) {
                if (amount >= MMVs.get(i).getKey() && amount <= MMVs.get(i).getValue()) {
                    data[i]++;
                    break;
                }
            }
        }
        result.put("data", data);
        return result;
    }
}
