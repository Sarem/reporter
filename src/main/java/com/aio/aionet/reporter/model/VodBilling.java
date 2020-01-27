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
//@Table(schema = "show")
public class VodBilling {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private VodContent vodContent;

    private LocalDateTime date;

}
