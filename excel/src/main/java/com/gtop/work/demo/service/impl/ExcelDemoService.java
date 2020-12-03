package com.gtop.work.demo.service.impl;

import com.gtop.work.demo.entity.Person;
import com.gtop.work.demo.service.IExcelDemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hongzw@citycloud.com.cn
 */
@Slf4j
@Service
public class ExcelDemoService implements IExcelDemoService {

    @Override
    public void exportExcel(HttpServletResponse response) {
        Workbook workbook = new HSSFWorkbook();
        // 设置表
        Sheet sheet = setSheet(workbook);

        // 设置表头
        setRowHeader(sheet);

        // 填充数据
        filledRowData(sheet);

        // 生成excel并返回
        buildExcelAndResponse(sheet, response);

    }

    private void buildExcelAndResponse(Sheet sheet, HttpServletResponse response) {
        Workbook workbook = sheet.getWorkbook();

        String fileName = null;
        try {
            // 为了解决文件名乱码问题
            fileName = new String(("测试表-" + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + ".xls").getBytes(), "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            log.error("新建excel名称出错{}", e.getMessage());
        }

        response.setContentType("application/octet-stream; charset=utf-8");
        StringBuffer contentDisposition = new StringBuffer("attachment; filename=\"");
        contentDisposition.append(fileName).append("\"");
        response.setHeader("Content-disposition", contentDisposition.toString());

        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            workbook.write(out);
            out.flush();
            out.close();
        } catch (IOException e) {
            log.error("读取流操作异常{}", e.getMessage());
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                log.error("关闭异常{}", e.getMessage());
            }
        }

    }

    private void filledRowData(Sheet sheet) {
        List<Person> personList = new ArrayList<>();
        personList.add(Person.builder().username("Faker").age(18).build());
        for (int i = 0; i < personList.size(); i++) {
            Row row = sheet.createRow(i + 1);
            setCellValue(row, 0, personList.get(i).getUsername(), null);
            setCellValue(row, 1, personList.get(i).getAge(), null);
        }
    }

    private void setCellValue(Row row, int index, Object value, String format) {
        Cell cell = row.createCell(index);
        if (format != null) {
            Workbook workbook = row.getSheet().getWorkbook();
            CellStyle cellStyle = workbook.createCellStyle();
            DataFormat dataFormat = workbook.createDataFormat();
            cellStyle.setDataFormat(dataFormat.getFormat(format));

            cell.setCellStyle(cellStyle);
        }
        if (value instanceof Number) {
            cell.setCellValue(Double.parseDouble(value.toString()));
        } else if (value instanceof Boolean) {
            cell.setCellValue((boolean) value);
        } else if (value instanceof String) {
            cell.setCellValue(value.toString());
        }

    }

    private void setRowHeader(Sheet sheet) {
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("姓名");
        row.createCell(1).setCellValue("年龄");
    }

    private Sheet setSheet(Workbook workbook) {
        return workbook.createSheet("测试表");
    }

}
