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
@Table(name = "admin_notifications")
public class AdminNotificationDomain {
    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("notification_id")
    @Column(name = "notification_id")
    private int notificationId;
    private String user;
    private String title;
    private String body;
    private String date_time;
    public AdminNotificationDomain() {
        ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
        date_time = utc.format(DateTimeFormatter.ofPattern(DATETIME_FORMAT));
    }
}
