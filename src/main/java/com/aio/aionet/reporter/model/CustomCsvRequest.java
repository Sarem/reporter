package com.aio.aionet.reporter.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomCsvRequest {
    Long contentId;
    LocalDateTime from;
    LocalDateTime to;
}
