package com.aio.aionet.reporter.service;

import com.aio.aionet.reporter.model.*;
import com.aio.aionet.reporter.repository.ShowRepository;
import com.aio.aionet.reporter.repository.VodBillingRepository;
import com.aio.aionet.reporter.repository.VodContentRepository;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Service
@AllArgsConstructor
@SuppressWarnings({ "rawtypes", "unchecked" })
public class VodService {

    private VodContentRepository vodContentRepository;
    private ShowRepository showRepository;
    private VodBillingRepository vodBillingRepository;
    private VodPurchaseReportMapper vodPurchaseReportMapper;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<ContentPurchaseReport> reports() {
        final List<VodContent> contentList = vodContentRepository.findAll();
        final List<ContentPurchaseReport> contentPurchaseReports =
                vodPurchaseReportMapper.toReport(contentList);
        System.out.println(contentPurchaseReports.size());
        IntStream.range(0, contentPurchaseReports.size()).parallel().forEach(i -> {
            if(i%1000==0){
                System.out.println(i);
            }
            findBillings(contentPurchaseReports.get(i));
        });


//        contentPurchaseReports.parallelStream().forEach(contentPurchaseReport -> {
//            findBillings(contentPurchaseReport);
//        });
        return contentPurchaseReports;
    }
    private void findBillings(ContentPurchaseReport contentPurchaseReport){
        contentPurchaseReport.setOneDayViews(getContOfView(contentPurchaseReport.getContentId(),LocalDateTime.now().minusDays(1)));
        contentPurchaseReport.setOneWeekViews(getContOfView(contentPurchaseReport.getContentId(),LocalDateTime.now().minusWeeks(1)));
        contentPurchaseReport.setOneMountViews(getContOfView(contentPurchaseReport.getContentId(),LocalDateTime.now().minusMonths(1)));
        contentPurchaseReport.setOneYearViews(getContOfView(contentPurchaseReport.getContentId(),LocalDateTime.now().minusYears(1)));
    }

    private Long getContOfView(Long id,LocalDateTime time){
        var qVodBilling = QVodBilling.vodBilling;
        var query = new JPAQuery(entityManager);
        query.from(qVodBilling)
                .where(qVodBilling.vodContent.id.eq(id)
                        .and(qVodBilling.validUntil.after(Timestamp.valueOf(time))))
                .distinct();
        return query.fetchCount();
    }

    //TODO remove
    public void insertTestData(){
//        createTestVodContent("Baby Boss");
//        createTestVodContent("Toy story");
    }

    private void createTestVodContent(String title) {
//        Show show=new Show(null,title);
//        showRepository.save(show);
//        VodContent vodContent=new VodContent(null,show,1L,1L,1L);
//        vodContentRepository.save(vodContent);
//        List<VodBilling> vodBillings=new ArrayList<>();
//        for (int i=1;i<100;i++){
//            final LocalDateTime localDateTime = LocalDateTime.now().minusDays(i);
//            VodBilling vodBilling=new VodBilling(null,vodContent,localDateTime);
//            vodBillings.add(vodBilling);
//        }
//        vodBillingRepository.saveAll(vodBillings);
    }
}