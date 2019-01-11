package g2.controller.admin;

import g2.model.Card;
import g2.service.CardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/card")
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @RequestMapping("/")
    public String indexCard(Model model, Long id, String type, Double money) {
        List<String> list = cardService.selectType();
        List<Card> card = cardService.selectByIT(id, type);
        model.addAttribute("id", id);
        model.addAttribute("type", type);
        model.addAttribute("list", list);
        model.addAttribute("card", card);
        if (money != null && id == null) {
            cardService.addMoney(type, money);
            return "redirect:/admin/card/";
        } else if (money != null && id != null) {
            cardService.reCharge(id, money);
            return "redirect:/admin/card/";
        } else
            return "admin/indexCard";
    }

    /* @RequestMapping("/add")
     public String addMoney(Model model,String type,Double money){
         model.addAttribute("type",type);
         model.addAttribute("money",money);
         cardService.addMoney(type,money);
         return "redirect:/admin/card/";
 }*/
    @RequestMapping("/update")
    public String change(Long id, String state) {
        cardService.updateByType(id, state);
        return "redirect:/admin/card/";
    }

    @RequestMapping("/insert")
    public String insert() {
        return "admin/cardInsert";
    }

    @RequestMapping("/insertDo")
    public String insertDo(Long id, String type, String state, Double amount, Double limit) {
        Card card = new Card(null, type, state, amount, limit);
        cardService.insertById(card);
        return "redirect:/admin/card/";
    }
   /* @RequestMapping("/recharge")
    public String reCharge(Model model ,Long id,Double money){
        model.addAttribute("id",id);
        model.addAttribute("money",money);
        cardService.reCharge(id,money);
        return "redirect:/admin/card/";
    }*/


}
