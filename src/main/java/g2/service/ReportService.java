package g2.service;

import g2.mapper.ConsumeMapper;
import g2.model.Consume;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class ReportService {
    private ConsumeMapper consumeMapper;

    @Autowired
    public ReportService(ConsumeMapper consumeMapper) {
        this.consumeMapper = consumeMapper;
    }

    public void reportUser() {
        //将数据导出到EXCEL表
        try {
            WritableWorkbook wwb = null;
            // 创建可写入的Excel工作簿
            String fileName = "C://book.xls";
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            //以fileName为文件名来创建一个Workbook
            wwb = Workbook.createWorkbook(file);

            // 创建消费表
            WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
            //查询所有消费记录
            List<Consume> con = consumeMapper.getAll();
            //要插入到的Excel表格的行号，默认从0开始
            Label labelId = new Label(0, 0, "id");
            Label labelcId = new Label(1, 0, "Car_id");
            Label labeluId = new Label(2, 0, "User_id");
            Label labelamount = new Label(3, 0, "amount");
            Label labeltime = new Label(4, 0, "time");
            Label labelresult = new Label(5, 0, "result");
            Label labelresaon = new Label(6, 0, "resaon");

            ws.addCell(labelId);
            ws.addCell(labelcId);
            ws.addCell(labeluId);
            ws.addCell(labelamount);
            ws.addCell(labeltime);
            ws.addCell(labelresult);
            ws.addCell(labelresaon);

            for (int i = 0; i < con.size(); i++) {
                Label label_Id = new Label(0, i + 1, con.get(i).getId() + "");
                Label label_cId = new Label(1, i + 1, con.get(i).getCar_id() + "");
                Label label_uId = new Label(2, i + 1, con.get(i).getCar_id() + "");
                Label label_amount = new Label(3, i + 1, con.get(i).getAmount() + "");
                Label label_time = new Label(4, i + 1, con.get(i).getTime() + "");
                Label label_result = new Label(5, i + 1, con.get(i).getResult() + "");
                Label label_resaon = new Label(6, i + 1, con.get(i).getReason());

                ws.addCell(label_Id);
                ws.addCell(label_cId);
                ws.addCell(label_uId);
                ws.addCell(label_amount);
                ws.addCell(label_time);
                ws.addCell(label_result);
                ws.addCell(label_resaon);
            }
            //写进文档
            wwb.write();
            // 关闭Excel工作簿对象
            System.out.println("数据导出成功!");
            wwb.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
