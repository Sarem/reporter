package com.aio.aionet.reporter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "public")
public class VodBilling {
    @Id
    @GeneratedValue
    private Long id;
    private java.sql.Timestamp purchaseTime;
    private String transferred;
    private Double timeOfPurchasePrice;
    private Long profileId;
    @ManyToOne
    @JoinColumn(name="content_id")
    private VodContent vodContent;
    private Long timeOfPurchasePricerangeId;
    private java.sql.Timestamp validUntil;
    private String shared;
    private Long campaignId;
    private Long campaignVodDiscountId;
    private String subscriberId;
    private String ip;
    private String deviceName;
    private String failed;
    private Long packetId;
    private Long networkId;

}
