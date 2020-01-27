package com.aio.aionet.reporter.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
//@Table(schema = "show")
public class VodBilling {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
//    @Column(name = "content_id")
    private VodContent vodContent;

    private Date date;

}
