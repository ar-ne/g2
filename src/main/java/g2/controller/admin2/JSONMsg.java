package g2.controller.admin2;

import com.alibaba.fastjson.JSON;
import org.springframework.web.servlet.ModelAndView;

class JSONMsg extends ModelAndView {

    JSONMsg(String jMsg) {
        this.setViewName("/admin2/jsonMsg");
        this.addObject("msg", jMsg);
    }

    JSONMsg(PlainMessage plainMessage) {
        this.setViewName("/admin2/jsonMsg");
        this.addObject("msg", JSON.toJSONString(plainMessage));
    }

    JSONMsg(Object o) {
        this.setViewName("/admin2/jsonMsg");
        this.addObject("msg", JSON.toJSONString(o));
    }

    static class PlainMessage {
        String msg;

        PlainMessage(String msg) {
            this.msg = msg;
        }

        @Override
        public String toString() {
            return JSON.toJSONString(this);
        }
    }
}
