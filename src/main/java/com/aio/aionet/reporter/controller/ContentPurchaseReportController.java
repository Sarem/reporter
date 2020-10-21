package com.aio.aionet.reporter.controller;

import com.aio.aionet.reporter.model.ContentPurchaseDurationReport;
import com.aio.aionet.reporter.model.ContentPurchaseReport;
import com.aio.aionet.reporter.model.CustomCsvRequest;
import com.aio.aionet.reporter.service.VodService;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.catalina.connector.Response;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@RestController
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
        response.setCharacterEncoding("UTF-8");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");
        //create a csv writer
        StatefulBeanToCsv<ContentPurchaseReport> writer = new StatefulBeanToCsvBuilder<ContentPurchaseReport>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();

        //write all vod to csv file
        writer.write(vodService.reports());
    }


//    @Operation(summary = "aaaaa", description = "", tags = {"vod"})
    @GetMapping(value = "/export-custom-vod/{id}/{from}/{to}" )
    public void exportCustomCSV(HttpServletResponse response, @PathVariable Long id, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to) throws Exception {
        //set file name and content type
        String filename = "custom-reports-id.csv";
        response.setContentType("text/csv");
        response.setCharacterEncoding("UTF-8");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");
        //create a csv writer
        StatefulBeanToCsv<ContentPurchaseDurationReport> writer = new StatefulBeanToCsvBuilder<ContentPurchaseDurationReport>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();
        //write all vod to csv file
//        CustomCsvRequest customCsvRequest;
        writer.write(vodService.customReport(new CustomCsvRequest(id,from,to)));
    }

    @GetMapping(value = "/export-all-custom-vod/{from}/{to}" )
    public void exportAllCustomCSV(HttpServletResponse response, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to) throws Exception {
        //set file name and content type
        String filename = "all-custom-reports.csv";
        response.setContentType("text/csv");
        response.setCharacterEncoding("UTF-8");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");
        //create a csv writer
        StatefulBeanToCsv<ContentPurchaseDurationReport> writer = new StatefulBeanToCsvBuilder<ContentPurchaseDurationReport>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();
        //write all vod to csv file
//        CustomCsvRequest customCsvRequest;
        writer.write(vodService.customReports(from,to));
    }

    @GetMapping(value = "/export-custom-vod-by-asset/{asset}/{from}/{to}" )
    public void exportCustomCSV(HttpServletResponse response, @PathVariable String asset, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to) throws Exception {
        //set file name and content type
        String filename = "custom-reports-asset.csv";
        response.setContentType("text/csv");
        response.setCharacterEncoding("UTF-8");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");
        //create a csv writer
        StatefulBeanToCsv<ContentPurchaseDurationReport> writer = new StatefulBeanToCsvBuilder<ContentPurchaseDurationReport>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();
        //write all vod to csv file
//        CustomCsvRequest customCsvRequest;
        writer.write(vodService.customReportByAsset(asset,from,to));
    }


}