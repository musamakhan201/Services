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
@Table(name = "user_requests")
public class SeoRequestDomain {
    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("request_id")
    @Column(name = "request_id")
    private int requestId;
    @JsonProperty("website_name")
    @Column(name = "website_name")
    private String websiteName;
    @JsonProperty("website_url")
    @Column(name = "website_url")
    private String websiteUrl;
    @JsonProperty("login_username")
    @Column(name = "login_username")
    private String loginUsername;
    @JsonProperty("login_password")
    @Column(name = "login_password")
    private String loginPassword;
    private String keywords;
    @Column(columnDefinition="DATETIME")
    private String time;
    @JsonProperty("deadline")
    @Column(name = "deadline")
    private String deadlineTime;
    @JsonProperty("additional_comment")
    @Column(name = "additional_comment")
    private String additionalComment;
    private int id;

    public SeoRequestDomain() {
        ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
        time = utc.format(DateTimeFormatter.ofPattern(DATETIME_FORMAT));
    }
}
