package me.flyray.rbac;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;

/** 
* @author: bolei
* @date：2017年4月11日 下午6:31:31 
* @description：类说明 
*/

public class ExcelExportTest {

	static List<CourseEntity> list = new ArrayList<CourseEntity>();
    CourseEntity       courseEntity;
    
	public static void main(String[] args) throws IOException {
		Date start = new Date();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("2412312", "测试", "测试"),
            CourseEntity.class, list);
        System.out.println(new Date().getTime() - start.getTime());
        File savefile = new File("D:/excel/");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream("D:/excel/基本导出测试.xls");
        workbook.write(fos);
        fos.close();
	}

}
