package g2.controller;

import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseController {

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new MyDateEditor());
        binder.registerCustomEditor(Double.class, new DoubleEditor());
        binder.registerCustomEditor(Integer.class, new IntegerEditor());
    }

    private class MyDateEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date = null;
            try {
                date = format.parse(text);
            } catch (ParseException e) {
                try {
                    date = format.parse(text.replace("T", " "));
                } catch (ParseException f) {
                    format = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        date = format.parse(text);
                    } catch (ParseException ignored) {
                    }
                }
            }
            setValue(date);
        }
    }

    public class DoubleEditor extends PropertiesEditor {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            if (text == null || text.equals("")) {
                text = "0";
            }
            setValue(Double.parseDouble(text));
        }

        @Override
        public String getAsText() {
            return getValue().toString();
        }
    }

    public class IntegerEditor extends PropertiesEditor {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            if (text == null || text.equals("")) {
                text = "0";
            }
            setValue(Integer.parseInt(text));
        }

        @Override
        public String getAsText() {
            return getValue().toString();
        }
    }

}