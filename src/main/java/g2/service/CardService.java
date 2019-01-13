package g2.service;

import g2.mapper.CardMapper;
import g2.model.Card;
import g2.model.Usertype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    private final CardMapper cardMapper;
    private final UsertypeService usertypeService;
    private final ConsumeService consumeService;
    private final ChargeService chargeService;
    private final UserService userService;

    public CardService(CardMapper cardMapper, UsertypeService usertypeService, ConsumeService consumeService, ChargeService chargeService, UserService userService) {
        this.cardMapper = cardMapper;
        this.usertypeService = usertypeService;
        this.consumeService = consumeService;
        this.chargeService = chargeService;
        this.userService = userService;
    }

    @Autowired


    public List<String> selectType() {
        return cardMapper.selectType();
    }

    public List<Card> selectByIT(Long id, String type) {
        return cardMapper.selectByIT(id, type);
    }

    public int support(String type, Double money) {
        return cardMapper.support(type, money);
    }

    public int updateByType(Long id, String state) {
        return cardMapper.updateByType(id, state);
    }

    public int insertById(Usertype usertype, Card card) {
        if (usertypeService.selectByType(usertype.getType()) == null) {
            usertypeService.insertType(usertype);
        }
        return cardMapper.insertSelective(card);
    }

    public int reCharge(Long id, Double money) {
        return cardMapper.recharge(id, money);
    }

    public Card get(Long id) {
        return cardMapper.selectByPrimaryKey(id);
    }
}
