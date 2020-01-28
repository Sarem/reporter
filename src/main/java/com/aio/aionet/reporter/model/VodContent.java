package com.aio.aionet.reporter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "public")
public class VodContent {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Show show;
    private String title;
    private String visible;
    private String onFrontPage;
    private Double durationMin;
    private java.sql.Timestamp addedTimestamp;
    private Long userIdModified;
    private Long userIdCreated;
    private java.sql.Timestamp dateModified;
    private java.sql.Timestamp dateCreated;
    private String hd;
    private String showInGenres;
    private java.sql.Timestamp visibleFrom;
    private java.sql.Timestamp visibleTo;
    private Long vodTemplateId;
    private Long videoSystemId;
    private String finishedTranscoded;
    private Long defaultSubtitleId;
    private Long defaultAudiotrackId;
    private String assetName;
    private String deleted;
    private String prechunked;
    private String promoClip;
    private Long generalTermsId;
    private Long seasonId;
    private Long episodeId;
    private Long providerId;

}
