package g2.controller.admin;

import g2.model.Card;
import g2.model.Usertype;
import g2.service.CardService;
import g2.service.UsertypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/card")
public class CardController {
    private final CardService cardService;
    private final UsertypeService usertypeService;

    public CardController(CardService cardService, UsertypeService usertypeService) {
        this.cardService = cardService;
        this.usertypeService = usertypeService;
    }


    @RequestMapping("")
    public String indexCard(Model model, Long id, String type, Double money) {
        List<String> list = usertypeService.selectType();
        List<Card> card = cardService.selectByIT(id, type);
        model.addAttribute("id", id);
        model.addAttribute("type", type);
        model.addAttribute("list", list);
        model.addAttribute("card", card);
        if (money != null && id == null) {
            cardService.addMoney(type, money);
            return "redirect:/admin/card";
        } else if (money != null && id != null) {
            cardService.reCharge(id, money);
            return "redirect:/admin/card";
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
    public String change(Model model, Long id, String state) {
        cardService.updateByType(id, state);
        model.addAttribute("id", id);
        return "redirect:/admin/card";
    }

    @RequestMapping("/insert")
    public String insert() {
        return "admin/cardInsert";
    }

    @RequestMapping("/insertDo")
    public String insertDo(Long id, String type, String state, Double amount, Double limit) {
        Card card = new Card(null, type, state, amount, limit);
        Usertype usertype = new Usertype(type);
        cardService.insertById(usertype, card);
        return "redirect:/admin/card";
    }
    /*@RequestMapping("/delete")
    public String delete(Long id){
        cardService.deleteById(id);
        return "redirect:/admin/card";
    }*/
   /* @RequestMapping("/recharge")
    public String reCharge(Model model ,Long id,Double money){
        model.addAttribute("id",id);
        model.addAttribute("money",money);
        cardService.reCharge(id,money);
        return "redirect:/admin/card/";
    }*/


}
