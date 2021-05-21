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
@Table(name = "service_done")
public class DoneServiceDomain {
    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("seo_id")
    @Column(name = "seo_id")
    private int seoId;
    @JsonProperty("website_name")
    @Column(name = "website_name")
    private String websiteName;
    @JsonProperty("website_url")
    @Column(name = "website_url")
    private String websiteUrl;
    @Column(columnDefinition="DATETIME")
    private String time;
    private String guidance;
    private int id;

    public DoneServiceDomain() {
        ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
        time = utc.format(DateTimeFormatter.ofPattern(DATETIME_FORMAT));
    }
}
