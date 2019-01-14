package g2.service;

import g2.mapper.CardMapper;
import g2.model.Card;
import g2.model.Usertype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
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

    /**
     * 创建卡并返回创建的卡
     *
     * @param usertype 用户类型，判断是否存在，不存在则添加
     * @param card     待创建的卡，id应为null
     * @return 新创建的卡，若创建时出错返回null
     */
    @Nullable
    public Card addCard(Usertype usertype, Card card) {
        if (usertypeService.selectByType(usertype.getType()) == null) {
            usertypeService.insertType(usertype);
        }
        int r = cardMapper.insertSelective(card);
        if (r == 1)
            return cardMapper.selectLast();
        else return null;
    }

    public int reCharge(Long id, Double money) {
        return cardMapper.recharge(id, money);
    }

    public Card get(Long id) {
        return cardMapper.selectByPrimaryKey(id);
    }

    public int update(Card card) {
        return cardMapper.updateByPrimaryKeySelective(card);
    }

    public Card selectLast() {
        return cardMapper.selectLast();
    }

    public int selectCount(String state) {
        return cardMapper.selectCount(state);
    }
}
