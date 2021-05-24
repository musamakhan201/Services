package com.seo.app.Services.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@ToString
@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "service_progress")
public class ProgressDomain {
    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("progress_id")
    @Column(name = "progress_id")
    private int progressId;
    private String percentage;
    private int user;
    @Column(columnDefinition="DATETIME")
    private String time;

    public ProgressDomain() {
        ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
        time = utc.format(DateTimeFormatter.ofPattern(DATETIME_FORMAT));
    }
}
