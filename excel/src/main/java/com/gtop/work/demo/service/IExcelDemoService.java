package com.gtop.work.demo.service;

import javax.servlet.http.HttpServletResponse;

/**
 * @author hongzw@citycloud.com.cn
 */
public interface IExcelDemoService {

    /**
     * excel导出
     * @param response
     */
    void exportExcel(HttpServletResponse response);
}
