package g2.service;

import g2.mapper.CardMapper;
import g2.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    private final CardMapper cardMapper;

    @Autowired
    public CardService(CardMapper cardMapper) {
        this.cardMapper = cardMapper;
    }

    public List<String> selectType() {
        return cardMapper.selectType();
    }

    public List<Card> selectByIT(Long id, String type) {
        return cardMapper.selectByIT(id, type);
    }

    public int addMoney(String type, Double money) {
        return cardMapper.addMoney(type, money);
    }

    public int updateByType(Long id, String state) {
        return cardMapper.updateByType(id, state);
    }

    public int insertById(Card card) {
        return cardMapper.insertSelective(card);
    }

    public int reCharge(Long id, Double money) {
        return cardMapper.recharge(id, money);
    }
}
