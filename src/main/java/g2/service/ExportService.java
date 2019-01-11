package g2.service;

import g2.mapper.ChargeMapper;
import g2.mapper.ConsumeMapper;
import g2.model.Charge;
import g2.model.Consume;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class ExportService {
    private ConsumeMapper consumeMapper;
    private ChargeMapper chargeMapper;
    @Autowired
    public ExportService(ConsumeMapper consumeMapper, ChargeMapper chargeMapper) {
        this.consumeMapper = consumeMapper;
        this.chargeMapper = chargeMapper;
    }


    public void reportUser() {
        //将消费数据导出到EXCEL表
        try {
            WritableWorkbook wwb = null;
            // 创建可写入的Excel工作簿
            String fileName = "C:/index/consunme.xls";
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
            Label labeluId = new Label(2, 0, "name");
            Label labelName = new Label(3, 0, "Mac_id");
            Label labelamount = new Label(4, 0, "amount");
            Label labeltime = new Label(5, 0, "time");
            Label labelresult = new Label(6, 0, "result");
            Label labelresaon = new Label(7, 0, "resaon");

            ws.addCell(labelId);
            ws.addCell(labelcId);
            ws.addCell(labeluId);
            ws.addCell(labelName);
            ws.addCell(labelamount);
            ws.addCell(labeltime);
            ws.addCell(labelresult);
            ws.addCell(labelresaon);

            for (int i = 0; i < con.size(); i++) {
                Label label_Id = new Label(0, i + 1, con.get(i).getId() + "");
                Label label_cId = new Label(1, i + 1, con.get(i).getCar_id() + "");
                Label label_name = new Label(2, i + 1, con.get(i).getName() + "");
                Label label_uId = new Label(3, i + 1, con.get(i).getMac_id() + "");
                Label label_amount = new Label(4, i + 1, con.get(i).getAmount() + "");
                Label label_time = new Label(5, i + 1, con.get(i).getTime() + "");
                Label label_result = new Label(6, i + 1, con.get(i).getResult() + "");
                Label label_resaon = new Label(7, i + 1, con.get(i).getReason());

                ws.addCell(label_Id);
                ws.addCell(label_cId);
                ws.addCell(label_name);
                ws.addCell(label_uId);
                ws.addCell(label_amount);
                ws.addCell(label_time);
                ws.addCell(label_result);
                ws.addCell(label_resaon);
            }
            //写进文档
            wwb.write();
            // 关闭Excel工作簿对象
            System.out.println("用户消费数据导出成功!");
            wwb.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void reportUnit() {
        //将数据导出到EXCEL表
        try {
            WritableWorkbook wwb2 = null;
            // 创建可写入的Excel工作簿
            String fileName = "C:/index/charge.xls";
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            //以fileName为文件名来创建一个Workbook
            wwb2 = Workbook.createWorkbook(file);

            // 创建消费表
            WritableSheet ws2 = wwb2.createSheet("Test Shee 1", 0);
            //查询所有消费记录
            List<Charge> cha = chargeMapper.getAll();
            //要插入到的Excel表格的行号，默认从0开始
            Label labelId = new Label(0, 0, "id");
            Label labelcId = new Label(1, 0, "Car_id");
            Label labeluId = new Label(2, 0, "name");
            Label labelName = new Label(3, 0, "Mac_id");
            Label labelamount = new Label(4, 0, "amount");
            Label labeltime = new Label(5, 0, "time");
            Label labelresult = new Label(6, 0, "result");
            Label labelresaon = new Label(7, 0, "resaon");

            ws2.addCell(labelId);
            ws2.addCell(labelcId);
            ws2.addCell(labeluId);
            ws2.addCell(labelName);
            ws2.addCell(labelamount);
            ws2.addCell(labeltime);
            ws2.addCell(labelresult);
            ws2.addCell(labelresaon);

            for (int i = 0; i < cha.size(); i++) {
                Label label_Id = new Label(0, i + 1, cha.get(i).getId() + "");
                Label label_cId = new Label(1, i + 1, cha.get(i).getCar_id() + "");
                Label label_name = new Label(2, i + 1, cha.get(i).getName() + "");
                Label label_uId = new Label(3, i + 1, cha.get(i).getMac_id() + "");
                Label label_amount = new Label(4, i + 1, cha.get(i).getAmount() + "");
                Label label_time = new Label(5, i + 1, cha.get(i).getTime() + "");
                Label label_result = new Label(6, i + 1, cha.get(i).getResult() + "");
                Label label_resaon = new Label(7, i + 1, cha.get(i).getReason());

                ws2.addCell(label_Id);
                ws2.addCell(label_cId);
                ws2.addCell(label_name);
                ws2.addCell(label_uId);
                ws2.addCell(label_amount);
                ws2.addCell(label_time);
                ws2.addCell(label_result);
                ws2.addCell(label_resaon);
            }
            //写进文档
            wwb2.write();
            // 关闭Excel工作簿对象
            System.out.println("单位收费数据导出成功!");
            wwb2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
