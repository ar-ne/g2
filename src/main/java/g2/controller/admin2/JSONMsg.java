package g2.controller.admin2;

import com.alibaba.fastjson.JSON;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

public class JSONMsg extends ModelAndView {
    public JSONMsg(String msg) {
        this.setViewName("/admin2/jsonMsg");
        this.addObject("msg", msg);
    }

    public JSONMsg(Object o) {
        this.setViewName("/admin2/jsonMsg");
        this.addObject("msg", JSON.toJSONString(o));
    }

    public JSONMsg(List list) {
        this.setViewName("/admin2/jsonMsg");
        this.addObject("msg", JSON.toJSONString(list));
    }

    public JSONMsg(Map map) {
        this.setViewName("/admin2/jsonMsg");
        this.addObject("msg", JSON.toJSONString(map));
    }
}
