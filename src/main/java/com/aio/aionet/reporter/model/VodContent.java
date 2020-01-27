package com.aio.aionet.reporter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Table(schema = "public")
public class VodContent {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Show show;
    private Long seasonId;
    private Long episode_id;
    private Long provider_id;

}
