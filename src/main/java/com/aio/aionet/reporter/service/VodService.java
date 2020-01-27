package com.aio.aionet.reporter.service;

import com.aio.aionet.reporter.model.ContentPurchaseReport;
import com.aio.aionet.reporter.model.VodContent;
import com.aio.aionet.reporter.model.VodPurchaseReportMapper;
import com.aio.aionet.reporter.repository.ShowRepository;
import com.aio.aionet.reporter.repository.VodContentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VodService {

    private VodContentRepository vodContentRepository;
//    private ShowRepository showRepository;
    private VodPurchaseReportMapper vodPurchaseReportMapper;

    @Transactional
    public List<ContentPurchaseReport> reports() {
        final List<VodContent> contentList = vodContentRepository.findAll();
        return vodPurchaseReportMapper.toReport(contentList);
    }
}