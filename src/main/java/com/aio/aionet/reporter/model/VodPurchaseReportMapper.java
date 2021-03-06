package com.aio.aionet.reporter.model;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VodPurchaseReportMapper {

    @Mapping(target = "showTitle",source = "show.title")
    @Mapping(target = "contentId",source = "id")
    ContentPurchaseReport toReport(VodContent vodContent);

    List<ContentPurchaseReport> toReport(List<VodContent> vodContents);

    @Mapping(target = "contentId",source = "id")
    @Mapping(target = "showTitle",source = "show.title")
    ContentPurchaseDurationReport toCustomReport(VodContent vodContents);

    List<ContentPurchaseDurationReport> toCustomReport(List<VodContent> vodContents);



}
