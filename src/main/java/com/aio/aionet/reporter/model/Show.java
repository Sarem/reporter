package com.aio.aionet.reporter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "shows")
public class Show {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String shortDescription;
    private String longDescription;
    private String boxOffice;
    private Long oscarsNominated;
    private Long oscarsWon;
    private Long showTypeId;
    private java.sql.Timestamp firstAired;
    private Long userIdModified;
    private Long userIdCreated;
    private java.sql.Timestamp dateCreated;
    private java.sql.Timestamp dateModified;
    private Long epgImageId;
    private Long vodImageId;
    private String originalTitle;
    private String epgShow;
    private String vodShow;
    private java.sql.Timestamp productionFrom;
    private java.sql.Timestamp productionTo;
    private String epgSubtitle;
}
