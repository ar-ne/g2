package g2.controller.admin;

import g2.model.Consume;
import g2.service.CardService;
import g2.service.ConsumeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/admin/data")
public class DataAnaly {
    private CardService cardService;
    private ConsumeService consumeService;

    public DataAnaly(CardService cardService, ConsumeService consumeService) {
        this.cardService = cardService;
        this.consumeService = consumeService;
    }

    @RequestMapping("")
    public String index() {
        return "admin/indexDataAnaly";
    }

    @RequestMapping("jsData")
    public ModelAndView jsData() {
        ModelAndView modelAndView = new ModelAndView("admin/jsData");
        int n1 = cardService.selectCount("正常");
        int n2 = cardService.selectCount("冻结");
        //  System.out.println(n1);
        //   System.out.println(n2);
        int[] num = {0, 0, 0, 0, 0, 0, 0};
        modelAndView.addObject("n1", n1);
        modelAndView.addObject("n2", n2);
        List<Consume> consumes = consumeService.getAll();
        for (int i = 0; i < consumes.size(); i++) {
            if (consumes.get(i).getTime() != null) {
                Date date = consumes.get(i).getTime();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                int n = calendar.get(Calendar.DAY_OF_WEEK);
                // System.out.println(n);
                String day = "";
                switch (n) {
                    case 1:
                        day = "星期一";
                        num[0]++;
                        break;
                    case 2:
                        day = "星期二";
                        num[1]++;
                        break;
                    case 3:
                        day = "星期三";
                        num[2]++;
                        break;
                    case 4:
                        day = "星期四";
                        num[3]++;
                        break;
                    case 5:
                        day = "星期五";
                        num[4]++;
                        break;
                    case 6:
                        day = "星期六";
                        num[5]++;
                        break;
                    case 7:
                        day = "星期日";
                        num[6]++;
                        break;
                }
                // System.out.println(day);
            }
        }
        List<Integer> numList = new LinkedList<Integer>();
        for (int i = 0; i < 7; i++) {
            numList.add(num[i]);
            //   System.out.print(num[i]);
        }
        modelAndView.addObject("numList", numList);
        Map TCG = consumeService.statisticsTime_Count(6, 21);
        modelAndView.addObject("TCdata", TCG.get("data"));
        modelAndView.addObject("TClabel", TCG.get("label"));

        Map CAG = consumeService.statisticsAmount_AmountCount(10);
        modelAndView.addObject("Cdata", CAG.get("data"));
        modelAndView.addObject("Clabel", CAG.get("label"));
        return modelAndView;
    }
}
