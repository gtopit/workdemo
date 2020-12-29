package com.gtop.work.demo.controller;

import com.gtop.work.demo.service.IExcelDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.function.Function;

/**
 * @author hongzw@citycloud.com.cn
 */
@RestController
public class ExcelDemoController {

    @Autowired
    private IExcelDemoService excelDemoService;

    @GetMapping("/excel/export")
    public String export(HttpServletResponse response) {

        excelDemoService.exportExcel(response);

        return "ok";
    }

}
