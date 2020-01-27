package com.aio.aionet.reporter.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
//@Table(schema = "show")
public class Show {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
}
