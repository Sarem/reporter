package com.aio.aionet.reporter.model;

import lombok.Data;

@Data
public class ContentPurchaseReport {
    private Long contentId;
    private String showTitle;
    private Long seasonId;
    private Long episode_id;
    private Long provider_id;
    private Long oneDayViews;
    private Long oneWeekViews;
    private Long oneMountViews;
    private Long oneYearViews;
}
