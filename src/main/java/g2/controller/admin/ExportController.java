package g2.controller.admin;

import g2.service.ExportService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/report")
public class ExportController {
    private ExportService exportService;

    public ExportController(ExportService exportService) {
        this.exportService = exportService;
    }

    @RequestMapping("")
    public String indexreport() {
        return "admin/indexReport";
    }

    @RequestMapping("/user")
    @ResponseBody
    public String userreport() {
        exportService.reportUser();
        return "success";
    }

    @RequestMapping("/unit")
    @ResponseBody
    public String unitreport() {
        exportService.reportUnit();
        return "success";
    }
}
