package com.aio.aionet.reporter.service;

import com.aio.aionet.reporter.model.*;
import com.aio.aionet.reporter.repository.ShowRepository;
import com.aio.aionet.reporter.repository.VodBillingRepository;
import com.aio.aionet.reporter.repository.VodContentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VodService {

    private VodContentRepository vodContentRepository;
    private ShowRepository showRepository;
    private VodBillingRepository vodBillingRepository;

    private VodPurchaseReportMapper vodPurchaseReportMapper;

    @Transactional
    public List<ContentPurchaseReport> reports() {
        final List<VodContent> contentList = vodContentRepository.findAll();
        final List<ContentPurchaseReport> contentPurchaseReports =
                vodPurchaseReportMapper.toReport(contentList);
//        contentPurchaseReports. TODO add counts
        return contentPurchaseReports;
    }

    //TODO remove
    public void insertTestData(){
        Show show=new Show(null,"Baby Boss");
        showRepository.save(show);
        VodContent vodContent=new VodContent(null,show,1L,1L,1L);
        vodContentRepository.save(vodContent);
        List<VodBilling> vodBillings=new ArrayList<>();
        for (int i=1;i<100;i++){
            final LocalDateTime localDateTime = LocalDateTime.now().minusDays(i);
            VodBilling vodBilling=new VodBilling(null,vodContent,localDateTime);
            vodBillings.add(vodBilling);
        }
        vodBillingRepository.saveAll(vodBillings);
    }
}