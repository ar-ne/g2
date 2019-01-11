package g2.util.properties;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class NamePropertiesMap {
    public static final Map stuff;

    static {
        stuff = Collections.unmodifiableMap(new HashMap<String, String>() {{
            put("id", "员工编号");
            put("uni_id", "单位编号");
            put("sch_id", "排班编号");
            put("name", "员工姓名");
        }});
    }
}
