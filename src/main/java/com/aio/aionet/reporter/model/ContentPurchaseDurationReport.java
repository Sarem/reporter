package com.aio.aionet.reporter.model;

import lombok.Data;

@Data
public class ContentPurchaseDurationReport {

    private Long contentId;
    private String showTitle;
    private String assetName;
    private Long seasonId;
    private Long episode_id;
    private Long provider_id;
    private Long customViews;
}
