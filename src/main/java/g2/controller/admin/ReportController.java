package g2.controller.admin;

import g2.model.Consume;
import g2.service.ReportService;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/admin/report")
public class ReportController {
    private ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @RequestMapping("/")
    public String indexreport() {
        reportService.reportUser();
        return "admin/indexReport";
    }

    @RequestMapping("/user")
    public String userreport() {
        reportService.reportUser();
        return "admin/indexReport";
    }
}
