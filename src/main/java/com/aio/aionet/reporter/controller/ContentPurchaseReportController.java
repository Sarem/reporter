package com.aio.aionet.reporter.controller;

import com.aio.aionet.reporter.model.ContentPurchaseReport;
import com.aio.aionet.reporter.model.User;
import com.aio.aionet.reporter.model.VodContent;
import com.aio.aionet.reporter.service.VodService;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class ContentPurchaseReportController {

    private VodService vodService;

    public ContentPurchaseReportController(VodService userService) {
        this.vodService = userService;
    }

    @GetMapping("/export-vod")
    public void exportCSV(HttpServletResponse response) throws Exception {

        //set file name and content type
        String filename = "reports.csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");

        //create a csv writer
        StatefulBeanToCsv<ContentPurchaseReport> writer = new StatefulBeanToCsvBuilder<ContentPurchaseReport>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();

        //write all users to csv file
        writer.write(vodService.reports());

    }
}